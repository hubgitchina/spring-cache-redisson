package cn.com.ut.pojo;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrQueryBo {

	/**
	 * 属性ID
	 */
	@NotBlank(message = "属性ID不能为空")
	private String attrId;

	/**
	 * 属性名称
	 */
	@NotBlank(message = "属性名称不能为空")
	private String attrName;

	/**
	 * 属性值集合
	 */
	private List<GoodsAttrValueQueryBo> attrvalue;
}