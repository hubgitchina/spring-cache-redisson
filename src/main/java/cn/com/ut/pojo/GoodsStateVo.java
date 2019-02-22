package cn.com.ut.pojo;

import org.hibernate.validator.constraints.NotBlank;

import cn.com.ut.util.RestInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsStateVo extends RestInfo {

	/**
	 * 商品ID
	 */
	@NotBlank(message = "商品ID不能为空")
	private String goodsId;

	/**
	 * 商品状态 0:下架 1:正常 10:违规（禁售）2:编辑
	 */
	@NotBlank(message = "商品状态不能为空")
	private String goodsState;
}