package cn.com.ut.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsImageAttrSpecBo {

	/**
	 * 商品图片集合
	 */
	private List<ImageQueryRespVo> goodsImage;

	/**
	 * 规格和规格值ID组合
	 */
	private List<GoodsSpecQueryBo> goodsSpec;

	/**
	 * 属性和属性值ID组合
	 */
	private List<GoodsAttrQueryBo> goodsAttr;
}