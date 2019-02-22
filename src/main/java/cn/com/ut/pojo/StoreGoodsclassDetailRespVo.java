package cn.com.ut.pojo;

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
public class StoreGoodsclassDetailRespVo extends RestInfo {

	/**
	 * 店铺商品分类ID
	 */
	private String storegcId;

	/**
	 * 店铺商品分类名称
	 */
	private String storegcName;

}
