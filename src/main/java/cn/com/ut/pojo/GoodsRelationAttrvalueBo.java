package cn.com.ut.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsRelationAttrvalueBo {

	/**
	 * 属性值ID
	 */
	private String attrvalueId;

	/**
	 * 属性值名称
	 */
	private String attrvalueName;

	/**
	 * 属性值排序
	 */
	private Integer sort;

	/**
	 * 应用ID
	 */
	private String appId;

	/**
	 * 是否选中
	 */
	private String isChecked;

	public GoodsRelationAttrvalueBo(String attrvalueId, String attrvalueName, Integer sort,
			String appId) {

		this.attrvalueId = attrvalueId;
		this.attrvalueName = attrvalueName;
		this.sort = sort;
		this.appId = appId;
	}
}