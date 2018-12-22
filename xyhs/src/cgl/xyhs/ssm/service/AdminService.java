/**
 * 
 */
package cgl.xyhs.ssm.service;

import cgl.xyhs.ssm.pojo.Admin;

/**
* @ClassName: AdminService.java
* @Description: 后台管理员服务层接口
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月22日 下午2:08:37 
 */
public interface AdminService {
	   
	/**
	 * 管理员登录
	 * @param vo
	 * @return
	 */
	boolean login(Admin vo);
	
	/**
	 * 修改信息
	 * @param vo
	 * @return
	 */
	int changeSelect(Admin vo);
}
