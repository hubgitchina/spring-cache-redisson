package cn.com.ut.pojo;

import java.util.List;

import cn.com.ut.util.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品查询店铺自定义分类的响应VO
 * 
 * @author zhouquanguo
 * @since 2018/9/26.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsByGroupQueryRespVo {

	private List<GoodsManageStoreQueryRespVo> groupGoods;

	private PageInfo pageInfo;
}
