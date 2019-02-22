package cn.com.ut.pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsIndexQueryRespVo {

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
	 * 店铺ID
	 */
	private String storeId;

	/**
	 * 店铺名称
	 */
	private String storeName;

	/**
	 * 分类ID
	 */
	private String gcId;

	/**
	 * 商品默认图片
	 */
	private String goodsImage;

	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;

	/**
	 * 商品折扣
	 */
	private BigDecimal goodsDiscount;

	/**
	 * 商品推荐 1:是 0:否
	 */
	private Integer goodsCommend;

	/**
	 * 商品销量
	 */
	private Long goodsSalenum;

	/**
	 * 扩展信息JSON
	 */
	private String extendInfo;

	/**
	 * 应用关联商品ID
	 */
	private String refId;

	public GoodsIndexQueryRespVo(String goodsId, String goodsName, String goodsDesc, String storeId,
			String gcId, String goodsImage, BigDecimal goodsPrice, BigDecimal goodsDiscount,
			Integer goodsCommend, Long goodsSalenum, String extendInfo, String refId) {

		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.storeId = storeId;
		this.gcId = gcId;
		this.goodsImage = goodsImage;
		this.goodsPrice = goodsPrice;
		this.goodsDiscount = goodsDiscount;
		this.goodsCommend = goodsCommend;
		this.goodsSalenum = goodsSalenum;
		this.extendInfo = extendInfo;
		this.refId = refId;
	}
}