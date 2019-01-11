/**
 * 
 */
package cgl.xyhs.ssm.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cgl.xyhs.ssm.pojo.Goods;
import cgl.xyhs.ssm.service.GoodsService;
import cgl.xyhs.util.tools.DateConverter;
import cgl.xyhs.web.aop.UserIsLoginMethod;

/**
 * @ClassName: GoodsController.java
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: CGL
 * @date: 2019年1月6日 下午3:38:52
 */
@Controller
public class GoodsController implements FinalConstant {

	@Autowired
	private GoodsService service;

	/**
	 * 商城主页检索出商品信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/mainGoods")
	public String goodsList(Model model) {
		List<Goods> elList = service.getByTypePage(1, 0, 5);
		List<Goods> bookList = service.getByTypePage(2, 0, 5);
		List<Goods> deskList = service.getByTypePage(3, 0, 5);
		List<Goods> toolList = service.getByTypePage(4, 0, 5);

		model.addAttribute("elList", elList);
		model.addAttribute("bookList", bookList);
		model.addAttribute("deskList", deskList);
		model.addAttribute("toolList", toolList);

		return "/backer/main.jsp";
	}

	@RequestMapping(value = "/typeGoods")
	public String typeGoodsList(Model model, Integer type,Integer page) {
		boolean hasNext = false;
		// 总共的数据条数
		int total = service.searchTypeGoodsCount(type);
		// 共分多少页
		int totalPage = total % 20 > 0 ? total / 20 + 1 : total / 20;
		// 当前的页数
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		if (currentPage < totalPage) {
			hasNext = true;
		}
		if(total == 0) {
			currentPage = 1;
		}
		int start = (currentPage - 1) * PAGE_DATA_NUM;
		List<Goods> tgoods1 = service.getByTypePage(type, start, 5);
		List<Goods> tgoods2 = service.getByTypePage(type, start+5, 5);
		List<Goods> tgoods3 = service.getByTypePage(type, start+10, 5);
		List<Goods> tgoods4 = service.getByTypePage(type, start+15, 5);
		model.addAttribute("tgoods1", tgoods1);
		model.addAttribute("tgoods2", tgoods2);
		model.addAttribute("tgoods3", tgoods3);
		model.addAttribute("tgoods4", tgoods4);
		model.addAttribute("type", type);
		model.addAttribute("total", total);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("hasNext", hasNext);
		model.addAttribute("totalPage", totalPage);
		return "/backer/typeGoods.jsp";
	}

	/**
	 * 查看商品信息
	 * 
	 * @param model
	 * @param goodsdId
	 * @return
	 */
	@RequestMapping(value = "/goodsData")
	public String goodsData(Model model, Integer goodsdId) {
		Goods goods = service.getInfoById(goodsdId);
		model.addAttribute("goods", goods);

		return "/backer/goods_data.jsp";
	}

	@RequestMapping(value = "/userShowGoods")
	public String userShowGoods(Model model, Integer goodsId) {
		if (goodsId != null) {
			Goods goods = service.getInfoById(goodsId);
			model.addAttribute("goods", goods);
			return "/backer/userGoods_data.jsp";
		}
		return goodsList(model);
	}

	/**
	 * 用户添加新商品
	 * 
	 * @param model
	 * @param goods
	 * @return
	 */
	@UserIsLoginMethod
	@RequestMapping(value = "/addGoods")
	@ResponseBody
	public String userAddGoods(Model model, Goods goods) {
		if (service.addGoods(goods) > 0)
			return "success";
		return "fail";
	}

	/**
	 * 用户修改自己的商品信息
	 * 
	 * @param model
	 * @param goods
	 * @return
	 */
	@UserIsLoginMethod
	@RequestMapping(value = "/modifyGoods")
	@ResponseBody
	public String modifyGoods(Model model, Goods goods) {
		if (service.updateGoods(goods) > 0) {
			return "success";
		}
		return "fail";
	}

	/**
	 * 根据商品类型分页选择商品
	 * 
	 * @param type
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/searchGoods")
	public String searchGoodsByType(Integer type, Model model, Integer page) {
		boolean hasNext = false;
		// 总共的数据条数
		int total = service.searchTypeGoodsCount(type);
		// 共分多少页
		int totalPage = total % PAGE_DATA_NUM > 0 ? total / PAGE_DATA_NUM + 1 : total / PAGE_DATA_NUM;
		// 当前的页数
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		if (currentPage < totalPage) {
			hasNext = true;
		}
		// 起始位置
		int start = (currentPage - 1) * PAGE_DATA_NUM;
		// 结束位置
		int end = PAGE_DATA_NUM;
		// 分页查询
		List<Goods> goodsList = service.getByTypePage(type, start, end);

		model.addAttribute("total", total);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("hasNext", hasNext);
		model.addAttribute("totalPage", totalPage);
		return "/backer/userGoods.jsp";
	}

	/**
	 * 查看用户的商品信息
	 * 
	 * @param model
	 * @param page
	 * @param id
	 * @return
	 */
	@UserIsLoginMethod
	@RequestMapping("/searchUserGoods")
	public String searchByUser(Model model, Integer page, Integer id) {

		boolean hasNext = false;
		// 总共的数据条数
		int total = service.searchUserGoodsCount(id);
		// 共分多少页
		int totalPage = total % PAGE_DATA_NUM > 0 ? total / PAGE_DATA_NUM + 1 : total / PAGE_DATA_NUM;
		if (totalPage < 1)
			totalPage = 1;
		// 当前的页数
		int currentPage = 1;
		if (page != null) {
			currentPage = page;
		}
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		if (currentPage < totalPage) {
			hasNext = true;
		}
		// 起始位置
		int start = (currentPage - 1) * PAGE_DATA_NUM;
		// 结束位置
		int end = PAGE_DATA_NUM;
		// 分页查询
		List<Goods> goodsList = service.getByUser(id, start, end);
		/*
		 * for (Goods goods : goodsList) { System.out.println(goods); }
		 */
		model.addAttribute("total", total);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("hasNext", hasNext);
		model.addAttribute("totalPage", totalPage);
		return "/backer/userGoods.jsp";
	}

	@RequestMapping("/uploadImg")
	@UserIsLoginMethod
	@ResponseBody
	public String uploadImg(@RequestParam MultipartFile picture, HttpServletRequest request) {
		String path1 = System.getProperty("evan.webappxysh");
		String path2 = "../xyhsUpload/img/" + DateConverter.convert(new Date());
		String path = path1 + path2;

		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}

		String img = System.currentTimeMillis() + (int) Math.random() * 1000000 + ".jpg";
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(new File(file, img));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			output.write(picture.getBytes());
			output.close();
		} catch (IOException e) {
			System.out.println("文件上传错误");
			e.printStackTrace();
		}
		return path2 + "/" + img;
	}
}
