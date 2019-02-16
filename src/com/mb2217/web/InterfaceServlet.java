package com.mb2217.web;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mb2217.entity.Area;
import com.mb2217.entity.Booking;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Film;
import com.mb2217.entity.PageBean;
import com.mb2217.entity.Seat;
import com.mb2217.entity.Timing;
import com.mb2217.entity.User;
import com.mb2217.service.InterfaceService;

/**
 * Servlet implementation class InterfaceServlet
 */
@WebServlet("/InterfaceServlet")
public class InterfaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterfaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String opr = request.getParameter("opr");
		if("filmquery".equals(opr)){
			doFilmquery(request, response);
		}else if("showfilm".equals(opr)){
			doShowFilm(request, response);
		}else if("cinemaquery".equals(opr)){
			doCinemaquery(request, response);
		}else if("timingquery".equals(opr)){
			doTimingquery(request, response);
		}else if("index".equals(opr)){
			doIndexquery(request, response);
		}else if("seatinit".equals(opr)){
			doSeatInit(request, response);
		}else if("buy".equals(opr)){
			dobuy(request, response);
		}
	}

	private void dobuy(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {//
		String mh_id=request.getParameter("mh_id");
		int t_id=Integer.parseInt(request.getParameter("t_id"));
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		User user=(User) request.getSession().getAttribute("user");
		int u_id=user.getU_id();
		double b_paym=Double.parseDouble(request.getParameter("t_price"));
		Seat seat=new Seat();
		Booking booking=new Booking();
		seat.setS_op(true);
		seat.setS_id(s_id);
		seat.setMh_id(mh_id);
		booking.setB_paym(b_paym);
		booking.setS_id(s_id);
		booking.setT_id(t_id);
		booking.setU_id(u_id);
     InterfaceService buy=new InterfaceService();
     buy.buy(seat, booking);
     response.sendRedirect("index.jsp");
	}

	private void doSeatInit(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {//座位
		int t_id=Integer.parseInt(request.getParameter("t_id"));
		Timing timing=new  InterfaceService().gettiming(t_id);
		
		InterfaceService inter= new InterfaceService();
		String mh_id=timing.getMh_id();
		
		List<Seat> seats=inter.getDataSeat(mh_id);
		request.setAttribute("timing",timing);
		request.setAttribute("seats",seats);
		request.getRequestDispatcher("movie/seat.jsp").forward(request, response);
		
	}

	private void doIndexquery(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {//主页
		List<Film> films=new InterfaceService().gethotFilm();
		List<Film> filmdata=new InterfaceService().getDataFilm();
		Film[] filmh=new Film[3];
		Film[] filmd=new Film[3];
		for (int i = 0; i < 3; i++) {
			filmh[i]=films.get(i);
		}
		for (int i = 0; i < 3; i++) {
			filmd[i]=filmdata.get(i);
			System.out.println(filmd[i]);
		}
		request.setAttribute("filmh", filmh);
		request.setAttribute("filmd", filmd);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void doTimingquery(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {//显示放映电影
		int page=1;
		if (request.getParameter("page") != null) {
			page= Integer.parseInt(request.getParameter("page"));
		}
		int c_id=Integer.parseInt(request.getParameter("c_id"));
		int f_id=Integer.parseInt(request.getParameter("f_id"));
		InterfaceService timingquery=new InterfaceService();
		if(f_id==0){
			List<Film> filmsm=timingquery.getCinemaFilms(c_id);
			Iterator<Film> iterator=filmsm.iterator();
			Film film=iterator.next();
			f_id=film.getF_id();
		}
		PageBean<Timing> peanbean=timingquery.getInterfaceTiming(page, c_id, f_id);
		List<Film> films=timingquery.getCinemaFilms(c_id);
		Cinema cinema=timingquery.getCinema(c_id);
		Film film=timingquery.getFilm(f_id);
		request.setAttribute("cinema", cinema);
		request.setAttribute("pagebean",peanbean);
		request.setAttribute("films", films);
		request.setAttribute("film", film);
		request.getRequestDispatcher("movie/timing.jsp").forward(request, response);
	}

	private void doCinemaquery(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {//显示电影院
		int page=1;
		if (request.getParameter("page") != null) {
			page= Integer.parseInt(request.getParameter("page"));
		}
		int f_id=0;
		if(request.getParameter("f_id")!=null){
		f_id=Integer.parseInt(request.getParameter("f_id"));
		}
		int a_id=0;
		if(request.getParameter("a_id")!=null){
		a_id=Integer.parseInt(request.getParameter("a_id"));
		}
		String c_name=request.getParameter("c_name");
		Cinema cinema=new Cinema();
		cinema.setF_id(f_id);
		cinema.setC_name(c_name);
		cinema.setA_id(a_id);
		request.getParameter("Cinema");
		InterfaceService cinemaquery=new InterfaceService();
		PageBean<Cinema> peanbean=cinemaquery.InterfaceCinema(page, cinema);
		InterfaceService areas=new InterfaceService();
		InterfaceService cinemas=new InterfaceService();
		List<Area> Areas=areas.getAreas();
		List<Cinema> Cinemas=cinemas.getCinemas();
		Film film=areas.getFilm(f_id);
		request.setAttribute("film", film);
		request.setAttribute("pagebean", peanbean);
		request.setAttribute("Areas", Areas);
		request.setAttribute("Cinemas", Cinemas);
		request.setAttribute("Cinema", cinema);
		request.getRequestDispatcher("movie/cinema.jsp").forward(request, response);
	}

	private void doShowFilm(HttpServletRequest request, HttpServletResponse response) 
		    throws ServletException, IOException {//显示电影信息
		int f_id=Integer.parseInt(request.getParameter("f_id"));
		InterfaceService showfilm=new InterfaceService();
		Film film=showfilm.getFilm(f_id);
		request.setAttribute("film", film);
		request.getRequestDispatcher("movie/film.jsp").forward(request, response);
		
	}

	private void doFilmquery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {//按条件查询电影
		int page=1;
		if (request.getParameter("page")!= null) {
			page= Integer.parseInt(request.getParameter("page"));
		}
		String f_type=request.getParameter("f_type");
		Film film=new Film();
		film.setF_type(f_type);
		InterfaceService filmquery=new InterfaceService();
		PageBean<Film> peanbean=filmquery.InterfaceFilm(page, film);
		request.setAttribute("f_type", f_type);
		request.setAttribute("pagebean", peanbean);
		request.getRequestDispatcher("movie/movie_display.jsp").forward(request, response);
	}
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
