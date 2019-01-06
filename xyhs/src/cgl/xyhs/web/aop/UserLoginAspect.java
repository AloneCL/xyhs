/**
 * 
 */
package cgl.xyhs.web.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cgl.xyhs.ssm.controller.FinalConstant;

/**
 * @ClassName: UserLoginAspect.java
 * @Description: 校验用户登录切面
 * @version: v1.0.0
 * @author: CGL
 * @date: 2018年12月28日 下午6:13:02
 */
@Component
@Aspect
public class UserLoginAspect implements FinalConstant {
	
	/*@Pointcut("execution(* cgl.xyhs.ssm.controller..*.*(..))")*/
	@Pointcut("execution(* cgl.xyhs.ssm.controller..*.*(..))&& (@target(cgl.xysh.web.aop.UserIsLoginClass) ||"+
			"@annotation(cgl.xysh.web.aop.UserIsLoginMethod))")
	public void checkPointCut() {
		
	}

	//@Around("checkPointCut()")
	public Object UserLoginAdvice(ProceedingJoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		System.out.println("切面方法执行");
		if (request.getSession().getAttribute(SESSION_USER_ACCOUNT) != null) {
			try {
				joinPoint.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return "/login.jsp";
	}
/*
	@Before("checkPointCut()")
	public void before(JoinPoint joinPoint) {
	//	System.out.println("前置执行方法");
	}

	// 配置后置通知,使用在方法aspect()上注册的切入点
	@After("checkPointCut()")
	public void after(JoinPoint joinPoint) {
		//System.out.println("执行after.....");
	}*/
}
