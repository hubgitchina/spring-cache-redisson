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
public class GoodsManageSpreadQueryVo extends RestInfo {

	/**
	 * 当前页码数
	 */
	@NotNull(message = "当前页码数不能为空")
	@Min(value = 1, message = "当前页码数必须大于或等于1")
	private Integer pageno;

	/**
	 * 每页的记录数
	 */
	@NotNull(message = "每页的记录数不能为空")
	@Min(value = 0, message = "每页的记录数必须大于或等于0")
	private Integer pagesize;

	/**
	 * 店铺ID
	 */
	@NotBlank(message = "店铺ID不能为空")
	private String storeId;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 排序字段
	 */
	private String order;

	/**
	 * 排序规则，升序或降序
	 */
	private String sort;
}