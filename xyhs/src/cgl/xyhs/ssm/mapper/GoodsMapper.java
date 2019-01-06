package cgl.xyhs.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cgl.xyhs.ssm.pojo.Goods;

/**
 * @ClassName: GoodsMapper.java
 * @Description: 商品类数据库映射mapper接口
 * @version: v1.0.0
 * @author: CGL
 * @date: 2018年12月21日 下午7:48:15
 */

@Repository
public interface GoodsMapper {
	
	int deleteByPrimaryKey(Integer goodsId);
    
	/**
	 * 分页选择商品
	 * @param type
	 * @param start
	 * @param end
	 * @return
	 */
	List<Goods> selectPage(@Param("type")Integer type, @Param("start")Integer start, @Param("end")Integer end);
	
	/**
	 * 查询指定商品类型的商品数量
	 * @param type
	 * @return
	 */
	int searchTypeCount(Integer type);
    
	/**
	 * 根据商品状态选择商品
	 * @param statu
	 * @return
	 */
	List<Goods> selectByStatu(Integer statu);
	
	/**
	 * 根据商品类型选择商品
	 * @param type
	 * @return
	 */
	List<Goods> selectByType(Integer type);
	
	/**
	 * 用户查看自己的商品状况
	 * @param id
	 * @param start
	 * @param end
	 * @return
	 */
	List<Goods> selectByUser(@Param("id")Integer id, @Param("start")Integer start, @Param("end")Integer end);
   
	/**
     * 查询用户商品的总数量
     * @param id
     * @return
     */
	int searchGoodsCount(Integer id);
	
	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer goodsId);
 
	int updateByPrimaryKeySelective(Goods record);
	
	/**
	 * 用户修改自己的商品信息
	 * @param goods
	 * @return
	 */
	int updateByUser(Goods goods);

	int updateByPrimaryKey(Goods record);
}