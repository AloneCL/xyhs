package cgl.xyhs.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.pojo.ShoppingCar;

@Repository
public interface ShoppingCarMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(ShoppingCar record);

    int insertSelective(ShoppingCar record);

    ShoppingCar selectByPrimaryKey(Integer scId);
    
    ShoppingCar selectByGoodsId(Integer goodsId);

    int updateByPrimaryKeySelective(ShoppingCar record);

    int updateByPrimaryKey(ShoppingCar record);
    
    /**
     * 根据商品id删除 用于用户删除购物车商品
     * @param goodsId
     * @return
     */
    int deleteByGoodsId(Integer goodsId);
    
    /**
     * 根据用户id查询所有商品
     * @param userId
     * @return
     */
    List<ShoppingCar> selectByUserId(@Param("userId")Integer userId,@Param("start")Integer start,@Param("end")Integer end);

	/**获取购物车商品数量
	 * @param id
	 * @return
	 */
	int getGoodsCount(Integer id);
   
}