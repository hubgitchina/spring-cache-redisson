package cn.com.ut.pojo;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsByStoreIdQueryRespVo {

	/**
	 * 商品ID
	 */
	private String goodsId;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品描述
	 */
	private String goodsDesc;

	/**
	 * 商品分类ID
	 */
	private String gcId;

	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;

	/**
	 * 商品折扣
	 */
	private BigDecimal goodsDiscount;

	/**
	 * 总库存
	 */
	private Integer goodsStorage;

	/**
	 * 扩展信息JSON
	 */
	private String extendInfo;

	/**
	 * 应用关联商品ID
	 */
	private String refId;

	/**
	 * 商品状态 0:下架 1:正常 10:违规（禁售）2:编辑
	 */
	private String goodsState;

	/**
	 * 商品图片集合
	 */
	private List<ImageQueryRespVo> goodsImage;

	public GoodsByStoreIdQueryRespVo(String goodsId, String goodsName, String goodsDesc,
			String gcId, BigDecimal goodsPrice, BigDecimal goodsDiscount, Integer goodsStorage,
			String extendInfo, String refId, String goodsState) {

		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.gcId = gcId;
		this.goodsPrice = goodsPrice;
		this.goodsDiscount = goodsDiscount;
		this.goodsStorage = goodsStorage;
		this.extendInfo = extendInfo;
		this.refId = refId;
		this.goodsState = goodsState;
	}
}