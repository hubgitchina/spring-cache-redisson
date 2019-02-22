package cn.com.ut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecValueVo {

	/**
	 * 规格ID
	 */
	private String specId;

	/**
	 * 规格名称
	 */
	private String specName;

	/**
	 * 规格值ID
	 */
	private String specvalueId;

	/**
	 * 规格值名称
	 */
	private String specvalueName;
}