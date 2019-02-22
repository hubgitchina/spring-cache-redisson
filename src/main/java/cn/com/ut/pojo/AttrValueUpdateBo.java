package cn.com.ut.pojo;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttrValueUpdateBo {

	/**
	 * 属性ID
	 */
	@NotBlank(message = "属性ID不能为空")
	private String attrId;

	/**
	 * 属性值ID集合
	 */
	@Valid
	private List<String> attrvalueId;
}