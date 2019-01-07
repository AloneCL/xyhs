/**
 * 
 */
package cgl.xyhs.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cgl.xyhs.ssm.service.OrderService;

/**
* @ClassName: OrderController.java
* @Description: 订单后台逻辑控制层
* @version: v1.0.0
* @author: CGL
* @date: 2019年1月6日 下午5:40:34 
 */
//@Controller
public class OrderController implements FinalConstant{
   
	//@Autowired
	private OrderService service;
	
	@RequestMapping("/searchUserOrder")
	public String searchByUser(Model model,Integer page) {
		
		return "/backer/userOrder.jsp";
	}
}
