package cn.com.ut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttrValueVo {

	/**
	 * 属性ID
	 */
	private String attrId;

	/**
	 * 属性名称
	 */
	private String attrName;

	/**
	 * 属性值ID
	 */
	private String attrvalueId;

	/**
	 * 属性值名称
	 */
	private String attrvalueName;
}