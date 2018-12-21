package cgl.xyhs.ssm.mapper;

import org.springframework.stereotype.Repository;

import cgl.xyhs.pojo.Admin;


/**
* @ClassName: AdminMapper.java
* @Description: 管理员数据库映射接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月21日 下午7:44:03 
 */

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}