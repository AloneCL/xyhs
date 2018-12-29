/**
 * 
 */
package cgl.xyhs.ssm.serviceImpl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public int login(User vo) {
		User u = mapper.selectByUserName(vo.getUserAccount());
		if (!isMobile(vo.getUserAccount()) || vo.getUserPass().isEmpty() || vo.getUserPass().length()>16)
			return 2;
			if (u != null) {
				if (u.getUserPass().equals(vo.getUserPass())) {
					return 1;
				}
			}
		return 0;
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
		for (int i : id) {
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
    
	/**
	 * 手机号码验证
	 * @param str
	 * @return  验证通过返回true
	 */
	public static boolean isMobile(final String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

}
