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
public class MallGoodsQueryVo extends RestInfo {

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
	 * 应用ID
	 */
	@NotBlank(message = "应用ID不能为空")
	private String appId;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品分类ID
	 */
	private String gcId;

	/**
	 * 商品最低价
	 */
	private String priceMin;

	/**
	 * 商品最高价
	 */
	private String priceMax;

	/**
	 * 根据商品销量进行降序（1为进行降序排列，其它值表示不按销量字段排序）
	 */
	// private String descSalenum;

	/**
	 * 根据商品上架时间进行降序（1为进行降序排列，其它值表示不按销量字段排序）
	 */
	// private String descShelftime;

	/**
	 * 根据商品最高价进行升序或降序（1为进行降序排列，0为进行升序排列）
	 */
	// private String sortPrice;

	/**
	 * 排序字段
	 */
	private String order;

	/**
	 * 排序规则，升序或降序
	 */
	private String sort;
}