package com.mb2217.service;

import java.util.List;

import com.mb2217.dao.MovieUserDAO;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Film;
import com.mb2217.entity.Movie_Hall;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.Seat;
import com.mb2217.entity.Timing;
import com.mb2217.entity.PageBean;

public class MovieUserService {
	MovieUserDAO movieuserdao = new MovieUserDAO();
	public Movie_User getCinemaName(int id){
		return movieuserdao.getCinemaNameByUserId(id);
	}
	/**
	 * 通过账户密码获取用户
	 * @param name
	 * @param password
	 * @return
	 */
	public Movie_User getUserByNameAndPswd(String name,String password){
		return movieuserdao.getCUserByNameAndPswd(name, password);
	}

	/**
	 * 增加影厅
	 * 
	 * @param movhall
	 */
	public void addMoviehall(Movie_Hall movhall) {
		movieuserdao.addMoviehall(movhall);
		movieuserdao.updateCinemaCnum(movhall.getC_id(), 1);
	}

	/**
	 * 修改影厅数据
	 * 
	 * @param movhall
	 */
	public void updatMoviehall(Movie_Hall movhall) {
		movieuserdao.updateMoviehall(movhall);
	}

	/**
	 * 删除影厅并减少电影院的影厅数量
	 * 
	 * @param id
	 */
	public void delMoviehall(String id,int c_id) {
		Movie_Hall movhall = movieuserdao.getMoviehallByMh_id(id,c_id);
		movieuserdao.updateCinemaCnum(movhall.getC_id(), -1);
		movieuserdao.delMoviehall(id);
	}
	/**
	 * 单独设置电影院影厅的数量
	 * @param id
	 * @param sum
	 */
	public void updateCinemaCnum(int id,int sum){
		movieuserdao.updateCinemaCnum(id, sum);
	}

	/**
	 * 获取单个的影厅
	 * 
	 * @param id
	 * @return
	 */
	public Movie_Hall getMoviehall(String id,int c_id) {
		return movieuserdao.getMoviehallByMh_id(id,c_id);
	}

	/**
	 * 获取所有的影厅
	 * 
	 * @return
	 */
	public List<Movie_Hall> getMoviehalls(int id) {
		return movieuserdao.getMoviehalls(id);
	}

	/**
	 * 分页查询影厅
	 * 
	 * @param page
	 * @param movhall
	 * @return
	 */
	public PageBean<Movie_Hall> getMoviehallsByPage(int page, Movie_Hall movhall) {
		int pageSize = 5;
		PageBean<Movie_Hall> pageBean = new PageBean<Movie_Hall>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);

		List<Movie_Hall> data = movieuserdao.getMoviehallsByPage(page, pageSize, movhall);
		pageBean.setData(data);
		int totalNum = movieuserdao.getMoviehallCount();
		pageBean.setTotalNum(totalNum);

		pageBean.setActualSize(data.size());
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	/**
	 * 添加单个位子
	 * @param seat
	 */
	public void addSeat(Seat seat){
		movieuserdao.addSeat(seat);
		movieuserdao.updateSeatNumber(seat.getMh_id(), 1);
	}
	/**
	 * 删除位子
	 * @param id
	 */
	public void delSeat(int id){
		Seat seat=movieuserdao.getSeatByS_id(id);
		movieuserdao.updateSeatNumber(seat.getMh_id(), -1);
		movieuserdao.delSeat(id);
	}
	/**
	 * 更改位子信息
	 * @param seat
	 */
	public void updateSeat(Seat seat){
		movieuserdao.updateSeat(seat);
	}
	/**
	 * 获取单个位子
	 * @param id
	 * @return
	 */
	public Seat getSeat(int id){
		return movieuserdao.getSeatByS_id(id);
	}
	/**
	 * 获取全部位子
	 * @return
	 */
	public List<Seat> getSeats(){
		return movieuserdao.getSeats();
	}
	/**
	 * 分页获取位子
	 * @param page
	 * @param seat
	 * @return
	 */
	public PageBean<Seat> getSeatsByPage(int page, Seat seat) {
		int pageSize = 5;
		PageBean<Seat> pageBean = new PageBean<Seat>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);

		List<Seat> data = movieuserdao.getSeatsByPage(page, pageSize, seat);
		pageBean.setData(data);
		int totalNum = movieuserdao.getSeatCount();
		pageBean.setTotalNum(totalNum);

		pageBean.setActualSize(data.size());
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	/**
	 * 添加电影
	 * @param film
	 */
	public void addFilm(Film film){
		movieuserdao.addFilm(film);
	}
	/**
	 * 删除电影
	 * @param id
	 */
	public void delFilm(int id,int c_id){
		movieuserdao.delFilm(id,c_id);
	}
	/**
	 * 更改电影信息
	 * @param film
	 */
	public void updateFilm(Film film){
		movieuserdao.updateFilm(film);
	}
	/**
	 * 获取电影
	 * @param id
	 * @return
	 */
	public Film getFilm(int id,int c_id){
		return movieuserdao.getFilmByF_id(id,c_id);
	}
	/**
	 *  获取全部电影
	 * @return
	 */
	public List<Film> getFilms(){
		return movieuserdao.getFilms();
	}
	/**
	 * 分页获取电影
	 * @param page
	 * @param film
	 * @return
	 */
	public PageBean<Film> getFilmsByPage(int page, Film film) {
		int pageSize = 10;
		PageBean<Film> pageBean = new PageBean<Film>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);

		List<Film> data = movieuserdao.getFilmsByPage(page, pageSize, film);
		pageBean.setData(data);
		int totalNum = movieuserdao.getFilmCount();
		pageBean.setTotalNum(totalNum);

		pageBean.setActualSize(data.size());
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	/**
	 * 增加放映单
	 * @param timing
	 */
	public void addTiming(Timing timing){
		movieuserdao.addTiming(timing);
	}
	/**
	 * 删除放映单
	 * @param id
	 */
	public void delTiming(int id,int c_id){
		movieuserdao.delTimingById(id,c_id);
	}
	/**
	 * 更改放映单
	 * @param timing
	 */
	public void updateTiming(Timing timing){
		movieuserdao.updateTiming(timing);
	}
	/**
	 * 获取放映单
	 * @param id
	 * @return Timing
	 */
	public Timing getTiming(int id,int c_id){
		return movieuserdao.getTimingByT_id(id,c_id);
	}
	/**
	 * 获取全部放映单
	 * @return List<Timing>
	 */
	public List<Timing> getTimings(int c_id){
		return movieuserdao.getTimings(c_id);
	}
	/**
	 * 分页获取电影单
	 * @param page
	 * @param timing
	 * @return pageBean<Timing>
	 */
	public PageBean<Timing> getTimingsByPage(int page, Timing timing) {
		int pageSize = 10;
		PageBean<Timing> pageBean = new PageBean<Timing>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);

		List<Timing> data = movieuserdao.getTimingsByPage(page, pageSize, timing);
		pageBean.setData(data);
		int totalNum = movieuserdao.getFilmCount();
		pageBean.setTotalNum(totalNum);

		pageBean.setActualSize(data.size());
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}
	public Cinema getCinemaC_ic(int id){
		return movieuserdao.getCinemaC_ic(id);
	}
	
	

}
