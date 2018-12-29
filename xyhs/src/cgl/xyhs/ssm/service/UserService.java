/**
 * 
 */
package cgl.xyhs.ssm.service;

import java.util.List;

import cgl.xyhs.ssm.pojo.User;

/**
* @ClassName: UserService.java
* @Description: 用户基本功能服务层接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月22日 下午8:01:42 
 */

public interface UserService {
    
	/**
	 * 把返回类型设为int类型 用来标识不同的错误情况
	 * 1代表账号密码错误
	 * 2代表后台验证账号密码格式规范不通过
	 * @param vo
	 * @return
	 */
	int login(User vo);
      
    int addUser(User vo);
    
    int delete(Integer id);
    
    int deleteMany(Integer[] id);
    
    int updateByUserTel(User vo);
    
    int updateByPrimary(User vo);
    
    User getInfo(Integer id);
    
    List<User> getBypage(Integer page);
      
}
