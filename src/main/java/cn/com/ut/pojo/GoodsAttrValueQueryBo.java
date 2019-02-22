package cn.com.ut.pojo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrValueQueryBo {

	/**
	 * 属性ID
	 */
	@NotBlank(message = "属性ID不能为空")
	private String attrvalueId;

	/**
	 * 属性值名称
	 */
	@NotBlank(message = "属性值名称不能为空")
	private String attrvalueName;

	/**
	 * 是否选中
	 */
	@NotBlank(message = "是否选中不能为空")
	private String isChecked;
}