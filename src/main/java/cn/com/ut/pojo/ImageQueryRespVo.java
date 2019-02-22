package cn.com.ut.pojo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageQueryRespVo {

	/**
	 * 商品ID
	 */
	@NotBlank(message = "商品ID不能为空")
	private String id;

	/**
	 * 商品图片路径
	 */
	@NotBlank(message = "商品图片路径不能为空")
	private String imagePath;

	/**
	 * 商品图片排序
	 */
	@NotNull(message = "图片排序不能为空")
	@Range(min = 0, max = 255, message = "排序大小必须在0-255")
	private Integer sort;

	/**
	 * 商品图片默认主图，1是，0否
	 */
	@NotNull(message = "是否默认主图不能为空")
	@Range(min = 0, max = 1, message = "是否默认主图必须为0或1")
	private Integer isDefault;

	/**
	 * 文件类型：1图片2视频
	 */
	@NotNull(message = "文件类型不能为空")
	@Range(min = 1, max = 2, message = "文件类型必须为1或2")
	private Integer fileType;
}