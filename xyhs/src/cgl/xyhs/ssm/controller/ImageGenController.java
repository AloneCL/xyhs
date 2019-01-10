/**
 * 
 */
package cgl.xyhs.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cgl.xyhs.util.tools.RandomValidateCode;

/**
* @ClassName: ImageGenController.java
* @Description: 验证码放置及验证
* @version: v1.0.0
* @author: CGL
* @date: 2018年12月31日 下午8:15:40 
 */
@Controller
public class ImageGenController implements FinalConstant{

/*
    @RequestMapping(value="/toImg")
    public String toImg(){

        return "image/image";
    }*/


    @RequestMapping("/getLoginCode")
    @ResponseBody
    public String getSysManageLoginCode(HttpServletResponse response,
            HttpServletRequest request) {
        response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
        response.setDateHeader("Expire", 0);
        
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response,SESSION_VALIDATECODE);// 输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    
    @RequestMapping(value = "/checkimagecode")
    @ResponseBody
    public String checkTcode(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
        String validateCode = request.getParameter(REQUEST_VALIDATECODE);
        String code = (String) request.getSession().getAttribute(session.getId()+SESSION_VALIDATECODE);
        if(!StringUtils.isEmpty(validateCode) && validateCode.toLowerCase().equals(code.toLowerCase())){
            return "ok";    

        }
        return "error";
    }

}
