/**
 * 
 */
package cgl.xyhs.ssm.controller;

/**
* @ClassName: FinalConstant.java
* @Description: 常量控制器
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月26日 下午8:55:22 
 */
public interface FinalConstant {
	/**
	 * 返回给客户端的错误提示信息属性名
	 */
    String REQUEST_ERROR_INFO = "error";
    
    /**
	 *  客户端提交的验证码对应的Attribute属性名
	 */
	String REQUEST_VALIDATECODE = "validateCode";
	
	/**
	 * 服务器存放在Session中的验证码属性名
	 */
	String SESSION_VALIDATECODE = "imagecode";
	
	/**
	 * 用户登录成功后存放在服务端Session中的属性名
	 */
	String SESSION_LOGINUSER = "loginUser";
	
	/**
	 * 登陆时密码错误的错误类型  
	 */
	String LOGIN_ERROR_PASS = "1";
	
	/**
	 * 登陆时验证码错误的错误类型
	 */
	String LOGIN_ERROR_VALIDATE = "2";
}
