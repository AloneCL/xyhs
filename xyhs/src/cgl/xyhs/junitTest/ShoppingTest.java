/**
 * 
 */
package cgl.xyhs.junitTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cgl.xyhs.ssm.pojo.ShoppingCar;
import cgl.xyhs.ssm.service.ShoppingService;

/**
* @ClassName: AdminTest.java
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月22日 下午2:33:31 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class ShoppingTest {
    
	@Autowired
	private ShoppingService service;
	
	 @Test
     public void test() {
		 List<ShoppingCar> goodsList = service.selectByUserId(4,0,5);
		 for (ShoppingCar goods : goodsList) {
			System.out.println(goods);
		}
    	/*ShoppingCar sc = service.getInfo(1);
    	System.out.println(sc);*/
      }
}


