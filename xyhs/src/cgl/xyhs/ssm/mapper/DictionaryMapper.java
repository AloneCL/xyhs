package cgl.xyhs.ssm.mapper;

import org.springframework.stereotype.Repository;

import cgl.xyhs.ssm.pojo.Dictionary;


/**
* @ClassName: DictionaryMapper.java
* @Description: 数据字典数据库映射mapper接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午7:46:55 
 */

@Repository
public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}