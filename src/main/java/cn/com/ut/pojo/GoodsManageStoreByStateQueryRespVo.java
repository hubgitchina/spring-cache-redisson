package cn.com.ut.pojo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsManageStoreByStateQueryRespVo {

	/**
	 * 商品ID
	 */
	private String goodsId;

	/**
	 * 商品名称
	 */
	private String goodsName;

	/**
	 * 商品默认图片
	 */
	private String goodsImage;

	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;

	/**
	 * 总库存
	 */
	private Integer goodsStorage;

	/**
	 * 商品状态 0:下架 1:正常 10:违规（禁售）2:编辑
	 */
	private String goodsState;

	/**
	 * 创建时间
	 */
	private transient Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;
}