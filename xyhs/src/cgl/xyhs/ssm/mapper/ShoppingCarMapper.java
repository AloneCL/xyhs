package cgl.xyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.pojo.ShoppingCar;

@Repository
public interface ShoppingCarMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(ShoppingCar record);

    int insertSelective(ShoppingCar record);

    ShoppingCar selectByPrimaryKey(Integer scId);

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
    List<Goods> selectByUserId(Integer userId);
   
}