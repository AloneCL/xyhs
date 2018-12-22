/**
 * 
 */
package cgl.xyhs.ssm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgl.xyhs.ssm.mapper.AdminMapper;
import cgl.xyhs.ssm.pojo.Admin;
import cgl.xyhs.ssm.service.AdminService;

/**
* @ClassName: AdminServiceImpl.java
* @Description: 后台管理员逻辑实现类
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月22日 下午2:10:59 
 */

@Service
public class AdminServiceImpl implements AdminService{
    
	@Autowired
	private AdminMapper mapper;

	
	@Override
	public boolean login(Admin vo) {
		Admin admin = mapper.selectByUserName(vo.getAdminName());
		if(admin!=null) {
			if(vo.getAdminName().trim().equals(admin.getAdminName()) && vo.getAdminPass().trim().equals(admin.getAdminPass())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int changeSelect(Admin vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}
}
