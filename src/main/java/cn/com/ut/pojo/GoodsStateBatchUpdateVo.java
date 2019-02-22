package cn.com.ut.pojo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import cn.com.ut.util.RestInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsStateBatchUpdateVo extends RestInfo {

	/**
	 * 商品ID
	 */
	@NotNull(message = "待更新的商品ID不能为空")
	@Size(min = 1, message = "待更新的商品ID不能为空")
	private List<String> goodsIds;

	/**
	 * 商品状态 0:下架 1:正常 10:违规（禁售）
	 */
	@NotBlank(message = "商品状态不能为空")
	private String goodsState;
}