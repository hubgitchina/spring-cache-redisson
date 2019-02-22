package cn.com.ut.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsclassRelationAttrRespVo {

	/**
	 * 属性ID
	 */
	private String attrId;

	/**
	 * 属性名称
	 */
	private String attrName;

	/**
	 * 属性排序
	 */
	private Integer sort;

	/**
	 * 属性类别1选择类型2手动输入类型
	 */
	private Integer attrType;

	/**
	 * 应用ID
	 */
	private String appId;

	private List<GoodsRelationAttrvalueBo> attrValues;

	public GoodsclassRelationAttrRespVo(String attrId, String attrName, Integer sort,
			Integer attrType, String appId) {

		this.attrId = attrId;
		this.attrName = attrName;
		this.sort = sort;
		this.attrType = attrType;
		this.appId = appId;
	}
}