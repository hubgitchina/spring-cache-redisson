package cn.com.ut.pojo;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSpecParamUpdateBo {

	/**
	 * 规格和规格值组合
	 */
	@NotNull(message = "待更新的规格详情不能为空")
	@Size(min = 1, message = "待更新的规格详情不能为空")
	private List<GoodsSpecValueUpdateBo> specParam;

	/**
	 * 商品价格
	 */
	@NotNull(message = "商品价格不能为空")
	@DecimalMin(value = "0", message = "商品价格不能小于0")
	private BigDecimal goodsPrice;

	/**
	 * 商品库存
	 */
	@NotNull(message = "商品库存不能为空")
	@Min(value = 0, message = "商品库存不能小于0")
	private Integer goodsStorage;
}