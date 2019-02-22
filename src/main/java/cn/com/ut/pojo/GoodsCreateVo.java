package cn.com.ut.pojo;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import cn.com.ut.util.RestInfo;
import lombok.Data;

@Data
public class GoodsCreateVo extends RestInfo {

	/**
	 * 店铺id
	 */
	@NotBlank(message = "店铺ID不能为空")
	private String storeId;

	/**
	 * 商品编号
	 */
	// @NotBlank(message = "商家编号不能为空")
	// private String goodsSerial;

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
	 * 商品分组ID集合
	 */
	private List<String> storegcIds;

	/**
	 * 商品描述
	 */
	private String goodsDesc;

	/**
	 * 商品分类
	 */
	@NotBlank(message = "商品分类ID不能为空")
	private String gcId;

	/**
	 * 商品价格
	 */
	@NotNull(message = "商品价格不能为空")
	@DecimalMin(value = "0.01", message = "商品价格不能小于0.01")
	private BigDecimal goodsPrice;

	/**
	 * 商品市场价
	 */
	@NotNull(message = "商品市场价不能为空")
	@DecimalMin(value = "0.01", message = "商品价格不能小于0.01")
	private BigDecimal goodsMarketprice;

	/**
	 * 商品库存
	 */
	@NotNull(message = "商品库存不能为空")
	@Min(value = 0, message = "商品库存不能小于0")
	private Integer goodsStorage;
}