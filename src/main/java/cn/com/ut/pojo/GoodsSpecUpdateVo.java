package cn.com.ut.pojo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.com.ut.util.RestInfo;
import lombok.Data;

@Data
public class GoodsSpecUpdateVo extends RestInfo {

	/**
	 * 规格和规格值组合
	 */
	@Valid
	@NotNull(message = "待更新的商品规格不能为空")
	@Size(min = 1, message = "待更新的商品规格不能为空")
	private List<GoodsSpecParamUpdateBo> goodsSpec;

	/**
	 * 商品ID
	 */
	@NotBlank(message = "商品ID不能为空")
	private String goodsId;
}