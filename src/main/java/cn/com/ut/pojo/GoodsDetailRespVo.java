package cn.com.ut.pojo;

import java.math.BigDecimal;

import cn.com.ut.util.RestInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDetailRespVo extends RestInfo {

	/**
	 * 商品ID
	 */
	private String id;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品广告词
	 */
	private String goodsAdvword;

	/**
	 * 商品分类
	 */
	private String gcId;

	/**
	 * 商品分类名称
	 */
	private String gcName;

	/**
	 * 店铺id
	 */
	private String storeId;

	/**
	 * 店铺名称
	 */
	private String storeName;

	/**
	 * 品牌id
	 */
	private String brandId;

	/**
	 * 品牌名称
	 */
	private String brandName;

	/**
	 * 类型id
	 */
	private String typeId;

	/**
	 * 类型名称
	 */
	private String typeName;

	/**
	 * 规格值
	 */
	private String specValue;

	/**
	 * 商品属性
	 */
	// private String goodsAttr;

	/**
	 * 商品内容
	 */
	// private String goodsBody;

	/**
	 * 商品状态 0:下架 1:正常 10:违规（禁售）
	 */
	// private String goodsState;

	/**
	 * 违规原因
	 */
	// private String goodsStateremark;

	/**
	 * 商品审核 1通过，0未通过，10审核中
	 */
	// private Integer goodsVerify;

	/**
	 * 审核失败原因
	 */
	// private String goodsVerifyremark;

	/**
	 * 商品锁定 0未锁，1已锁
	 */
	// private Integer goodsLock;

	/**
	 * 商品添加时间
	 */
	// private Date goodsAddtime;

	/**
	 * 上架时间
	 */
	// private Timestamp goodsShelftime;

	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;

	/**
	 * 最低价
	 */
	private BigDecimal priceMin;

	/**
	 * 最高价
	 */
	private BigDecimal priceMax;

	/**
	 * 商品市场价
	 */
	private BigDecimal goodsMarketprice;

	/**
	 * 商品成本价
	 */
	private BigDecimal goodsCostprice;

	/**
	 * 商品折扣
	 */
	private BigDecimal goodsDiscount;

	/**
	 * 商家编号
	 */
	private String goodsSerial;

	/**
	 * 总库存
	 */
	private Integer goodsStorage;

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
	 * 商品分类完整路径冗余，方便按分类或子分类查询商品
	 */
	// private String gcFullpath;

	/**
	 * 销量
	 */
	private Long goodsSalenum;

	/**
	 * 商品默认图片
	 */
	private String imagePath;

	/**
	 * 扩展信息JSON
	 */
	private String extendInfo;

	/**
	 * 评价数
	 */
	private Long evaluationCount;

	public GoodsDetailRespVo(String id, String goodsName, String goodsAdvword, String gcId,
			String gcName, String storeId, String brandId, String brandName, String typeId,
			String typeName, String specValue, BigDecimal goodsPrice, BigDecimal priceMin,
			BigDecimal priceMax, BigDecimal goodsMarketprice, BigDecimal goodsCostprice,
			BigDecimal goodsDiscount, String goodsSerial, Integer goodsStorage,
			Integer goodsStorageAlarm, Integer goodsCommend, BigDecimal goodsFreight,
			Integer goodsVat, Integer isVirtual, Long goodsSalenum, String imagePath,
			String extendInfo, Long evaluationCount) {

		this.id = id;
		this.goodsName = goodsName;
		this.goodsAdvword = goodsAdvword;
		this.gcId = gcId;
		this.gcName = gcName;
		this.storeId = storeId;
		this.brandId = brandId;
		this.brandName = brandName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.specValue = specValue;
		this.goodsPrice = goodsPrice;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.goodsMarketprice = goodsMarketprice;
		this.goodsCostprice = goodsCostprice;
		this.goodsDiscount = goodsDiscount;
		this.goodsSerial = goodsSerial;
		this.goodsStorage = goodsStorage;
		this.goodsStorageAlarm = goodsStorageAlarm;
		this.goodsCommend = goodsCommend;
		this.goodsFreight = goodsFreight;
		this.goodsVat = goodsVat;
		this.isVirtual = isVirtual;
		this.goodsSalenum = goodsSalenum;
		this.imagePath = imagePath;
		this.extendInfo = extendInfo;
		this.evaluationCount = evaluationCount;
	}
}