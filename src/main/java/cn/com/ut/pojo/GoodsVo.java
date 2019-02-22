package cn.com.ut.pojo;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import cn.com.ut.util.RestInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsVo extends RestInfo {

	/**
	 * 商品ID
	 */
	private String goodsId;

	/**
	 * 商品名称
	 */
	@NotBlank(message = "商品名称不能为空")
	private String goodsName;

	/**
	 * 商品广告词
	 */
	private String goodsAdvword;

	/**
	 * 商品分类
	 */
	@NotBlank(message = "商品分类ID不能为空")
	private String gcId;

	/**
	 * 店铺id
	 */
	@NotBlank(message = "店铺ID不能为空")
	private String storeId;

	/**
	 * 规格值
	 */
	// private String specValue;

	/**
	 * 品牌id
	 */
	private String brandId;

	/**
	 * 类型id
	 */
	@NotBlank(message = "类型ID不能为空")
	private String typeId;

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
	@NotNull(message = "商品价格不能为空")
	@DecimalMin(value = "0", message = "商品价格不能小于0")
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
	@NotNull(message = "商品市场价不能为空")
	@DecimalMin(value = "0", message = "商品市场价不能小于0")
	private BigDecimal goodsMarketprice;

	/**
	 * 商品成本价
	 */
	@NotNull(message = "商品成本价不能为空")
	@DecimalMin(value = "0", message = "商品成本价不能小于0")
	private BigDecimal goodsCostprice;

	/**
	 * 商品折扣
	 */
	private BigDecimal goodsDiscount;

	/**
	 * 商家编号
	 */
	@NotBlank(message = "商家编号不能为空")
	private String goodsSerial;

	/**
	 * 总库存
	 */
	@NotNull(message = "总库存不能为空")
	@Min(value = 0, message = "总库存不能小于0")
	private Integer goodsStorage;

	/**
	 * 商品库存报警值
	 */
	@NotNull(message = "商品库存报警值不能为空")
	@Min(value = 0, message = "商品库存报警值不能小于0")
	private Integer goodsStorageAlarm;

	/**
	 * 商品推荐 1:是 0:否
	 */
	@Range(min = 0, max = 1, message = "商品推荐必须为0或1")
	private Integer goodsCommend;

	/**
	 * 商品运费 0为免运费
	 */
	@DecimalMin(value = "0", message = "商品运费不能小于0")
	private BigDecimal goodsFreight;

	/**
	 * 商品是否开具增值税发票 1:是 0:否
	 */
	@Range(min = 0, max = 1, message = "商品是否开具增值税发票必须为0或1")
	private Integer goodsVat;

	/**
	 * 是否为虚拟商品 1:是 0:否
	 */
	@Range(min = 0, max = 1, message = "是否虚拟商品必须为0或1")
	private Integer isVirtual;

	/**
	 * 商品分类完整路径冗余，方便按分类或子分类查询商品
	 */
	// private String gcFullpath;

	/**
	 * 销量
	 */
	// @Min(0)
	// private Long goodsSalenum;

	/**
	 * 商品默认图片
	 */
	private String imagePath;

	/**
	 * 扩展信息JSON
	 */
	private String extendInfo;
}