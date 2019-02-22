package cn.com.ut.service;

import org.springframework.data.domain.Page;

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
import cn.com.ut.util.PageInfo;

/**
 * @Description: 商品管理业务层接口
 * @Author wangpeng1
 * @Date 2018/11/5 9:50
 */
public interface GoodsService {

	/**
	 * 创建商品
	 * 
	 * @param goodsCreateVo
	 * @return
	 */
	String addGoods(GoodsCreateVo goodsCreateVo);

	/**
	 * 编辑商品
	 * 
	 * @param goodsUpdateVo
	 */
	void updateGoods(GoodsUpdateVo goodsUpdateVo);

	/**
	 * 查询商品详情
	 *
	 * @param goodsId
	 * @return
	 */
	Goods findOne(String goodsId);

	/**
	 * 删除商品
	 *
	 * @param goodsIdVo
	 */
	void delete(GoodsIdVo goodsIdVo);

	/**
	 * 批量删除商品
	 *
	 * @param goodsIdListVo
	 */
	void batchDelete(GoodsIdListVo goodsIdListVo);

	/**
	 * 查询所有的商品（带分页）
	 *
	 * @param pageInfo
	 * @return
	 */
	Page<Goods> list(PageInfo pageInfo);

	/**
	 * 更新商品库存
	 * 
	 * @param goodsStorageVo
	 */
	void updateGoodsStorage(GoodsStorageVo goodsStorageVo);

	/**
	 * 更新商品价格
	 * 
	 * @param goodsPriceVo
	 */
	void updateGoodsPrice(GoodsPriceVo goodsPriceVo);

	/**
	 * 更新商品上下架状态
	 *
	 * @param goodsStateVo
	 */
	void updateGoodsState(GoodsStateVo goodsStateVo);

	/**
	 * 批量更新商品上下架状态
	 *
	 * @param goodsStateBatchUpdateVo
	 */
	void batchUpdateGoodsState(GoodsStateBatchUpdateVo goodsStateBatchUpdateVo);

	/**
	 * 更新商品详情页内容
	 *
	 * @param goodsBodyVo
	 */
	void updateGoodsContent(GoodsBodyVo goodsBodyVo);

	/**
	 * 获取商品详情页内容
	 *
	 * @param goodsIdVo
	 * @return
	 */
	GoodsBodyVo getGoodsContent(GoodsIdVo goodsIdVo);

	/**
	 * 更新商品扩展信息
	 *
	 * @param goodsExtendInfoVo
	 */
	void updateGoodsExtendInfo(GoodsExtendInfoVo goodsExtendInfoVo);

	/**
	 * 获取商品扩展信息
	 *
	 * @param goodsIdVo
	 * @return
	 */
	GoodsExtendInfoVo getGoodsExtendInfo(GoodsIdVo goodsIdVo);
}
