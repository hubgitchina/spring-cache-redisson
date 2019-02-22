package cn.com.ut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsclassAndAppRespVO {

	/**
	 * 商品ID
	 */
	private String goodsId;

	/**
	 * 商品分类ID
	 */
	private String gcId;

	/**
	 * 应用ID
	 */
	private String appId;

}