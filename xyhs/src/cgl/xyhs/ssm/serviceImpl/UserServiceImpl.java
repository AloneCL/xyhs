/**
 * 
 */
package cgl.xyhs.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgl.xyhs.ssm.mapper.UserMapper;
import cgl.xyhs.ssm.pojo.User;
import cgl.xyhs.ssm.service.UserService;

/**
* @ClassName: UserServiceImpl.java
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月22日 下午8:30:32 
 */

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserMapper mapper;
	
	@Override
	public boolean login(User vo) {
		User u = mapper.selectByUserName(vo.getUserName());
		if(u!=null) {
			if(u.getUserPass().equals(vo.getUserPass())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int addUser(User vo) {
		vo.setUserStarlevel(4.0);
		vo.setUserStatus(0);
		
		return mapper.insertSelective(vo);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteMany(Integer[] id) {
		for(int i : id) {
			mapper.deleteByPrimaryKey(i);
		}
		return id.length;
	}

	@Override
	public int updateByUserTel(User vo) {
		return mapper.updateByUserTel(vo);
	}
	
	@Override
	public int updateByPrimary(User vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}

	@Override
	public User getInfo(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getBypage(Integer page) {
		return mapper.selectPage(page);
	}

}
