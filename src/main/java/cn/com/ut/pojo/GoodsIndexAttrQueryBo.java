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
public class GoodsIndexAttrQueryBo {

	/**
	 * 属性ID
	 */
	private String attrId;

	/**
	 * 属性值ID集合
	 */
	private List<String> attrvalues;
}