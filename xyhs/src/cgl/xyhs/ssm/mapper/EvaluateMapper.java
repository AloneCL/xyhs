package cgl.xyhs.ssm.mapper;

import org.springframework.stereotype.Repository;

import cgl.xyhs.pojo.Evaluate;


/**
* @ClassName: EvaluateMapper.java
* @Description: 用户评论数据库映射mapper接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午7:47:21 
 */

@Repository
public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer evaId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer evaId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
}