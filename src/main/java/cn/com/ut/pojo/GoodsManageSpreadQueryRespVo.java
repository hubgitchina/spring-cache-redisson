package cn.com.ut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsManageSpreadQueryRespVo {

	/**
	 * 商品ID
	 */
	private String goodsId;

	/**
	 * 商品编号
	 */
	private String goodsSerial;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品描述
	 */
	private String goodsDesc;

	/**
	 * 商品默认图片
	 */
	private String goodsImage;
}