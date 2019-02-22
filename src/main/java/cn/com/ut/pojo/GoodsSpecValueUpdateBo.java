package cn.com.ut.pojo;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSpecValueUpdateBo {

	/**
	 * 规格ID
	 */
	@NotBlank(message = "规格ID不能为空")
	private String specId;

	/**
	 * 规格名称
	 */
	@NotBlank(message = "规格名称不能为空")
	private String specName;

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
}