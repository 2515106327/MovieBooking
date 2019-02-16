package com.mb2217.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mb2217.entity.Area;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.PageBean;
import com.mb2217.entity.System_user;
import com.mb2217.service.AreaService;
import com.mb2217.service.CinemaService;
import com.mb2217.service.Mh_userService;
import com.mb2217.service.ServiceProxyFactory;
import com.mb2217.service.System_userService;

@WebServlet("/Sys_sys_userServlet")
public class Sys_userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sys_userServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String opr = request.getParameter("opr");
		if ("login".equals(opr)) {
			doLogin(request, response);
		} else if ("logout".equals(opr)) {
			Logout(request, response);
		}
		// 地区事务判断开始
		else if ("areainitadd".equals(opr)) {
			doAreaInitAdd(request, response);
		} else if ("areaadd".equals(opr)) {
			doAreaAdd(request, response);
		} else if ("areaquery".equals(opr)) {
			doAreaQuery(request, response);
		} else if ("areainitupdate".equals(opr)) {
			doAreaInitUpdate(request, response);
		} else if ("areaupdate".equals(opr)) {
			doAreaUpdate(request, response);
		} else if ("areainitdel".equals(opr)) {
			doAreaDel(request, response);
		}

		// 地区事务判断结束

		// 电影院管理员事物判断开始
		else if ("movie_userinitadd".equals(opr)) {
			doMh_userInitAdd(request, response);
		} else if ("movie_useradd".equals(opr)) {
			doMh_userAdd(request, response);
		} else if ("movie_userquery".equals(opr)) {
			doMh_userQuery(request, response);
		} else if ("movie_userinitupdate".equals(opr)) {
			doMh_userInitUpdate(request, response);
		} else if ("movie_userupdate".equals(opr)) {
			doMh_userUpdate(request, response);
		} else if ("movie_userinitdel".equals(opr)) {
			doMh_userDel(request, response);
		}
		// 电影院管理员事物判断结束
		// 电影院事物判断开始
		else if ("cinemainitadd".equals(opr)) {
			doCinemaInitAdd(request, response);
		} else if ("cinemaadd".equals(opr)) {
			doCinemaAdd(request, response);

		} else if ("cinemaquery".equals(opr)) {
			doCinemaQuery(request, response);
		} else if ("cinemasearchquery".equals(opr)) {
			doCinemaSearchQuery(request, response);
		} else if ("cinemainitupdate".equals(opr)) {
			doCinemaInitUpdate(request, response);

		} else if ("cinemaupdate".equals(opr)) {
			doCinemaUpdate(request, response);
		} else if ("cinemainitdel".equals(opr)) {
			doCinemaDel(request, response);
		}
		// 电影院事物判断结束
		else {

		}
	}

	private void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("sys_user");
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sys_name = request.getParameter("sys_name");
		String sys_password = request.getParameter("sys_password");
		String code = request.getParameter("code");
		// 获取域中的session
		HttpSession session = request.getSession();
		String wcode = (String) session.getAttribute("wcode");

		System_userService sys_userService = new System_userService();
		System_user sys_user = sys_userService.login(sys_name, sys_password);
		// 忽略大小写验证
		if (wcode.equalsIgnoreCase(code) == false) {
			request.setAttribute("msg", "验证码不正确!");
			request.getRequestDispatcher("syslogin.jsp").forward(request, response);
		}
		if (sys_user != null) {
			request.getSession().setAttribute("sys_user", sys_user);
			response.sendRedirect("sysindex.jsp");
		} else {
			request.setAttribute("msg", "帐号或密码不正确!");
			request.getRequestDispatcher("syslogin.jsp").forward(request, response);
		}
	}

	// 电影院管理员动作处理开始
	private void doMh_userUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 更改账号 和 密码
		String id = request.getParameter("mov_id");
		String name = request.getParameter("mov_name");
		String password = request.getParameter("mov_password");

		Movie_User mh_user = new Movie_User();
		mh_user.setMov_id((Integer.parseInt(id)));
		mh_user.setMov_name(name);
		mh_user.setMov_password(password);
		// 反射
		Mh_userService mh_userService = ServiceProxyFactory.getService(Mh_userService.class);
		mh_userService.updateMh_user(mh_user);

		response.sendRedirect("Sys_sys_userServlet?opr=movie_userquery");
	}

	private void doMh_userDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("mov_id");

		Mh_userService mh_userService = ServiceProxyFactory.getService(Mh_userService.class);
		mh_userService.delMh_user(Integer.parseInt(id));

		response.sendRedirect("Sys_sys_userServlet?opr=movie_userquery");
	}

	private void doMh_userInitUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mh_id = request.getParameter("mov_id");
		Mh_userService mh_userService = new Mh_userService();
		Movie_User movie_user = mh_userService.getMh_userById(Integer.parseInt(mh_id));
		request.setAttribute("movie_user", movie_user);

		request.getRequestDispatcher("movie_user/movie_user_update.jsp").forward(request, response);
	}

	private void doMh_userInitAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("movie_user/movie_user_add.jsp").forward(request, response);
	}

	private void doMh_userAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mov_name = request.getParameter("mov_name");
		String mov_password = request.getParameter("mov_password");

		Movie_User mh_user = new Movie_User();
		mh_user.setMov_name(mov_name);
		mh_user.setMov_password(mov_password);

		Mh_userService mh_userService = ServiceProxyFactory.getService(Mh_userService.class);
		mh_userService.addMh_user(mh_user);

		response.sendRedirect("Sys_sys_userServlet?opr=movie_userquery");
	}

	private void doMh_userQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		Mh_userService mh_userService = new Mh_userService();
		PageBean<Movie_User> pageBean = mh_userService.getMh_usersByPage(page);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("movie_user/movie_user_list.jsp").forward(request, response);

	}

	// 电影院管理员动作结束

	// 地区动作开始

	private void doAreaInitAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("area/area_add.jsp").forward(request, response);
	}

	private void doAreaAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a_name = request.getParameter("a_name");

		Area area = new Area();
		area.setA_name(a_name);

		AreaService areaService = ServiceProxyFactory.getService(AreaService.class);
		areaService.addArea(area);

		response.sendRedirect("Sys_sys_userServlet?opr=areaquery");
	}

	private void doAreaDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("a_id");

		AreaService areaService = ServiceProxyFactory.getService(AreaService.class);
		areaService.delArea(Integer.parseInt(id));

		response.sendRedirect("Sys_sys_userServlet?opr=areaquery");
	}

	private void doAreaInitUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a_id = request.getParameter("a_id");
		AreaService areaService = new AreaService();
		Area area = areaService.getAreaById(Integer.parseInt(a_id));
		request.setAttribute("area", area);
		request.getRequestDispatcher("area/area_update.jsp").forward(request, response);
	}

	private void doAreaUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("a_id");
		String name = request.getParameter("a_name");

		Area area = new Area();
		area.setA_id(Integer.parseInt(id));
		area.setA_name(name);
		AreaService areaService = ServiceProxyFactory.getService(AreaService.class);

		areaService.updateArea(area);

		response.sendRedirect("Sys_sys_userServlet?opr=areaquery");
	}

	private void doAreaQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		AreaService areaService = new AreaService();
		PageBean<Area> pageBean = areaService.getAreasByPage(page);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("area/area_list.jsp").forward(request, response);

	}

	// 地区动作结束

	// 电影院动作开始

	private void doCinemaUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String c_id = request.getParameter("c_id");
		String c_name = request.getParameter("c_name");
		String c_num = request.getParameter("c_num");
		String c_tel = request.getParameter("c_tel");

		String a_id = request.getParameter("a_id");
		String m_userid = request.getParameter("m_userid");

		String c_adr = request.getParameter("c_adr");

		Cinema cinema = new Cinema();
		cinema.setC_id(Integer.parseInt(c_id));
		cinema.setC_name(c_name);
		cinema.setC_num(Integer.parseInt(c_num));
		cinema.setC_tel(c_tel);

		cinema.setA_id(Integer.parseInt(a_id));
		cinema.setMov_id(Integer.parseInt(m_userid));

		cinema.setC_adr(c_adr);

		CinemaService cinemaService = ServiceProxyFactory.getService(CinemaService.class);
		cinemaService.updateCinema(cinema);

		response.sendRedirect("Sys_sys_userServlet?opr=cinemaquery");
	}

	private void doCinemaDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("c_id");

		CinemaService cinemaService = ServiceProxyFactory.getService(CinemaService.class);
		cinemaService.delCinema(Integer.parseInt(id));

		response.sendRedirect("Sys_sys_userServlet?opr=cinemaquery");
	}

	private void doCinemaInitUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String c_id = request.getParameter("c_id");
		CinemaService cinemaService = new CinemaService();
		Cinema cinema = cinemaService.getCinemaById(Integer.parseInt(c_id));
		request.setAttribute("cinema", cinema);

		List<Area> area = cinemaService.getAreas();
		request.setAttribute("areas", area);
		List<Movie_User> movie_User = cinemaService.getMovie_Users();
		request.setAttribute("movie_Users", movie_User);
		request.getRequestDispatcher("cinema/cinema_update.jsp").forward(request, response);
	}

	private void doCinemaInitAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AreaService areaService = new AreaService();
		List<Area> area = areaService.getAreas();
		request.setAttribute("areas", area);

		Mh_userService mhuserService = new Mh_userService();

		List<Movie_User> movie_User = mhuserService.getMovie_Users();
		request.setAttribute("movie_Users", movie_User);
		request.getRequestDispatcher("cinema/cinema_add.jsp").forward(request, response);
	}

	private void doCinemaAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String c_name = request.getParameter("c_name");
		String c_num = request.getParameter("c_num");
		String c_tel = request.getParameter("c_tel");
		String m_userid = request.getParameter("m_userid");
		String a_id = request.getParameter("a_id");
		String c_adr = request.getParameter("c_adr");

		Cinema cinema = new Cinema();
		cinema.setC_name(c_name);
		cinema.setC_num(Integer.parseInt(c_num));
		cinema.setC_tel(c_tel);
		cinema.setMov_id(Integer.parseInt(m_userid));
		cinema.setA_id(Integer.parseInt(a_id));
		cinema.setC_adr(c_adr);

		CinemaService cinemaService = ServiceProxyFactory.getService(CinemaService.class);
		cinemaService.addCinema(cinema);

		response.sendRedirect("Sys_sys_userServlet?opr=cinemaquery");
	}

	private void doCinemaQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		AreaService areaService = new AreaService();

		List<Area> area = areaService.getAreas();
		request.setAttribute("areas", area);

		CinemaService cinemaService = new CinemaService();
		PageBean<Cinema> pageBean = cinemaService.getCinemasByPage(page);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("cinema/cinema_list.jsp").forward(request, response);

	}

	private void doCinemaSearchQuery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		AreaService areaService = new AreaService();

		List<Area> area = areaService.getAreas();
		request.setAttribute("areas", area);

		String c_name = request.getParameter("c_name");
		String a_id = request.getParameter("a_id");
		Cinema cinema = new Cinema();
		cinema.setA_id(Integer.parseInt(a_id));
		cinema.setC_name(c_name);
		CinemaService cinemaService = new CinemaService();
		PageBean<Cinema> pageBean = cinemaService.getCinemasSearchByPage(page, cinema);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("cinema/cinema_list.jsp").forward(request, response);

	}
	// 电影院动作结束

}
