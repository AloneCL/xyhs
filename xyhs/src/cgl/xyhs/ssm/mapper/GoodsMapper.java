package cgl.xyhs.ssm.mapper;

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

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}