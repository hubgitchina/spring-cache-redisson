package cn.com.ut.pojo;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSpecQueryBo {

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
	 * 规格值集合
	 */
	private List<GoodsSpecValueQueryBo> specvalues;
}