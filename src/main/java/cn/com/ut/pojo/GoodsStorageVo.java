package cn.com.ut.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import cn.com.ut.util.RestInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsStorageVo extends RestInfo {

	/**
	 * 商品ID
	 */
	@NotBlank(message = "商品ID不能为空")
	private String goodsId;

	/**
	 * 商品库存
	 */
	@NotNull(message = "商品库存不能为空")
	@Min(value = 0, message = "商品库存不能小于0")
	private Integer goodsStorage;
}