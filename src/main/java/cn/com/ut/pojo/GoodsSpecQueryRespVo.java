package cn.com.ut.pojo;

import java.util.List;

import cn.com.ut.util.RestInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSpecQueryRespVo extends RestInfo {

	/**
	 * 规格和规格值ID组合
	 */
	private List<GoodsSpecQueryBo> goodsSpec;
}