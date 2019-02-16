package com.mb2217.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mb2217.entity.User;
import com.mb2217.service.UserService;
import com.mb2217.util.OAUtil;

@WebServlet("/User")
@MultipartConfig
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String opr = request.getParameter("opr");
		if ("adduser".equals(opr)) {
			doAdd(request, response);
		} else if ("query".equals(opr)) {
			doQuery(request, response);
		} else if ("login".equals(opr)) {
			doLogin(request, response);
		} else if ("updateAvatar".equals(opr)) {
			doUpdateAvrtar(request, response);
		} else if ("update".equals(opr)) {
			doUpdate(request, response);
		} else if ("updateinit".equals(opr)) {
			doUpdateInit(request, response);
		}
	}

	private void doUpdateInit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		request.getRequestDispatcher("user/updateuser.jsp").forward(request, response);
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {// 修改信息
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		String u_username = request.getParameter("u_username");
		String u_password = request.getParameter("u_password");
		User user = new User();
		user.setU_id(u_id);
		user.setU_username(u_username);
		user.setU_password(u_password);
		UserService userService = new UserService();
		userService.updateUser(user);
		User userl = userService.getUser(u_username, u_password);
		request.getSession().setAttribute("user", userl);
		request.setAttribute("msg", "修改成功");
		request.getRequestDispatcher("user/usermanage.jsp").forward(request, response);
	}

	private void doUpdateAvrtar(HttpServletRequest request, HttpServletResponse response) // 修改头像
			throws ServletException, IOException {
		Part part = request.getPart("u_avatar");
		String name = OAUtil.getId();
		System.out.println(part);
		String path = getServletContext().getRealPath("/images/avatar");
		part.write(path + "/" + name);
		User user = (User) request.getSession().getAttribute("user");
		UserService userService = new UserService();
		userService.updateArtar(user.getU_id(), "images/avatar/" + name);
		user.setU_avatar("images/avatar/" + name);
		response.sendRedirect("InterfaceServlet?opr=index");
		// TODO Auto-generated method stub

	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response)// 跳转登陆
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String u_name = request.getParameter("u_username");
		String u_password = request.getParameter("u_password");
		String code = request.getParameter("code");
		UserService us = new UserService();
		User user = us.getUser(u_name, u_password);

//		 获取域中的session
		HttpSession session = request.getSession();
		String wcode = (String) session.getAttribute("wcode");
//		 忽略大小写验证
		if (wcode.equalsIgnoreCase(code) == false) {
			request.setAttribute("msg", "验证码不正确!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		if (user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("InterfaceServlet?opr=index");
		} else {
			request.setAttribute("msg", "账号错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

	private void doQuery(HttpServletRequest request, HttpServletResponse response) {
	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {// 注册用户

		String u_username = request.getParameter("u_username");
		String u_password = request.getParameter("u_password");
		String u_sex = request.getParameter("u_sex");
		User user = new User();

		user.setU_username(u_username);
		user.setU_password(u_password);
		user.setU_sex(u_sex);
		UserService userService = new UserService();
		userService.addUser(user);
		request.setAttribute("msg", "注册成功");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
