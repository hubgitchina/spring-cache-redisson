package cn.com.ut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsattrindexQueryBo {

	/**
	 * 属性ID
	 */
	private String attrId;

	/**
	 * 属性值ID
	 */
	private String attrvalueId;
}