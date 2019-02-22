package cn.com.ut.pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreGoodsQueryRespVo {

	/**
	 * 商品ID
	 */
	private String goodsId;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 店铺ID
	 */
	private String storeId;

	/**
	 * 店铺名称
	 */
	private String storeName;

	/**
	 * 商品默认图片
	 */
	private String goodsImage;

	/**
	 * 商品价格范围最小值
	 */
	private BigDecimal goodsPriceMin;

	/**
	 * 商品价格范围最大值
	 */
	private BigDecimal goodsPriceMax;

	/**
	 * 商品市场价
	 */
	private BigDecimal goodsMarketprice;

	/**
	 * 商品推荐 1:是 0:否
	 */
	private Integer goodsCommend;

	public StoreGoodsQueryRespVo(String goodsId, String goodsName, String storeId,
			String goodsImage, BigDecimal goodsPriceMin, BigDecimal goodsPriceMax,
			BigDecimal goodsMarketprice, Integer goodsCommend) {

		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.storeId = storeId;
		this.goodsImage = goodsImage;
		this.goodsPriceMin = goodsPriceMin;
		this.goodsPriceMax = goodsPriceMax;
		this.goodsMarketprice = goodsMarketprice;
		this.goodsCommend = goodsCommend;
	}
}