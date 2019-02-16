package com.mb2217.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mb2217.entity.Cinema;
import com.mb2217.entity.Film;
import com.mb2217.entity.Movie_Hall;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.Timing;
import com.mb2217.entity.PageBean;
import com.mb2217.service.MovieUserService;
import com.mb2217.service.ServiceProxyFactory;
import com.mb2217.util.OAUtil;

/**
 * Servlet implementation class MovieFilmServlet
 */
@WebServlet("/moviefilm")
@MultipartConfig
public class MovieFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieUserService movieuserservice = ServiceProxyFactory.getService(MovieUserService.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieFilmServlet() {
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
		if ("addfilm".equals(opr)) {
			doaddFilm(request, response);
		} else if ("updatefilm".equals(opr)) {
			doUpdateFilm(request, response);
		} else if ("delfilm".equals(opr)) {
			doDelFilm(request, response);
		} else if ("queryfilm".equals(opr)) {
			doQueryFilm(request, response);
		} else if ("addtiming".equals(opr)) {
			doAddTiming(request, response);
		} else if ("deltiming".equals(opr)) {
			doDeltiming(request, response);
		} else if ("updatetiming".equals(opr)) {
			doUpdateTiming(request, response);
		} else if ("querytiming".equals(opr)) {
			doQueryTiming(request, response);
		} else if ("initupdatefilm".equals(opr)) {
			doinitupdatefilm(request, response);
		} else if ("addinittiming".equals(opr)) {
			doaddinittiming(request, response);
		} else if ("initupdatetiming".equals(opr)) {
			doinitupdatetiming(request, response);
		} else if ("initaddfilm".equals(opr)) {
			doinitaddfilm(request, response);
		} else if ("inittimingquery".equals(opr)) {
			doinittimingquery(request, response);
		}
	}

	private void doinitupdatefilm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		Integer id = Integer.parseInt(request.getParameter("f_id"));
		Film film = movieuserservice.getFilm(id, cinema.getC_id());
		request.setAttribute("film", film);

		// 跳转更新页面
		request.getRequestDispatcher("Film/film_update.jsp").forward(request, response);

	}

	private void doinitaddfilm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Film/film_add.jsp");

	}

	private void doaddFilm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("f_name");
		String director = request.getParameter("f_director");
		String play = request.getParameter("f_play");
		String intro = request.getParameter("f_intro");
		String language = request.getParameter("f_language");
		Integer f_long = Integer.parseInt(request.getParameter("f_long"));
		String date = request.getParameter("f_date");
		int hot = 0;
		String type = request.getParameter("f_type");

		Film film = new Film();
		Part part = request.getPart("f_avatar");
		if (part != null) {
			String partname = OAUtil.getId();
			String path = getServletContext().getRealPath("/images/film");
			part.write(path + "/" + partname);
			film.setF_avatar("images/film/" + partname);
		}

		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());

		film.setC_id(cinema.getC_id());
		film.setF_name(name);
		film.setF_director(director);
		film.setF_play(play);
		film.setF_intro(intro);
		film.setF_language(language);
		film.setF_long(f_long);
		film.setF_date(date);
		film.setHot(hot);
		film.setF_type(type);

		movieuserservice.addFilm(film);
		response.sendRedirect("moviefilm?opr=queryfilm");

	}

	private void doUpdateFilm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int f_id = Integer.parseInt(request.getParameter("f_id"));
		String name = request.getParameter("f_name");
		String director = request.getParameter("f_director");
		String play = request.getParameter("f_play");
		String intro = request.getParameter("f_intro");
		String language = request.getParameter("f_language");
		Integer f_long = Integer.parseInt(request.getParameter("f_long"));
		String date = request.getParameter("f_date");
		int hot = 0;
		String type = request.getParameter("f_type");

		Part part = request.getPart("f_avatar");
		String partname = OAUtil.getId();
		String path = getServletContext().getRealPath("/images/avatar");
		part.write(path + "/" + partname);

		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());

		Film film = new Film();
		film.setC_id(cinema.getC_id());
		film.setF_id(f_id);
		film.setF_name(name);
		film.setF_director(director);
		film.setF_play(play);
		film.setF_intro(intro);
		film.setF_language(language);
		film.setF_long(f_long);
		film.setF_date(date);
		film.setHot(hot);
		film.setF_type(type);
		film.setF_avatar("images/avatar/" + partname);

		movieuserservice.updateFilm(film);
		response.sendRedirect("moviefilm?opr=queryfilm");

	}

	private void doDelFilm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		int id = Integer.parseInt(request.getParameter("f_id"));
		movieuserservice.delFilm(id, cinema.getC_id());
		response.sendRedirect("moviefilm?opr=queryfilm");
	}

	private void doQueryFilm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		String name = request.getParameter("f_name");
		String type = request.getParameter("f_type");
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		Film film = new Film();
		film.setC_id(cinema.getC_id());
		film.setF_name(name);
		film.setF_type(type);
		request.setAttribute("film", film);
		PageBean<Film> pageBean = movieuserservice.getFilmsByPage(page, film);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("Film/film_list.jsp").forward(request, response);

	}

	private void doaddinittiming(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("f_id"));
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		Film film = movieuserservice.getFilm(id, cinema.getC_id());
		request.setAttribute("film", film);
		List<Movie_Hall> movhalls = movieuserservice.getMoviehalls(cinema.getC_id());
		request.setAttribute("movhalls", movhalls);
		request.getRequestDispatcher("Timing/timing_add.jsp").forward(request, response);

	}

	private void doAddTiming(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int f_id = Integer.parseInt(request.getParameter("f_id"));
		String mh_id = request.getParameter("mh_id");
		String start = request.getParameter("t_start");
		String end = request.getParameter("t_end");
		int price = Integer.parseInt(request.getParameter("t_price"));
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		Timing timing = new Timing();
		timing.setC_id(cinema.getC_id());
		timing.setF_id(f_id);
		timing.setMh_id(mh_id);
		timing.setT_start(start);
		timing.setT_end(end);
		timing.setT_price(price);
		movieuserservice.addTiming(timing);
		response.sendRedirect("moviefilm?opr=querytiming");

	}

	private void doDeltiming(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("t_id"));
		// 获取当前用户下的电影与影厅
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		movieuserservice.delTiming(id, cinema.getC_id());
		response.sendRedirect("moviefilm?opr=querytiming");

	}

	private void doinitupdatetiming(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// // TODO Auto-generated method stub
		// int id = Integer.parseInt(request.getParameter("t_id"));
		// Timing timing=movieuserservice.getTiming(id);
		// request.setAttribute("timing", timing);
		// Movie_User movuser = (Movie_User)
		// request.getSession().getAttribute("CinemaUser");
		// Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		// Film film = movieuserservice.getFilm(id,cinema.getC_id());
		// request.setAttribute("film", film);
		// List<Movie_Hall> movhall =
		// movieuserservice.getMoviehalls(cinema.getC_id());
		// request.setAttribute("Movhall", movhall);
		// request.getRequestDispatcher("").forward(request, response);

	}

	private void doUpdateTiming(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// // TODO Auto-generated method stub
		// int f_id = Integer.parseInt(request.getParameter("f_id"));
		// String mh_id = request.getParameter("mh_id");
		// String start = request.getParameter("start");
		// String end = request.getParameter("end");
		// Timing timing = new Timing();
		// timing.setF_id(f_id);
		// timing.setMh_id(mh_id);
		// timing.setT_start(start);
		// timing.setT_end(end);
		// movieuserservice.updateTiming(timing);
		// response.sendRedirect("moviefilm?opr=querytiming");

	}

	private void doinittimingquery(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
//		int id = Integer.parseInt(request.getParameter("f_id"));
//		//获取当前用户下的电影与影厅
//		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
//		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
//		Film film = movieuserservice.getFilm(id,cinema.getC_id());
//		request.setAttribute("film", film);
//		List<Movie_Hall> movhalls = movieuserservice.getMoviehalls(cinema.getC_id());
//		System.out.println(movhalls);
//		request.setAttribute("movhalls", movhalls);
		
	}

	private void doQueryTiming(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Movie_User movuser = (Movie_User) request.getSession().getAttribute("CinemaUser");
		Cinema cinema = movieuserservice.getCinemaC_ic(movuser.getMov_id());
		List<Movie_Hall> movhalls = movieuserservice.getMoviehalls(cinema.getC_id());
		request.setAttribute("movhalls", movhalls);

		String f_name = request.getParameter("f_name");
		String mh_id = request.getParameter("mh_id");
		Timing timing = new Timing();
		timing.setC_id(cinema.getC_id());
		timing.setF_name(f_name);
		timing.setMh_id(mh_id);
		request.setAttribute("timing", timing);
		PageBean<Timing> pageBean = movieuserservice.getTimingsByPage(page, timing);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("Timing/timing_list.jsp").forward(request, response);
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
