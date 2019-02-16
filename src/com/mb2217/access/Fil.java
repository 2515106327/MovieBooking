package com.mb2217.access;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*")
public class Fil implements Filter {
	@Override
	public void destroy() {

	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain china)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		String Url=request.getRequestURI();
//		System.out.println("进入");
		if(Url.endsWith("ChangeCodeServlet")||Url.endsWith("Sys_sys_userServlet")||Url.endsWith("login.jsp")||Url.endsWith("index.jsp")||Url.endsWith("syslogin.jsp")||Url.endsWith("cinemalogin.jsp")||Url.endsWith(".css")||Url.endsWith(".jpg")||Url.contains(".png")){
//			System.out.println("满足通过");
			china.doFilter(req, res);
		}else if(request.getSession().getAttribute("sys_user")!=null||request.getSession().getAttribute("mov_user")!=null){
			china.doFilter(req, res);
		}
		else{
			//Session 是否为空
			//User 是否登录
//			System.out.println("不满足权限，跳转");
			String path=request.getContextPath();
			response.sendRedirect(path+"/login.jsp");
			
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
