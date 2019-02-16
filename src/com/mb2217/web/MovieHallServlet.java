package com.mb2217.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mb2217.dao.MovieUserDAO;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Movie_Hall;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.PageBean;
import com.mb2217.service.MovieUserService;
import com.mb2217.service.ServiceProxyFactory;
import com.mb2217.util.OAUtil;

/**
 * Servlet implementation class MovieUserServlet
 */
@WebServlet("/MovieHall")
public class MovieHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 MovieUserService movieuserservice = ServiceProxyFactory.getService(MovieUserService.class);
		 //new MovieUserService();
			//ServiceProxyFactory.getService(MovieUserService.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieHallServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String opr = request.getParameter("opr");
		if ("addhall".equals(opr)) {
			doaddmovhall(request, response);
		} else if ("query".equals(opr)) {
			doquery(request, response);
		} else if ("delhall".equals(opr)) {
			dodelmovhall(request, response);
		} else if ("initupdatehall".equals(opr)) {
			doinitupdate(request, response);
		} else if ("updatehall".equals(opr)) {
			doupdate(request, response);
		} else if ("initaddhall".equals(opr)) {
			doinitaddhall(request, response);
		}

	}

	private void doinitaddhall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("moviehall/movie_add.jsp");

	}

	private void doquery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		String mh_name = request.getParameter("mh_name");
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		Movie_Hall movhall = new Movie_Hall();
		movhall.setMh_name(mh_name);
		movhall.setC_id(cinema.getC_id());
		request.setAttribute("movhall", movhall);
		PageBean<Movie_Hall> pageBean = movieuserservice.getMoviehallsByPage(page, movhall);
		request.setAttribute("pageBean", pageBean);

		// 跳转页面
		request.getRequestDispatcher("moviehall/movie_list.jsp").forward(request, response);

	}

	private void doupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("mh_id");
		Integer c_id = Integer.parseInt(request.getParameter("c_id"));
		String mh_name = request.getParameter("mh_name");
		Movie_Hall movhall = new Movie_Hall();
		movhall.setC_id(c_id);
		movhall.setMh_id(id);
		movhall.setMh_name(mh_name);
		movieuserservice.updatMoviehall(movhall);
		response.sendRedirect("MovieHall?opr=query");
	}

	private void doinitupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		String id = request.getParameter("mh_id");
		Movie_Hall movhall = movieuserservice.getMoviehall(id,cinema.getC_id());
		request.setAttribute("movhall", movhall);

		// 跳转页面
		request.getRequestDispatcher("moviehall/movie_update.jsp").forward(request, response);
	}

	private void dodelmovhall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		String id = request.getParameter("mh_id");
		movieuserservice.delMoviehall(id,cinema.getC_id());
		response.sendRedirect("MovieHall?opr=query");
	}

	private void doaddmovhall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sum = 0;
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		String mh_name = request.getParameter("mh_name");
		Movie_Hall movhall = new Movie_Hall();
		movhall.setC_id(cinema.getC_id());
		movhall.setMh_id(OAUtil.getId());
		movhall.setMh_name(mh_name);
		movhall.setSeat_number(sum);
		movieuserservice.addMoviehall(movhall);
		response.sendRedirect("MovieHall?opr=query");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
