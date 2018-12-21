package cgl.xyhs.ssm.mapper;

import org.springframework.stereotype.Repository;

import cgl.xyhs.pojo.Ratation;


/**
* @ClassName: RatationMapper.java
* @Description: 首页轮播图实体类数据库mapper映射接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午7:51:01 
 */
@Repository
public interface RatationMapper {
    int insert(Ratation record);

    int insertSelective(Ratation record);
}