/**
 * 
 */
package cgl.xyhs.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.pojo.ShoppingCar;
import cgl.xyhs.ssm.service.ShoppingService;
import cgl.xyhs.web.aop.UserIsLoginClass;

/**
* @ClassName: ShoppingCarController.java
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: CGL
* @date: 2019年1月8日 下午9:35:04 
 */
@Controller
@UserIsLoginClass
public class ShoppingCarController {
     
	@Autowired
	private ShoppingService service;
	
	@RequestMapping("/showShoppingCar")
	public String showCar(Model model,Integer userId,Integer page) {
		if(page == null)
			page = 1;
		List<Goods> goodList = service.selectByUserId(userId);
		
		model.addAttribute("goodList", goodList);
		return "/backer/shoppingCar.jsp";
	}
	
	@RequestMapping(value="/addGoodsForCar")
	@ResponseBody
	public String addGoosForCar(Model model,ShoppingCar sc) {
		if(service.addShopping(sc)>0) {
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping(value="/deleteGoodsForCar")
	@ResponseBody
	public String deleteGodos(Model model,Integer id) {
		if(service.deleteByGoodsId(id)>0) {
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping(value="/updateShoppingCars")
	@ResponseBody
	public String updateShoppingCars(Model model,ShoppingCar sc) {
		if(service.updateShopping(sc)>0) {
			return "success";
		}
		return "fail";
		
	}
}
