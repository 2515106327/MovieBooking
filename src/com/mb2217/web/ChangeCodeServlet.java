package com.mb2217.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

@WebServlet("/ChangeCodeServlet")
public class ChangeCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangeCodeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用jar包实现验证码
		ValidateCode vc =new ValidateCode(80, 32, 4, 9);
		
		  //获取生产的验证码字符串
        String code =vc.getCode();
        //传值方式1.拼接网址字符串  2.使用域对象
        //使用session 来储存验证码9
        request.getSession().setAttribute("wcode", code);

//        System.out.println(code);
        //写到网页上 (通过  响应中的字符流  写回网页)
		vc.write(response.getOutputStream());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
