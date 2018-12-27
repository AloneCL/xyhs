/**
 * 
 */
package cgl.xyhs.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cgl.xyhs.ssm.pojo.User;
import cgl.xyhs.ssm.service.UserService;

/**
 * @ClassName: UserController.java
 * @Description: 该类的功能描述
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
			if (error.equals("1")) {
				model.addAttribute(REQUEST_ERROR_INFO, "账号密码错误");
			} else if (error.equals("2")) {
				model.addAttribute(REQUEST_ERROR_INFO, "验证码错误");
			}

		}
		return "/login.jsp";
	}

	@RequestMapping(value = "submitLogin")
	public String submitLogin(Model model, HttpServletRequest request, HttpSession session, User vo) {
		String cilentCheckCode = request.getParameter(REQUEST_VALIDATECODE);
		String serverCheckCode = (String) session.getAttribute(session.getId() + SESSION_VALIDATECODE);
		if (cilentCheckCode.toLowerCase().equals(serverCheckCode.toLowerCase())) {
			if (service.login(vo)) {
				session.setAttribute(SESSION_LOGINUSER, vo.getUserName());
				return "/backer/liebiao.jsp";
			}else {
				return "redirect:login.action?error="+ LOGIN_ERROR_PASS;
			}
		}
		return "redirect:login.action?error=" + LOGIN_ERROR_VALIDATE;
	}

}
