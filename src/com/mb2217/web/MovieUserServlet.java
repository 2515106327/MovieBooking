package com.mb2217.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mb2217.entity.Movie_User;
import com.mb2217.service.MovieUserService;
import com.mb2217.service.ServiceProxyFactory;

@WebServlet("/MovieUser")
public class MovieUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieUserService movieuserservice = ServiceProxyFactory.getService(MovieUserService.class);

	public MovieUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String opr = request.getParameter("opr");
		if ("login".equals(opr)) {
			dologin(request, response);
		} else if ("logout".equals(opr)) {
			dologout(request, response);
		}
	}

	private void dologout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("CinemaUser");
		response.sendRedirect("login.jsp");

	}

	private void dologin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("movname");
		String password = request.getParameter("movpassword");
		String code = request.getParameter("code");

		HttpSession session = request.getSession();
		String wcode = (String) session.getAttribute("wcode");
		Movie_User mov_user = movieuserservice.getUserByNameAndPswd(name, password);
		// 忽略大小写验证
		if (wcode.equalsIgnoreCase(code) == false) {
			request.setAttribute("msg", "验证码不正确!");
			request.getRequestDispatcher("cinemalogin.jsp").forward(request, response);
		}
		if (mov_user != null) {

			Movie_User c_name = movieuserservice.getCinemaName(mov_user.getMov_id());
			mov_user.setC_name(c_name.getC_name());
			request.getSession().setAttribute("CinemaUser", mov_user);
			// 转跳主页面
			response.sendRedirect("cinemaindex.jsp");
		} else {
			request.setAttribute("msg", "用户或密码错误");
			request.getRequestDispatcher("cinemalogin.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
