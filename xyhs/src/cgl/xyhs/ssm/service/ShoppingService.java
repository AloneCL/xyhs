/**
 * 
 */
package cgl.xyhs.ssm.service;

import java.util.List;

import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.pojo.ShoppingCar;

/**
* @ClassName: ShoppingService.java
* @Description: 购物车服务层接口
* @version: v1.0.0
* @author: CGL
* @date: 2019年1月8日 下午8:08:06 
 */
public interface ShoppingService {
     
	List<ShoppingCar> selectByUserId(Integer userId,Integer start,Integer end);
	
	int addShopping(ShoppingCar sc);
	
	int deleteByGoodsId(Integer goodsId);
	
	int updateShopping(ShoppingCar car);
	
	int getGoodsCount(Integer id);
	
	ShoppingCar getInfo(Integer id);
}
