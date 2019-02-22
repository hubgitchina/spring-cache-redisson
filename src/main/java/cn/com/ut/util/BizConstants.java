package cn.com.ut.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author wuxiaohua
 * @since 2018/9/21
 */
public class BizConstants {

	/**
	 * 退款方式：1应用方退款2平台直接退款
	 */
	public interface RefundWay {

		int REFUND_BY_APP = 1;
		int REFUND_BY_PLATFORM = 2;
	}

	public interface MallState {

		/**
		 * 上线
		 */
		int ONLINE = 1;
		/**
		 * 下线
		 */
		int OFFLINE = 0;
		/**
		 * 删除
		 */
		int DEL = 2;
	}

	public interface ShopState {

		/**
		 * 上线
		 */
		int ONLINE = 1;
		/**
		 * 下线
		 */
		int OFFLINE = 0;
	}

	/**
	 * 商品状态
	 */
	public interface GoodsState {

		/**
		 * 上架
		 */
		String ON_SHELF = "1";

		/**
		 * 下架
		 */
		String OFF_SHELF = "0";

		/**
		 * 编辑
		 */
		String EDIT = "2";

		/**
		 * 违规（禁售）
		 */
		String NO_SALE = "10";

		/**
		 * 商品规格不存在
		 */
		String SPEC_NOTEXISTS = "3";
		/**
		 * 商品不存在，被删除
		 */
		String IS_DEL = "4";
		/**
		 * 售罄
		 */
		String NO_STOCK = "5";

		/**
		 * 商品库存不足
		 */
		String LACK_STOCK = "6";

	}

	/**
	 * 商品分类审核状态
	 */
	public interface GoodsclassStatus {

		/**
		 * 待审核
		 */
		int AUDIT_NOT = 0;

		/**
		 * 审核通过
		 */
		int AUDIT_SUCCESS = 1;

		/**
		 * 审核不通过
		 */
		int AUDIT_FAIL = 2;
	}

	public interface GoodsImageType {

		/**
		 * 图片
		 */
		int PICTURE = 1;

		/**
		 * 视频
		 */
		int VIDEO = 2;
	}

	/**
	 * 扩展区域信息页面区域编码
	 */
	public enum ExtendAreaCode {

		goodspublish, goodsview, orderpreview, orderlist
	}

	/**
	 * 商品属性类型
	 */
	public interface GoodsAttributeType {

		/**
		 * 下拉选择
		 */
		int CHOOSE = 1;

		/**
		 * 手动输入
		 */
		int INPUT = 2;
	}

	public interface SpreadGoodsState {

		/**
		 * 有效
		 */
		int VALID = 1;

		/**
		 * 失效
		 */
		int INVALID = 0;
	}

	public interface TimerTaskState {

		/**
		 * 已处理
		 */
		int PROCESSED = 1;

		/**
		 * 处理中
		 */
		int PROCESSING = 0;
	}

	/**
	 * 定时任务业务码
	 */
	public interface TimerTaskBizCode {

		/**
		 * 支付超时
		 */
		String PAY_OT = "pay_ot";
		/**
		 * 申请退款超时
		 */
		String APPLYREFUND_OT = "applyrefund_ot";
		/**
		 * 评价超时
		 */
		String EVALUATE_OT = "applyrefund_ot";
		/**
		 * 确认订单超时
		 */
		String CONFIRM_OT = "confirm_ot";
		/**
		 * 商家处理退款超时
		 */
		String HANDLE_REFUND_OT = "handle_refund_ot";

	}

	/**
	 * 订单处理时限
	 */
	public interface OrderTimeLimit {

		/**
		 * 支付超时（分钟），下单后开始计时
		 */
		int PAY_OT_MINUTES = 30;

		/**
		 * 申请退款超时（天），付款后开始计时
		 */
		int APPLYREFUND_OT_DAYS = 30;

		/**
		 * 确认订单超时（天），付款后开始计时
		 */
		int CONFIRM_OT_DAYS = 10;

		/**
		 * 评价超时（天），确认订单时开始计时
		 */
		int EVALUATE_OT_DAYS = 20;

		/**
		 * 商家处理退款超时（天），买家提交退款申请后开始计时
		 */
		int HANDLE_REFUND_OT_DAYS = 3;

	}

	/**
	 * 退款结果
	 */
	public interface RefundResult {

		/**
		 * 无退款
		 */
		int NO_REFUND = 0;
		/**
		 * 部分退款
		 */
		int PART_REFUND = 1;
		/**
		 * 全部退款
		 */
		int FULL_REFUND = 2;

	}

	/**
	 * 退款状态
	 */
	public interface RefundState {

		/**
		 * 1:处理中,2:待管理员处理,3:已退款,4:已取消,5:商家拒绝,6:商家同意
		 */
		int SELLER_PROCESSING = 1;
		int ADMIN_PROCESSING = 2;
		int REFUNDED = 3;
		int CANCELED = 4;
		int SELLER_REJECTED = 5;
		int SELLER_AGREED = 6;
	}

	/**
	 * 是否部分退款
	 */
	public interface PartRefundState {

		/**
		 * 退款状态 0:无退款 1:部分退款 2:全部退款
		 */
		int NO_REFUND = 0;
		int PART_REFUND = 1;
		int FULL_REFUND = 2;
	}

	/**
	 * 新退款或更新退款
	 */
	public enum OrderGoodsRefundUpdateCase {

		UPDAE_REFUND, UPDATE_REFUND_STATE
	}

	/**
	 * 分享单状态
	 */
	public interface TradeInfoState {
		/**
		 * 1待结算2已结算3结算失败
		 */
		int SETTLING = 1;
		int SETTLED = 2;
		int SETTLE_FAIL = 3;
		int SETTLE_CANCEL = 4;
		/**
		 * 0待分成1表示成功 2 表示部分成功 3 全部失败
		 */
		int SHARING = 0;
		int SHARED = 1;
		int SHARE_FAIL = 3;
		int SHARED_PART = 2;
	}

	// 店铺营业状态的枚举类
	public interface StoreBusinessState {
		Integer OPEN = 1; // 店铺营业中
		Integer CLOSE = 0; // 店铺打烊
	}

	/**
	 * 店铺状态:0关闭，1开启
	 */
	public interface StoreStatus {
		Integer ONLINE = 1;
		Integer OFFLINE = 0;
	}

	/**
	 * 商品分类层级的常量类
	 */
	public interface GoodsClassLevel {
		Integer LEVEL_ZERO = 0;
		Integer LEVEL_FIRST = 1;
		Integer LEVEL_SECOND = 2;
		Integer LEVEL_THIRD = 3;
		Integer LEVEL_FOURTH = 4;
	}

	/**
	 * 商品状态的枚举类
	 */
	public enum GoodsStatus {
		ON_SHELF("1", "上架"), OFF_SHELF("0", "下架"), EDIT("2", "编辑中"), NO_SALE("10", "违规（禁售）");
		private String code;

		public String getCode() {

			return code;
		}

		public String getMessage() {

			return message;
		}

		private String message;

		GoodsStatus(String code, String message) {

			this.code = code;
			this.message = message;
		}

		public static String getMessage(String code) {

			for (GoodsStatus goodsStatus : GoodsStatus.values()) {
				if (StringUtils.equals(goodsStatus.getCode(), code)) {
					return goodsStatus.getMessage();
				}
			}
			return StringUtils.EMPTY;

		}

	}
}
