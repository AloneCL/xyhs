/**
 * 
 */
package cgl.xyhs.ssm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cgl.xyhs.ssm.pojo.User;
import cgl.xyhs.ssm.service.UserService;
import net.sf.json.JSONObject;

/**
 * @ClassName: UserController.java
 * @Description: 用户后台逻辑请求控制器
 * @version: v1.0.0
 * @author: CGL
 * @date: 2018年12月26日 下午7:10:20
 */

@Controller
public class UserController implements FinalConstant {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request) {
		String error = request.getParameter(REQUEST_ERROR_INFO);

		if (error != null) {
			if (error.equals(LOGIN_ERROR_PASS)) {
				model.addAttribute(REQUEST_ERROR_INFO, "账号密码错误");
			} else if (error.equals(LOGIN_ERROR_VALIDATE)) {
				model.addAttribute(REQUEST_ERROR_INFO, "验证码错误");
			} else {
				model.addAttribute(REQUEST_ERROR_INFO, "请输入正确的账号密码格式");
			}

		}
		return "/login.jsp";
	}

	@RequestMapping(value = "submitLogin")
	public String submitLogin(Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session, User vo) {
		String cilentCheckCode = request.getParameter(REQUEST_VALIDATECODE);
		String serverCheckCode = (String) session.getAttribute(session.getId() + SESSION_VALIDATECODE);
		int result;
		if (cilentCheckCode.toLowerCase().equals(serverCheckCode.toLowerCase())) {
			if ((result = service.login(vo)) == 1) {
				session.removeAttribute(SESSION_VALIDATECODE);
				session.setAttribute(SESSION_USER_ACCOUNT, vo.getUserAccount());
				response.addCookie(new Cookie(CILENT_USERNAME, service.getInfoByAccount(vo.getUserAccount()).getUserName()));
				return "/backer/main.jsp";
			} else if (result == 0) {
				return "redirect:login.action?error=" + LOGIN_ERROR_PASS;
			} else {
				return "redirect:login.action?error=" + LOGIN_ERROR_FORMAT;
			}
		}
		return "redirect:login.action?error=" + LOGIN_ERROR_VALIDATE;
	}

	@RequestMapping(value = "userRegister")
	public String register(Model model, HttpServletRequest request) {
		String error = request.getParameter(REQUEST_ERROR_INFO);
		if (error != null) {
			if (error.equals(REGISTER_ERROR_ALIVE)) {
				model.addAttribute(REQUEST_ERROR_INFO, "该账号已注册");
			} else if(error.equals(LOGIN_ERROR_FORMAT)){
				model.addAttribute(REQUEST_ERROR_INFO, "请输入正确的用户名密码格式");
			}else if(error.equals(LOGIN_ERROR_VALIDATE)){
				model.addAttribute(REQUEST_ERROR_INFO, "验证码输入错误");
			}else {
				model.addAttribute(REQUEST_ERROR_INFO,"验证码已过期");
			}
		}
		return "/backer/register.jsp";
	}

	@RequestMapping(value = "submitRegister")
	public String submitRegister(Model model, HttpServletRequest request, HttpSession session, User vo) {
		// System.out.println(vo);
		int result;
		JSONObject json = (JSONObject) session.getAttribute(SESSION_MESSAGECODE);
		if(!request.getParameter(SESSION_VARIFY_CODE).equals(json.getString(SESSION_VARIFY_CODE))) {
			     return "redirect:userRegister.action?error=" + LOGIN_ERROR_VALIDATE;
		}else if((System.currentTimeMillis() - json.getLong(SESSION_CREATE_TIME)) > 1000*60*5) {
			    session.removeAttribute(SESSION_MESSAGECODE);
			    return "redirect:userRegister.action?error=" + REGISTER_VALIDATE_OVERTIME;
		}
		
		if ((result = service.addUser(vo)) == 1) {
			session.removeAttribute(SESSION_MESSAGECODE);
			return "redirect:login.action";
		} else if (result == 0) {
			return "redirect:userRegister.action?error=" + REGISTER_ERROR_ALIVE;
		} else {
			return "redirect:userRegister.action?error=" + LOGIN_ERROR_FORMAT;
		}
	}
	
	@RequestMapping(value="userInfo")
    public String userInfo(Model model,HttpSession session) {
		String account = (String) session.getAttribute(SESSION_USER_ACCOUNT);
		User user = service.getInfoByAccount(account);
		if(user != null) {
			model.addAttribute(LOGIN_USER, user);
		}
		return "/backer/self_info.jsp";
	}
	
	@RequestMapping(value="updatePassWord")
	public String updateUserByTel(Model model,HttpServletRequest request) {
		request.getParameter(REQUEST_ERROR_INFO);
		return "/backer/updatePass.jsp";
	}
	
	@RequestMapping(value="submitModifyPass",produces="text/html;charset=utf-8")
	@ResponseBody
	public String modifyPassWord(Model model,HttpServletRequest request,String userPass1,String userPass2) {
        String newPass = request.getParameter("userPass");	
        if(newPass.isEmpty() || newPass.length()>16) {
        	return "请确认新密码的格式";
        }
		if(!userPass1.equals(userPass2)) {
			return "请确认两次新密码输入一致";
		}
		String userCount = (String) request.getSession().getAttribute(SESSION_USER_ACCOUNT);
		if(!newPass.equals(service.getInfoByAccount(userCount).getUserPass())) {
			return "请输入正确的密码";
		}
		User user = new User();
		user.setUserAccount(userCount);
		user.setUserPass(userPass1);
		service.updateByUserAccount(user);
		System.out.println(user);
		return "修改成功";
	}
	
	@RequestMapping(value="logOut")
	public String loguout(Model model,HttpSession session) {
	    session.removeAttribute(SESSION_USER_ACCOUNT);
		return "redirect:login.action";
	}
	
	@RequestMapping(value = "checkUserAccount")
	@ResponseBody
	public String checkUserAccount(HttpServletRequest request, HttpServletResponse response) {
		String account = request.getParameter(REQUEST_ACCOUNT);
		if (service.getInfoByAccount(account) == null)
			return "ok";
		return "error";
	}
}
