/**
 * 
 */
package cgl.xyhs.junitTest;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.service.GoodsService;

/**
* @ClassName: GoodsTest.java
* @Description: 商品类junit测试
* @version: v1.0.0
* @author: CGL
* @date: 2019年1月6日 下午3:26:13 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class GoodsTest {
   
	@Autowired
	private GoodsService service;
	
	@Test
	public void pageTest() {
		List<Goods> goodsList = Collections.emptyList();
		System.out.println(service.searchTypeGoodsCount(1));
		goodsList = service.getByTypePage(1, 0, 5);
	    for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}
	
	@Test
	public void userpageTest() {
		List<Goods> goodsList = Collections.emptyList();
		System.out.println(service.searchUserGoodsCount(4));
		goodsList = service.getByUser(4, 0, 5);
	    for (Goods goods : goodsList) {
			System.out.println(goods);
		}
	}
}
