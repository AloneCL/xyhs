package cgl.xyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cgl.xyhs.ssm.pojo.User;


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
    
    /**
     * 根据用户名选择用户
     * @param name
     * @return
     */
    User selectByUserName(String name);
    
    /**
     * 根据用户账号选择用户
     * @param count
     * @return
     */
    User selectByUserCount(String count);
    /**
      * 分页查询
     * @param 页号
     * @return
     */
    List<User> selectPage(Integer page);
    
    /**
     * 根据用户状态查询
     * @param 查询代表的状态
     * @return
     */
    List<User> selectByStatus(Integer status);
    
    /**
     * 根据用户电话号码修改用户状态
     * @param 用户信息
     * @return  修改结果
     */
    int updateByUserTel(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}