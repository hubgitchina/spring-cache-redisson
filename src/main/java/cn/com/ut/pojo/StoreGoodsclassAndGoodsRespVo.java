package cn.com.ut.pojo;

import java.util.List;

import cn.com.ut.util.RestInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouquanguo
 * @since 2018/7/17.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreGoodsclassAndGoodsRespVo extends RestInfo {

	/**
	 * 商品ID
	 */
	private String goodsId;

	/**
	 * 商品关联商品分组集合
	 */
	private List<StoreGoodsclassDetailRespVo> goodsGroups;

}
