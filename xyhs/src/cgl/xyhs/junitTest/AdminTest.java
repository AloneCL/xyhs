/**
 * 
 */
package cgl.xyhs.junitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cgl.xyhs.ssm.pojo.Admin;
import cgl.xyhs.ssm.service.AdminService;

/**
* @ClassName: AdminTest.java
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月22日 下午2:33:31 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class AdminTest {
    
	@Autowired
	private AdminService service;
	
	 @Test
     public void login() {
    	  Admin admin = new Admin();
    	  System.out.println(service);
    	  admin.setAdminName("123");
    	  admin.setAdminPass("1234");
    	  System.out.println(service.login(admin));
      }
}


