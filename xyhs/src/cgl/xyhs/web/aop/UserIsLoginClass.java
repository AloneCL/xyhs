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
* @ClassName: UserIsLoginClass.java
* @Description: 用于标注类
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月28日 下午6:09:28 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface UserIsLoginClass {

}
