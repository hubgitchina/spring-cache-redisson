package cn.com.ut.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsManageDetailLookRespVo {

	/**
	 * 店铺ID
	 */
	private String storeId;

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
	 * 商品分类
	 */
	private String gcId;

	/**
	 * 商品分类名称
	 */
	private String gcName;

	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;

	/**
	 * 商品市场价
	 */
	private BigDecimal goodsMarketprice;

	/**
	 * 商品库存
	 */
	private Integer goodsStorage;

	/**
	 * 商品内容
	 */
	private String goodsBody;

	/**
	 * 扩展信息JSON
	 */
	private String extendInfo;

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

	/**
	 * 商品图片集合
	 */
	private List<ImageQueryRespVo> goodsImage;

	/**
	 * 属性和属性值组合
	 */
	private List<GoodsAttrQueryBo> goodsAttr;

	public GoodsManageDetailLookRespVo(String storeId, String goodsId, String goodsSerial,
			String goodsName, String goodsDesc, String gcId, String gcName, BigDecimal goodsPrice,
			BigDecimal goodsMarketprice, Integer goodsStorage, String goodsBody, String extendInfo,
			String goodsState, Date createTime, Date updateTime) {

		this.storeId = storeId;
		this.goodsId = goodsId;
		this.goodsSerial = goodsSerial;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.gcId = gcId;
		this.gcName = gcName;
		this.goodsPrice = goodsPrice;
		this.goodsMarketprice = goodsMarketprice;
		this.goodsStorage = goodsStorage;
		this.goodsBody = goodsBody;
		this.extendInfo = extendInfo;
		this.goodsState = goodsState;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
}