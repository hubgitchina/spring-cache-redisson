package cn.com.ut.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsManageStoreQueryRespVo {

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
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 商品关联商品分组集合
	 */
	private List<StoreGoodsclassDetailRespVo> goodsGroups;

	public GoodsManageStoreQueryRespVo(String goodsId, String goodsName, String goodsImage,
			BigDecimal goodsPrice, Integer goodsStorage, String goodsState, Date createTime,
			Date updateTime) {

		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsImage = goodsImage;
		this.goodsPrice = goodsPrice;
		this.goodsStorage = goodsStorage;
		this.goodsState = goodsState;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
}