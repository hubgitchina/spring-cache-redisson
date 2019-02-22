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
public class GoodsSpecValueQueryBo {

	/**
	 * 规格值ID
	 */
	@NotBlank(message = "规格值ID不能为空")
	private String specvalueId;

	/**
	 * 规格值名称
	 */
	@NotBlank(message = "规格值名称不能为空")
	private String specvalueName;

	/**
	 * 是否选中
	 */
	@NotBlank(message = "是否选中不能为空")
	private String isChecked;
}