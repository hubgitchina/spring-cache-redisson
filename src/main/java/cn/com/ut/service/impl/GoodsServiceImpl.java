package cn.com.ut.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import cn.com.ut.dao.GoodsRepository;
import cn.com.ut.entity.Goods;
import cn.com.ut.pojo.GoodsBodyVo;
import cn.com.ut.pojo.GoodsCreateVo;
import cn.com.ut.pojo.GoodsExtendInfoVo;
import cn.com.ut.pojo.GoodsIdListVo;
import cn.com.ut.pojo.GoodsIdVo;
import cn.com.ut.pojo.GoodsPriceVo;
import cn.com.ut.pojo.GoodsStateBatchUpdateVo;
import cn.com.ut.pojo.GoodsStateVo;
import cn.com.ut.pojo.GoodsStorageVo;
import cn.com.ut.pojo.GoodsUpdateVo;
import cn.com.ut.service.GoodsService;
import cn.com.ut.util.BizConstants;
import cn.com.ut.util.CommonUtil;
import cn.com.ut.util.ExceptionUtil;
import cn.com.ut.util.JPQLQueryUtil;
import cn.com.ut.util.PageInfo;

/**
 * @Description: 商品管理业务层接口实现类
 * @Author wangpeng1
 * @Date 2018/11/5 9:50
 */
@Service
@Transactional
public class GoodsServiceImpl extends JPQLQueryUtil implements GoodsService {

	@Autowired
	private GoodsRepository goodsRepository;

	private static final String userId = "666";

	@Override
	@CachePut(value = "goods", key = "#result")
	public String addGoods(GoodsCreateVo goodsCreateVo) {

		String storeId = goodsCreateVo.getStoreId();

		boolean isCanAdd = goodsRepository
				.existsByGoodsNameAndStoreIdAndIsDel(goodsCreateVo.getGoodsName(), storeId, "N");
		if (isCanAdd) {
			ExceptionUtil.throwServiceException("该店铺下已存在同名商品");
		}

		// 查询分类关联的类型ID，该值由后台获取之后设置新增商品的类型ID字段，非前端传入
		String typeId = "111";

		Goods goods = new Goods();
		BeanUtils.copyProperties(goodsCreateVo, goods);

		if (CommonUtil.isNotEmpty(typeId)) {
			goods.setTypeId(typeId);
		}

		// 生成商品编号
		String goodsSerial = "222";
		goods.setGoodsSerial(goodsSerial);

		goods.setAppId("333");

		goods.setPriceMin(goodsCreateVo.getGoodsPrice());
		goods.setPriceMax(goodsCreateVo.getGoodsPrice());

		Timestamp now = new Timestamp(System.currentTimeMillis());

		goods.setCreateId(userId);
		goods.setCreateTime(now);
		goods.setGoodsAddtime(now);

		goodsRepository.save(goods);

		String goodsId = goods.getId();

		return goodsId;
	}

	@Override
	public void updateGoods(GoodsUpdateVo goodsUpdateVo) {

		String goodsId = goodsUpdateVo.getGoodsId();
		Goods goods = goodsRepository.findOne(goodsId);
		if (goods == null) {
			ExceptionUtil.throwServiceException("商品不存在");
		}
		String storeId = goods.getStoreId();

		boolean isCanEdit = goodsRepository.existsByGoodsNameAndStoreIdAndIsDelAndIdNot(
				goodsUpdateVo.getGoodsName(), storeId, "N", goodsUpdateVo.getGoodsId());
		if (isCanEdit) {
			ExceptionUtil.throwServiceException("该店铺下已存在同名商品");
		}

		BeanUtils.copyProperties(goodsUpdateVo, goods);

		Timestamp now = new Timestamp(System.currentTimeMillis());

		goods.setUpdateId(userId);
		goods.setUpdateTime(now);

		goodsRepository.save(goods);
	}

	@Override
	@CacheEvict(value = "goods", key = "#goodsIdVo.goodsId")
	public void delete(GoodsIdVo goodsIdVo) {

		Timestamp now = new Timestamp(System.currentTimeMillis());

		goodsRepository.deleteByGoodsId("Y", "0", userId, now, goodsIdVo.getGoodsId());
	}

	@Override
	public void batchDelete(GoodsIdListVo goodsIdListVo) {

		Timestamp now = new Timestamp(System.currentTimeMillis());

		goodsRepository.batchDeleteByGoodsIds("Y", "0", userId, now, goodsIdListVo.getGoodsIds());
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "goods", key = "#goodsId", sync = true)
	public Goods findOne(String goodsId) {

		Goods goods = goodsRepository.findOne(goodsId);
		if (goods == null) {
			ExceptionUtil.throwServiceException("商品不存在");
		}
		return goods;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Goods> list(PageInfo pageInfo) {

		Sort sort = new Sort(Sort.Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(pageInfo.getPageno() - 1, pageInfo.getPagesize(), sort);
		return goodsRepository.findAll(pageable);
	}

	@Override
	public void updateGoodsStorage(GoodsStorageVo goodsStorageVo) {

		Timestamp now = new Timestamp(System.currentTimeMillis());

		goodsRepository.updateGoodsStorage(goodsStorageVo.getGoodsStorage(), userId, now,
				goodsStorageVo.getGoodsId());
	}

	@Override
	public void updateGoodsPrice(GoodsPriceVo goodsPriceVo) {

		Timestamp now = new Timestamp(System.currentTimeMillis());

		goodsRepository.updateGoodsPrice(goodsPriceVo.getGoodsPrice(), userId, now,
				goodsPriceVo.getGoodsId());
	}

	@Override
	public void updateGoodsState(GoodsStateVo goodsStateVo) {

		String goodsId = goodsStateVo.getGoodsId();
		GoodsStateVo goods = goodsRepository.getGoodsState(goodsId);
		if (goods == null) {
			ExceptionUtil.throwServiceException("商品不存在");
		}

		// 上下架商品之前，需要先检查商品是否违规（禁售）
		String oldGoodsState = goods.getGoodsState();
		if (oldGoodsState.equals(BizConstants.GoodsState.NO_SALE)) {
			ExceptionUtil.throwServiceException("违规（禁售）商品，不能进行操作");
		}

		Timestamp now = new Timestamp(System.currentTimeMillis());

		String newGoodsState = goodsStateVo.getGoodsState();

		// 判断是否为设置商品上架，1表示上架，同步设置表字段商品上架时间goods_shelftime
		if (BizConstants.GoodsState.ON_SHELF.equals(newGoodsState)) {
			// 上架商品
			goodsRepository.upGoods(newGoodsState, now, userId, now, goodsId);
		} else if (BizConstants.GoodsState.OFF_SHELF.equals(newGoodsState)) {
			// 下架商品
			goodsRepository.downGoods(newGoodsState, userId, now, goodsId);

			// 商品下架时，更新推广商品状态
			List<String> goodsIds = Lists.newArrayListWithCapacity(1);
			goodsIds.add(goodsId);
			// spreadGoodsClient.cancelByGoodsId(goodsIds);
		} else if (BizConstants.GoodsState.NO_SALE.equals(newGoodsState)) {
			// 更新商品状态为违规（禁售）商品
			goodsRepository.downGoods(newGoodsState, userId, now, goodsId);
		} else if (BizConstants.GoodsState.EDIT.equals(newGoodsState)) {
			// 更新商品状态为编辑状态（保存进草稿箱）
			goodsRepository.downGoods(newGoodsState, userId, now, goodsId);
		} else {
			ExceptionUtil.throwValidateException("商品状态有误");
		}
	}

	@Override
	public void batchUpdateGoodsState(GoodsStateBatchUpdateVo goodsStateBatchUpdateVo) {

		List<String> goodsIds = goodsStateBatchUpdateVo.getGoodsIds();
		for (String goodsId : goodsIds) {
			GoodsStateVo goods = goodsRepository.getGoodsState(goodsId);
			if (goods == null) {
				ExceptionUtil.throwServiceException("不存在ID为【" + goodsId + "】的商品");
			}

			// 上下架商品之前，需要先检查商品是否违规（禁售）
			String oldGoodsState = goods.getGoodsState();
			if (oldGoodsState.equals(BizConstants.GoodsState.NO_SALE)) {
				ExceptionUtil.throwServiceException("ID为【" + goodsId + "】的商品已违规（禁售），不能进行操作");
			}
		}

		Timestamp now = new Timestamp(System.currentTimeMillis());

		String newGoodsState = goodsStateBatchUpdateVo.getGoodsState();

		// 判断是否为设置商品上架，1表示上架，同步设置表字段商品上架时间goods_shelftime
		if (BizConstants.GoodsState.ON_SHELF.equals(newGoodsState)) {
			// 上架商品
			goodsRepository.batchUpGoods(newGoodsState, now, userId, now, goodsIds);
		} else if (BizConstants.GoodsState.OFF_SHELF.equals(newGoodsState)) {
			// 下架商品
			goodsRepository.batchDownGoods(newGoodsState, userId, now, goodsIds);

			// 商品下架时，更新推广商品状态
			// spreadGoodsClient.cancelByGoodsId(goodsIds);
		} else if (BizConstants.GoodsState.NO_SALE.equals(newGoodsState)) {
			// 更新商品状态为违规（禁售）商品
			goodsRepository.batchDownGoods(newGoodsState, userId, now, goodsIds);
		} else if (BizConstants.GoodsState.EDIT.equals(newGoodsState)) {
			// 更新商品状态为编辑状态（保存进草稿箱）
			goodsRepository.batchDownGoods(newGoodsState, userId, now, goodsIds);
		} else {
			ExceptionUtil.throwValidateException("商品状态有误");
		}
	}

	@Override
	public void updateGoodsContent(GoodsBodyVo goodsBodyVo) {

		Timestamp now = new Timestamp(System.currentTimeMillis());
		goodsRepository.updateGoodsBody(goodsBodyVo.getGoodsBody(), userId, now,
				goodsBodyVo.getGoodsId());
	}

	@Override
	@Transactional(readOnly = true)
	public GoodsBodyVo getGoodsContent(GoodsIdVo goodsIdVo) {

		return goodsRepository.getGoodsBody(goodsIdVo.getGoodsId());
	}

	@Override
	public void updateGoodsExtendInfo(GoodsExtendInfoVo goodsExtendInfoVo) {

		Timestamp now = new Timestamp(System.currentTimeMillis());
		goodsRepository.updateExtendInfo(goodsExtendInfoVo.getExtendInfo(), userId, now,
				goodsExtendInfoVo.getGoodsId());
	}

	@Override
	@Transactional(readOnly = true)
	public GoodsExtendInfoVo getGoodsExtendInfo(GoodsIdVo goodsIdVo) {

		return goodsRepository.getExtendInfo(goodsIdVo.getGoodsId());
	}
}
