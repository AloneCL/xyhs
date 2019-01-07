/**
 * 
 */
package cgl.xyhs.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.service.GoodsService;

/**
* @ClassName: GoodsController.java
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: CGL
* @date: 2019年1月6日 下午3:38:52 
 */
@Controller
public class GoodsController implements FinalConstant{
    
	
	@Autowired
	private GoodsService service;
	
	@RequestMapping(value="mainGoods")
	public String goodsList(Model model) {
		System.out.println(11111);
		List<Goods> elList = service.getByTypePage(1, 0, 5);
		List<Goods> bookList = service.getByTypePage(2,0,5);
		List<Goods> deskList = service.getByTypePage(3, 0, 5);
		List<Goods> toolList = service.getByTypePage(4, 0, 5);
		
		model.addAttribute("elList", elList);
		model.addAttribute("bookList", bookList);
		model.addAttribute("deskList", deskList);
		model.addAttribute("toolList", toolList);
		
		return "/backer/main.jsp";
	}
	
	@RequestMapping(value="/searchGoods")
	public String searchGoodsByType(Integer type,Model model,Integer page) {
		boolean hasNext = false;
		//总共的数据条数
		int  total = service.searchTypeGoodsCount(type);
		//共分多少页
		int totalPage = total%PAGE_DATA_NUM >0 ? total/PAGE_DATA_NUM+1 : total/PAGE_DATA_NUM;
		//当前的页数
		int currentPage = 1;
		if(page != null){
			currentPage = page;
		}
		if(currentPage<1){
			currentPage = 1;
		}
		if(currentPage > totalPage ){
			currentPage = totalPage;
		}
		if(currentPage < totalPage) {
			hasNext = true;
		}
		//起始位置
		int start = (currentPage - 1)*PAGE_DATA_NUM;
		//结束位置
		int end = PAGE_DATA_NUM;
		// 分页查询
        List<Goods> goodsList = service.getByTypePage(type, start, end);
		
        model.addAttribute("total", total);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("totalPage", totalPage);
		return "/backer/userGoods.jsp";
	}
	
	@RequestMapping("/searchUserGoods")
	public String searchByUser(Model model,Integer page,Integer id) {
		
		boolean hasNext = false;
		//总共的数据条数
		int  total = service.searchUserGoodsCount(id);
		//共分多少页
		int totalPage = total%PAGE_DATA_NUM >0 ? total/PAGE_DATA_NUM+1 : total/PAGE_DATA_NUM;
		if(totalPage<1)
			totalPage = 1;
		//当前的页数
		int currentPage = 1;
		if(page != null){
			currentPage = page;
		}
		if(currentPage<1){
			currentPage = 1;
		}
		if(currentPage > totalPage ){
			currentPage = totalPage;
		}
		if(currentPage < totalPage) {
			hasNext = true;
		}
		//起始位置
		int start = (currentPage - 1)*PAGE_DATA_NUM;
		//结束位置
		int end = PAGE_DATA_NUM;
		// 分页查询
        List<Goods> goodsList = service.getByUser(id, start, end);
		/*for (Goods goods : goodsList) {
			System.out.println(goods);
		}*/
        model.addAttribute("total", total);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("totalPage", totalPage);
        
		return "/backer/userGoods.jsp";
	}
}
