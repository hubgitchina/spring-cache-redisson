package cn.com.ut.pojo;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import cn.com.ut.util.RestInfo;
import lombok.Data;

@Data
public class GoodsCookUpdateVo extends RestInfo {

	/**
	 * 商品ID
	 */
	@NotBlank(message = "商品ID不能为空")
	private String goodsId;

	/**
	 * 商品名称
	 */
	@NotBlank(message = "商品名称不能为空")
	private String goodsName;

	/**
	 * 商品描述
	 */
	private String goodsDesc;

	/**
	 * 商品价格
	 */
	@NotNull(message = "商品价格不能为空")
	@DecimalMin(value = "0.01", message = "商品价格不能小于0.01")
	private BigDecimal goodsPrice;

	/**
	 * 商品折扣
	 */
	@DecimalMin(value = "0.1", message = "商品折扣不能小于0.1")
	@Range(min = 0, max = 1, message = "商品折扣只能在0.1到1之间")
	private BigDecimal goodsDiscount;

	/**
	 * 扩展信息JSON
	 */
	private String extendInfo;
}