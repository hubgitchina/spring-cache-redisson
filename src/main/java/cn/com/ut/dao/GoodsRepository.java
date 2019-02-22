package cn.com.ut.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.com.ut.entity.Goods;
import cn.com.ut.pojo.GoodsBodyVo;
import cn.com.ut.pojo.GoodsExtendInfoVo;
import cn.com.ut.pojo.GoodsStateVo;

/**
 * @Description: 商品管理DAO
 * @Author wangpeng1
 * @Date 2018/11/5 9:50
 */
public interface GoodsRepository extends JpaRepository<Goods, String> {

	/**
	 * 创建商品时验证当前店铺是否存在同名商品
	 *
	 * @param goodsName
	 * @param storeId
	 * @param isDel
	 * @return
	 */
	boolean existsByGoodsNameAndStoreIdAndIsDel(String goodsName, String storeId, String isDel);

	/**
	 * 更新商品时验证当前店铺是否存在同名商品
	 *
	 * @param goodsName
	 * @param storeId
	 * @param isDel
	 * @param goodsId
	 * @return
	 */
	boolean existsByGoodsNameAndStoreIdAndIsDelAndIdNot(String goodsName, String storeId,
			String isDel, String goodsId);

	/**
	 * 更新商品（只更新指定字段）
	 *
	 * @param goodsName
	 * @param storeId
	 * @param gcId
	 * @param brandId
	 * @param typeId
	 * @param goodsPrice
	 * @param goodsMarketprice
	 * @param goodsCostprice
	 * @param goodsSerial
	 * @param goodsStorageAlarm
	 * @param goodsCommend
	 * @param goodsFreight
	 * @param isVirtual
	 * @param goodsStorage
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.goodsName = ?1, g.storeId = ?2, g.gcId = ?3, g.brandId = ?4, g.typeId = ?5, g.goodsPrice = ?6, g.goodsMarketprice = ?7, g.goodsCostprice = ?8, g.goodsSerial = ?9, g.goodsStorageAlarm = ?10, g.goodsCommend = ?11, g.goodsFreight = ?12, g.isVirtual = ?13, g.goodsStorage = ?14, g.updateId = ?15, g.updateTime = ?16 where g.id = ?17")
	int updateGoods(String goodsName, String storeId, String gcId, String brandId, String typeId,
			BigDecimal goodsPrice, BigDecimal goodsMarketprice, BigDecimal goodsCostprice,
			String goodsSerial, int goodsStorageAlarm, int goodsCommend, BigDecimal goodsFreight,
			int isVirtual, int goodsStorage, String updateId, Timestamp updateTime, String goodsId);

	/**
	 * 获取商品状态内容
	 *
	 * @param goodsId
	 */
	@Query("select new cn.com.ut.pojo.GoodsStateVo(g.id, g.goodsState) from Goods g where g.id = ?1")
	GoodsStateVo getGoodsState(String goodsId);

	/**
	 * 更新商品库存
	 *
	 * @param goodsStorage
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.goodsStorage = ?1, g.updateId = ?2, g.updateTime = ?3 where g.id = ?4")
	int updateGoodsStorage(Integer goodsStorage, String updateId, Timestamp updateTime,
			String goodsId);

	/**
	 * 更新商品价格
	 *
	 * @param goodsPrice
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.goodsPrice = ?1, g.updateId = ?2, g.updateTime = ?3 where g.id = ?4")
	int updateGoodsPrice(BigDecimal goodsPrice, String updateId, Timestamp updateTime,
			String goodsId);

	/**
	 * 上架商品
	 *
	 * @param goodsState
	 * @param goodsShelftime
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.goodsState = ?1, g.goodsShelftime = ?2, g.updateId = ?3, g.updateTime = ?4 where g.id = ?5")
	int upGoods(String goodsState, Timestamp goodsShelftime, String updateId, Timestamp updateTime,
			String goodsId);

	/**
	 * 批量上架商品
	 *
	 * @param goodsState
	 * @param goodsShelftime
	 * @param updateId
	 * @param updateTime
	 * @param goodsIds
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.goodsState = ?1, g.goodsShelftime = ?2, g.updateId = ?3, g.updateTime = ?4 where g.id in ?5")
	int batchUpGoods(String goodsState, Timestamp goodsShelftime, String updateId,
			Timestamp updateTime, List<String> goodsIds);

	/**
	 * 下架商品
	 *
	 * @param goodsState
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.goodsState = ?1, g.updateId = ?2, g.updateTime = ?3 where g.id = ?4")
	int downGoods(String goodsState, String updateId, Timestamp updateTime, String goodsId);

	/**
	 * 批量下架商品
	 *
	 * @param goodsState
	 * @param updateId
	 * @param updateTime
	 * @param goodsIds
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.goodsState = ?1, g.updateId = ?2, g.updateTime = ?3 where g.id in ?4")
	int batchDownGoods(String goodsState, String updateId, Timestamp updateTime,
			List<String> goodsIds);

	/**
	 * 根据商品ID删除商品（逻辑删除，改变is_del字段值为Y，商品状态为下架）
	 *
	 * @param isDel
	 * @param goodsState
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.isDel = ?1, g.goodsState = ?2, g.updateId = ?3, g.updateTime = ?4 where g.id = ?5")
	int deleteByGoodsId(String isDel, String goodsState, String updateId, Timestamp updateTime,
			String goodsId);

	/**
	 * 根据商品ID集合批量删除商品（逻辑删除，改变is_del字段值为Y，商品状态为下架）
	 *
	 * @param isDel
	 * @param goodsState
	 * @param updateId
	 * @param updateTime
	 * @param goodsIds
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.isDel = ?1, g.goodsState = ?2, g.updateId = ?3, g.updateTime = ?4 where g.id in ?5")
	int batchDeleteByGoodsIds(String isDel, String goodsState, String updateId,
			Timestamp updateTime, List<String> goodsIds);

	/**
	 * 更新商品详情页内容
	 *
	 * @param goodsBody
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.goodsBody = ?1, g.updateId = ?2, g.updateTime = ?3 where g.id = ?4")
	int updateGoodsBody(String goodsBody, String updateId, Timestamp updateTime, String goodsId);

	/**
	 * 获取商品详情页内容
	 *
	 * @param goodsId
	 */
	@Query("select new cn.com.ut.pojo.GoodsBodyVo(g.id as goodsId, g.goodsBody) from Goods g where g.id = ?1")
	GoodsBodyVo getGoodsBody(String goodsId);

	/**
	 * 更新商品扩展信息
	 *
	 * @param extendInfo
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.extendInfo = ?1, g.updateId = ?2, g.updateTime = ?3 where g.id = ?4")
	int updateExtendInfo(String extendInfo, String updateId, Timestamp updateTime, String goodsId);

	/**
	 * 获取商品扩展信息
	 *
	 * @param goodsId
	 * @return
	 */
	@Query("select new cn.com.ut.pojo.GoodsExtendInfoVo(g.id as goodsId, g.extendInfo) from Goods g where g.id = ?1")
	GoodsExtendInfoVo getExtendInfo(String goodsId);

	/**
	 * 更新商品规格值和最大最小价格
	 *
	 * @param specValue
	 * @param priceMin
	 * @param priceMax
	 * @param updateId
	 * @param updateTime
	 * @param goodsId
	 * @return
	 */
	@Modifying
	@Transactional
	@Query("update Goods g set g.specValue = ?1, g.priceMin = ?2, g.priceMax = ?3, g.updateId = ?4, g.updateTime = ?5 where g.id = ?6")
	int updateSpecValueAndPriceMinAndpAndPriceMax(String specValue, BigDecimal priceMin,
			BigDecimal priceMax, String updateId, Timestamp updateTime, String goodsId);

	/**
	 * 根据商品ID和删除标识查询商品关联规格值
	 *
	 * @param goodsId
	 * @param isDel
	 * @return
	 */
	@Query("select new map(g.specValue as spec_value) from Goods g where g.id=?1 and g.isDel=?2")
	Map<String, Object> querySpecValueById(String goodsId, String isDel);

	@Modifying
	@Transactional
	@Query("update Goods g set g.imagePath = ?1, g.updateId = ?2, g.updateTime = ?3 where g.id = ?4")
	int updateImagePath(String imagePath, String updateId, Timestamp updateTime, String goodsId);

	/**
	 * 根据商品类型ID验证该类型是否被商品使用
	 *
	 * @param typeId
	 * @return
	 */
	boolean existsByTypeId(String typeId);

	/**
	 * 根据商品分类ID验证该分类是否被商品使用
	 *
	 * @param gcId
	 * @return
	 */
	boolean existsByGcId(String gcId);
}
