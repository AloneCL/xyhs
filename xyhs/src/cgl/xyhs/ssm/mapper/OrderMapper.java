package cgl.xyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cgl.xyhs.pojo.Order;


/**
* @ClassName: OrderMapper.java
* @Description: 订单数据库mapper映射接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午7:49:11 
 */
@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> selectBypage(Integer page);
}