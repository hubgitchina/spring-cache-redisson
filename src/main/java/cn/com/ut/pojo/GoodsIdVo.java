package cn.com.ut.pojo;

import org.hibernate.validator.constraints.NotBlank;

import cn.com.ut.util.RestInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsIdVo extends RestInfo {

	/**
	 * 商品ID
	 */
	@NotBlank(message = "商品ID不能为空")
	private String goodsId;
}