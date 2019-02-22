package cn.com.ut.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import cn.com.ut.util.IdRespVO;
import cn.com.ut.util.ResponseInfo;

/**
 * @Description: 商品管理控制层
 * @Author wangpeng1
 * @Date 2018/11/5 9:50
 */
@RestController
@RequestMapping("/goods")
public class GoodsManageController {

	@Autowired
	private GoodsService goodsService;

	/**
	 * 创建商品
	 * 
	 * @param goodsCreateVo
	 * @return
	 */
	@PostMapping("/addGoods")
	public ResponseInfo<IdRespVO> createGoods(@RequestBody @Valid GoodsCreateVo goodsCreateVo) {

		String id = goodsService.addGoods(goodsCreateVo);
		return ResponseInfo.build().appendData(new IdRespVO(id));
	}

	/**
	 * 更新商品信息
	 *
	 * @param goodsUpdateVo
	 * @return
	 */
	@PostMapping("/updateGoods")
	public ResponseInfo updateGoods(@RequestBody @Valid GoodsUpdateVo goodsUpdateVo) {

		goodsService.updateGoods(goodsUpdateVo);
		return ResponseInfo.build();

	}

	@PostMapping("/findOne")
	public ResponseInfo<Goods> findOne(@RequestBody @Valid GoodsIdVo goodsIdVo) {

		Goods goods = goodsService.findOne(goodsIdVo.getGoodsId());
		return ResponseInfo.build().appendData(goods);

	}

	/**
	 * 更新商品扩展信息
	 * 
	 * @param goodsExtendInfoVo
	 * @return
	 */
	@PostMapping("/updateGoodsExtendInfo")
	public ResponseInfo updateGoodsExtendInfo(
			@RequestBody @Valid GoodsExtendInfoVo goodsExtendInfoVo) {

		goodsService.updateGoodsExtendInfo(goodsExtendInfoVo);
		return ResponseInfo.build();

	}

	/**
	 * 获取商品扩展信息
	 *
	 * @param goodsIdVo
	 * @return
	 */
	@PostMapping("/getGoodsExtendInfo")
	public ResponseInfo<GoodsExtendInfoVo> getGoodsExtendInfo(
			@RequestBody @Valid GoodsIdVo goodsIdVo) {

		GoodsExtendInfoVo goodsExtendInfo = goodsService.getGoodsExtendInfo(goodsIdVo);
		return ResponseInfo.build().appendData(goodsExtendInfo);

	}

	/**
	 * 更新商品上下架状态
	 *
	 * @param goodsStateVo
	 * @return
	 */
	@PostMapping("/updateGoodsState")
	public ResponseInfo updateGoodsState(@RequestBody @Valid GoodsStateVo goodsStateVo) {

		goodsService.updateGoodsState(goodsStateVo);
		return ResponseInfo.build();

	}

	/**
	 * 批量更新商品上下架状态
	 *
	 * @param goodsStateBatchUpdateVo
	 * @return
	 */
	@PostMapping("/batchUpdateGoodsState")
	public ResponseInfo batchUpdateGoodsState(
			@RequestBody @Valid GoodsStateBatchUpdateVo goodsStateBatchUpdateVo) {

		goodsService.batchUpdateGoodsState(goodsStateBatchUpdateVo);
		return ResponseInfo.build();

	}

	/**
	 * 删除商品
	 *
	 * @param goodsIdVo
	 * @return
	 */
	@PostMapping("/delete")
	public ResponseInfo delete(@RequestBody @Valid GoodsIdVo goodsIdVo) {

		goodsService.delete(goodsIdVo);
		return ResponseInfo.build();
	}

	/**
	 * 批量删除商品
	 *
	 * @param goodsIdListVo
	 * @return
	 */
	@PostMapping("/batchDelete")
	public ResponseInfo batchDelete(@RequestBody @Valid GoodsIdListVo goodsIdListVo) {

		goodsService.batchDelete(goodsIdListVo);
		return ResponseInfo.build();
	}

	/**
	 * 更新商品库存
	 * 
	 * @param goodsStorageVo
	 * @return
	 */
	@PostMapping("/updateGoodsStorage")
	public ResponseInfo updateGoodsStorage(@RequestBody @Valid GoodsStorageVo goodsStorageVo) {

		goodsService.updateGoodsStorage(goodsStorageVo);
		return ResponseInfo.build();
	}

	/**
	 * 更新商品价格
	 * 
	 * @param goodsPriceVo
	 * @return
	 */
	@PostMapping("/updateGoodsPrice")
	public ResponseInfo updateGoodsPrice(@RequestBody @Valid GoodsPriceVo goodsPriceVo) {

		goodsService.updateGoodsPrice(goodsPriceVo);
		return ResponseInfo.build();
	}

	/**
	 * 更新商品详情页内容
	 *
	 * @param goodsBodyVo
	 * @return
	 */
	@PostMapping("/updateGoodsContent")
	public ResponseInfo updateGoodsBody(@RequestBody @Valid GoodsBodyVo goodsBodyVo) {

		goodsService.updateGoodsContent(goodsBodyVo);
		return ResponseInfo.build();

	}

	/**
	 * 获取商品详情页内容
	 *
	 * @param goodsIdVo
	 * @return
	 */
	@PostMapping("/getGoodsContent")
	public ResponseInfo<GoodsBodyVo> getGoodsContent(@RequestBody @Valid GoodsIdVo goodsIdVo) {

		GoodsBodyVo goodsBody = goodsService.getGoodsContent(goodsIdVo);
		return ResponseInfo.build().appendData(goodsBody);

	}
}
