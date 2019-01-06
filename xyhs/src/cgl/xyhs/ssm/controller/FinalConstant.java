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
	 * 用户注册时提交的账号 即电话号码
	 */
	String REQUEST_ACCOUNT = "account";
	
	/**
	 * 服务器存放在Session中的验证码属性名
	 */
	String SESSION_VALIDATECODE = "imagecode";
	
	/**
	 * 用户登录成功后存放在服务端Session中的属性名 用户账号
	 */
	String SESSION_USER_ACCOUNT = "loginUser";
	
	/**
	 * 存储在客户端cookie中的用户名
	 */
	String CILENT_USERNAME = "userName";
	
	/**
	 * 注册时发送的短信验证码内容
	 */
	String SESSION_VARIFY_CODE = "verifyCode";
	
	/**
	 * 短信验证码发送时间
	 */
	String SESSION_CREATE_TIME = "createTime";
	
	/**
	 * 注册时的短信验证码 json格式，包含验证码内容和验证码创建时间
	 */
	String SESSION_MESSAGECODE = "MessageCode";
	
	/**
	 * 登陆时密码错误的错误类型  
	 */
	String LOGIN_ERROR_PASS = "1";
	
	/**
	 * 验证码错误的错误类型
	 */
	String LOGIN_ERROR_VALIDATE = "2";
	
	/**
	 * 后端账号密码格式验证
	 */
	String LOGIN_ERROR_FORMAT = "3";
	
	/**
	 * 后端验证用户账号已经存在
	 */
	String REGISTER_ERROR_ALIVE = "0";
	
	/**
	 * 短信验证码超过时间
	 */
	String REGISTER_VALIDATE_OVERTIME = "4";
	
	/**
	 * 查询的用户个人信息
	 */
	String LOGIN_USER = "user_message";
	

}
