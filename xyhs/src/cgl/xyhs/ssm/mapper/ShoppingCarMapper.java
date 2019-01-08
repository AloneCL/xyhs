package cgl.xyhs.ssm.mapper;

import cgl.xyhs.ssm.pojo.ShoppingCar;

public interface ShoppingCarMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(ShoppingCar record);

    int insertSelective(ShoppingCar record);

    ShoppingCar selectByPrimaryKey(Integer scId);

    int updateByPrimaryKeySelective(ShoppingCar record);

    int updateByPrimaryKey(ShoppingCar record);
}