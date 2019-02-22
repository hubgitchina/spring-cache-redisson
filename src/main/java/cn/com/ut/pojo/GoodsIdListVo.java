package cn.com.ut.pojo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cn.com.ut.util.RestInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsIdListVo extends RestInfo {

	/**
	 * 商品ID
	 */
	@NotNull(message = "商品ID不能为空")
	@Size(min = 1, message = "商品ID不能为空")
	private List<String> goodsIds;
}