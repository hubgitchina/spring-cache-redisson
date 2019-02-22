package cn.com.ut.pojo;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import cn.com.ut.util.RestInfo;
import lombok.Data;

@Data
public class GoodsAttrUpdateVo extends RestInfo {

	/**
	 * 属性和属性值ID组合
	 */
	@Valid
	private List<AttrValueUpdateBo> attr;

	/**
	 * 商品ID
	 */
	@NotBlank(message = "商品ID不能为空")
	private String goodsId;
}