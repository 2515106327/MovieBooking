package com.mb2217.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.mb2217.dao.InterfaceDao;
import com.mb2217.entity.Area;
import com.mb2217.entity.Booking;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Film;
import com.mb2217.entity.PageBean;
import com.mb2217.entity.Seat;
import com.mb2217.entity.Timing;


public class InterfaceService {
	public PageBean<Film> InterfaceFilm(int page,Film film){//获取电影表
		InterfaceDao interfaceDao=new InterfaceDao();
		int pageSize = 10;
		PageBean<Film> pageBean = new PageBean<Film>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		InterfaceDao FilmDao = new InterfaceDao();
		List<Film> data = FilmDao.getTimingfilmAll(page, pageSize, film);
		pageBean.setData(data);
		int totalNum = interfaceDao.getFilmCount(film);
		pageBean.setTotalNum(totalNum);
		pageBean.setActualSize(data.size());
		int totalPage=totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
	public Film getFilm(int f_id){//获取单个电影
		InterfaceDao interfaceDao=new InterfaceDao();
		Film film=interfaceDao.getFilmById(f_id);
		return film;
	}
	public Cinema getCinema(int c_id){//获取单个电影院
		InterfaceDao interfaceDao=new InterfaceDao();
		Cinema cinema=interfaceDao.getCinemaById(c_id);
		return cinema;
	}
	
	public PageBean<Cinema> InterfaceCinema(int page,Cinema cinema){//获取电影院表
		InterfaceDao interfaceDao=new InterfaceDao();
		int pageSize = 10;
		PageBean<Cinema> pageBean = new PageBean<Cinema>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		InterfaceDao CinemaDao = new InterfaceDao();
		List<Cinema> data = CinemaDao.getCinema(page, pageSize,cinema);
		System.out.println(data);
		pageBean.setData(data);
		pageBean.toString();
		int totalNum = interfaceDao.getCinemaCount(cinema);
		pageBean.setTotalNum(totalNum);
		pageBean.setActualSize(data.size());
		int totalPage=totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
	public List<Area> getAreas(){//获取选择地区
		return new InterfaceDao().getAreaAll();
	}
	public List<Cinema> getCinemas(){//获取选择电影
		return new InterfaceDao().getCinemas();
	}
	public List<Film> getCinemaFilms(int c_id){
		return new InterfaceDao().getCinemaFilm(c_id);
	}
	public PageBean<Timing> getInterfaceTiming(int page,int c_id,int f_id){//获取单个电影院放映表
		InterfaceDao interfaceDao=new InterfaceDao();
		int pageSize = 10;
		PageBean<Timing> pageBean = new PageBean<Timing>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		InterfaceDao TimingDao = new InterfaceDao();
		List<Timing> data = TimingDao.getTiming(page, pageSize, c_id, f_id);
		pageBean.setData(data);
		int totalNum = interfaceDao.getTimingCount(c_id, f_id);
		pageBean.setTotalNum(totalNum);
		pageBean.setActualSize(data.size());
		int totalPage=totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
	public List<Film> gethotFilm(){//获取热度电影
		List<Film> films= new InterfaceDao().getFilmAll();
		return films;
	}	
	
	public List<Film> getDataFilm(){//获取新上映电影
		List<Film> films= new InterfaceDao().getFilmData();
		return films;
	}
	public void buy(Seat seat,Booking booking){
		new InterfaceDao().UpdateSeat(seat);
		new InterfaceDao().Booking(booking);
	}
	
	public List<Seat> getDataSeat(String mh_id){//获取座位
		List<Seat> seats= new InterfaceDao().getseats(mh_id);
		return seats;
	}
	public Timing gettiming(int t_id){//获取放映表
		return  new InterfaceDao().getTiming(t_id);
	}

	
}
