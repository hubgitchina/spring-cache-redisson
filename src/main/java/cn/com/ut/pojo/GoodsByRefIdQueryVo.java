package cn.com.ut.pojo;

import java.util.List;

import javax.validation.constraints.Min;
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
public class GoodsByRefIdQueryVo extends RestInfo {

	/**
	 * 电子菜谱ID
	 */
	// @NotBlank(message = "电子菜谱ID不能为空")
	@NotNull(message = "电子菜谱ID不能为空")
	@Size(min = 1, message = "电子菜谱ID不能为空")
	private List<String> refIds;

	/**
	 * 商品分类ID
	 */
	@NotBlank(message = "商品分类ID不能为空")
	private String gcId;

	/**
	 * 目标经度
	 */
	@NotNull(message = "目标经度不能为空")
	@Min(value = 0, message = "目标经度不能小于0")
	private double longitude;

	/**
	 * 目标纬度
	 */
	@NotNull(message = "目标纬度不能为空")
	@Min(value = 0, message = "目标纬度不能小于0")
	private double latitude;

	/**
	 * 距离范围（米）
	 */
	@NotNull(message = "搜索范围不能为空")
	@Min(value = 0, message = "搜索范围不能小于0")
	private double distance;
}
