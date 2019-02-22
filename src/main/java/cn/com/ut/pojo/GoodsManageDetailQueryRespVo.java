package cn.com.ut.pojo;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsManageDetailQueryRespVo {

	/**
	 * 店铺ID
	 */
	private String storeId;

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
	 * 商品分类
	 */
	private String gcId;

	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;

	/**
	 * 商品市场价
	 */
	private BigDecimal goodsMarketprice;

	/**
	 * 商品库存
	 */
	private Integer goodsStorage;

	/**
	 * 商品内容
	 */
	private String goodsBody;

	/**
	 * 扩展信息JSON
	 */
	private String extendInfo;

	/**
	 * 商品关联商品分组集合
	 */
	private List<StoreGoodsclassDetailRespVo> goodsGroups;

	/**
	 * 商品图片集合
	 */
	private List<ImageQueryRespVo> goodsImage;

	/**
	 * 属性和属性值组合
	 */
	private List<GoodsclassRelationAttrRespVo> goodsAttr;

	public GoodsManageDetailQueryRespVo(String storeId, String goodsId, String goodsName,
			String goodsDesc, String gcId, BigDecimal goodsPrice, BigDecimal goodsMarketprice,
			Integer goodsStorage, String goodsBody, String extendInfo) {

		this.storeId = storeId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.gcId = gcId;
		this.goodsPrice = goodsPrice;
		this.goodsMarketprice = goodsMarketprice;
		this.goodsStorage = goodsStorage;
		this.goodsBody = goodsBody;
		this.extendInfo = extendInfo;
	}
}