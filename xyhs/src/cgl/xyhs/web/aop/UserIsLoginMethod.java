/**
 * 
 */
package cgl.xyhs.web.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @ClassName: UserIsLogin.java
* @Description: aop方法级别横切逻辑
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月28日 下午6:05:16 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface UserIsLoginMethod {

}

