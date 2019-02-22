package cn.com.ut.pojo;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDetailQueryRespVo {

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
	 * 商品分类ID
	 */
	private String gcId;

	/**
	 * 商品分类名称
	 */
	private String gcName;

	/**
	 * 品牌ID
	 */
	private String brandId;

	/**
	 * 品牌名称
	 */
	private String brandName;

	/**
	 * 类型ID
	 */
	private String typeId;

	/**
	 * 类型名称
	 */
	private String typeName;

	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;

	/**
	 * 商品市场价
	 */
	private BigDecimal goodsMarketprice;

	/**
	 * 商品折扣
	 */
	private BigDecimal goodsDiscount;

	/**
	 * 商家编号
	 */
	private String goodsSerial;

	/**
	 * 商品库存报警值
	 */
	private Integer goodsStorageAlarm;

	/**
	 * 商品推荐 1:是 0:否
	 */
	private Integer goodsCommend;

	/**
	 * 商品运费 0为免运费
	 */
	private BigDecimal goodsFreight;

	/**
	 * 商品是否开具增值税发票 1:是 0:否
	 */
	private Integer goodsVat;

	/**
	 * 是否为虚拟商品 1:是 0:否
	 */
	private Integer isVirtual;

	/**
	 * 总库存
	 */
	private Integer goodsStorage;

	/**
	 * 商品销量
	 */
	private Long goodsSalenum;

	/**
	 * 商品内容
	 */
	private String goodsBody;

	/**
	 * 评价数
	 */
	private Long evaluationCount;

	/**
	 * 扩展信息JSON
	 */
	private String extendInfo;

	/**
	 * 应用关联商品ID
	 */
	private String refId;

	/**
	 * 商品图片集合
	 */
	private List<ImageQueryRespVo> goodsImage;

	/**
	 * 规格和规格值ID组合
	 */
	private List<GoodsSpecQueryBo> goodsSpec;

	/**
	 * 属性和属性值ID组合
	 */
	private List<GoodsAttrQueryBo> goodsAttr;

	public GoodsDetailQueryRespVo(String goodsId, String goodsName, String goodsDesc,
			String storeId, String gcId, String gcName, String brandId, String brandName,
			String typeId, String typeName, BigDecimal goodsPrice, BigDecimal goodsMarketprice,
			BigDecimal goodsDiscount, String goodsSerial, Integer goodsStorageAlarm,
			Integer goodsCommend, BigDecimal goodsFreight, Integer goodsVat, Integer isVirtual,
			Integer goodsStorage, Long goodsSalenum, String goodsBody, Long evaluationCount,
			String extendInfo, String refId) {

		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.storeId = storeId;
		this.gcId = gcId;
		this.gcName = gcName;
		this.brandId = brandId;
		this.brandName = brandName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.goodsPrice = goodsPrice;
		this.goodsMarketprice = goodsMarketprice;
		this.goodsDiscount = goodsDiscount;
		this.goodsSerial = goodsSerial;
		this.goodsStorageAlarm = goodsStorageAlarm;
		this.goodsCommend = goodsCommend;
		this.goodsFreight = goodsFreight;
		this.goodsVat = goodsVat;
		this.isVirtual = isVirtual;
		this.goodsStorage = goodsStorage;
		this.goodsSalenum = goodsSalenum;
		this.goodsBody = goodsBody;
		this.evaluationCount = evaluationCount;
		this.extendInfo = extendInfo;
		this.refId = refId;
	}
}