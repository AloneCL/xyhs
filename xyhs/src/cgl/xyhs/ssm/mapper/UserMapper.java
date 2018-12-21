package cgl.xyhs.ssm.mapper;

import org.springframework.stereotype.Repository;

import cgl.xyhs.pojo.User;


/**
* @ClassName: UserMapper.java
* @Description: 用户数据库映射mapper接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午7:51:33 
 */

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);
    
    User selectByUserName(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}