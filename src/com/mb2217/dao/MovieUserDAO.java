package com.mb2217.dao;

import java.util.List;

import com.mb2217.entity.Cinema;
import com.mb2217.entity.Film;
import com.mb2217.entity.Movie_Hall;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.Seat;
import com.mb2217.entity.Timing;

public class MovieUserDAO {
	
	
	public Movie_User getCinemaNameByUserId(int id){
		String sql = "select c_name from movie_user m,cinema c where m.mov_id=c.mov_id and c.mov_id=?";
		return DbHelper.getSingle(sql, Movie_User.class, id);
	}
	/**
	 * 按账户密码查询影院管理员
	 * 
	 * @param name
	 * @param password
	 * @return Movie_User
	 */
	public Movie_User getCUserByNameAndPswd(String name, String password) {
		String sql = "select * from movie_user where  mov_name=? and mov_password=?";
		return DbHelper.getSingle(sql, Movie_User.class, name, password);
	}

	/**
	 * 添加影厅
	 * 
	 * @param movhall
	 */
	public void addMoviehall(Movie_Hall movhall) {
		String sql = "insert into movie_hall values(?,?,?,?)";
		DbHelper.executeSQL(sql, movhall.getMh_id(), movhall.getC_id(), movhall.getSeat_number(), movhall.getMh_name());
	}

	/**
	 * 更改影厅
	 * 
	 * @param movhall
	 */
	public void updateMoviehall(Movie_Hall movhall) {
		String sql = "update movie_hall set mh_name=? where mh_id=?";
		DbHelper.executeSQL(sql, movhall.getMh_name(), movhall.getMh_id());
	}

	/**
	 * 删除影厅
	 * 
	 * @param mh_id
	 */
	public void delMoviehall(String mh_id) {
		String sql = "delete from movie_hall where mh_id=?";
		DbHelper.executeSQL(sql, mh_id);
	}

	/**
	 * 通过id获取影厅
	 * 
	 * @param id
	 * @return Movie_Hall
	 */
	public Movie_Hall getMoviehallByMh_id(String mh_id,int c_id) {
		String sql = "select mh_id,seat_number,mh_name from movie_hall,cinema where cinema.c_id=movie_hall.c_id and cinema.c_id=? and mh_id=?";
		return DbHelper.getSingle(sql, Movie_Hall.class,c_id, mh_id);
	}

	/**
	 * c_id获取全部影厅
	 * 
	 * @return List<Movie_Hall>
	 */
	public List<Movie_Hall> getMoviehalls(int id) {
		String sql = "select * from movie_hall where c_id=?";
		return DbHelper.getResults(sql, Movie_Hall.class, id);
	}

	/**
	 * 更改影厅位子数量
	 * 
	 * @param id
	 * @param sum
	 */
	public void updateSeatNumber(String id, int sum) {
		DbHelper.executeSQL("update movie_hall set seat_number=seat_number+? where mh_id=?", sum, id);
	}

	/**
	 * 获取影厅数量
	 * 
	 * @return
	 */
	public int getMoviehallCount() {
		return DbHelper.getScalar("select count(*) from movie_hall", long.class).intValue();
	}

	/**
	 * 分页条件查询影厅
	 * 
	 * @param page
	 *            第几页
	 * @param pageSize
	 *            每页数量
	 * @param movhall
	 * @return
	 */
	public List<Movie_Hall> getMoviehallsByPage(int page, int pageSize, Movie_Hall movhall) {
		String sql = "select m.*from movie_hall m,cinema c where m.c_id=c.c_id and c.c_id=? " + getMoviehallCondition(movhall)
				+ " limit ?,?";
		return DbHelper.getResults(sql, Movie_Hall.class,movhall.getC_id(), (page - 1) * pageSize, pageSize);
	}

	/**
	 * 获取getMoviehallsByPage（）后半段SQL语句
	 * 
	 * @param movhall
	 * @return
	 */
	private String getMoviehallCondition(Movie_Hall movhall) {
		StringBuffer condition = new StringBuffer();

		if (movhall.getMh_name() != null && movhall.getMh_name().trim().length() != 0) {
			condition.append("and mh_name = '" + movhall.getMh_name() + "'");
		}
		return condition.toString();
	}

	/**
	 * 增加位子
	 * 
	 * @param seat
	 */
	public void addSeat(Seat seat) {
		String sql = "insert into seat(mh_id,s_xid,s_yid,s_op) values(?,?,?,?)";
		DbHelper.executeSQL(sql, seat.getMh_id(), seat.getS_xid(), seat.getS_yid(), seat.isS_op());
	}

	/**
	 * 通过s_id进行删除位子
	 * 
	 * @param s_id
	 */
	public void delSeat(int s_id) {
		String sql = "delete from seat where s_id=?";
		DbHelper.executeSQL(sql, s_id);
	}

	/**
	 * 更改位子
	 * 
	 * @param seat
	 */
	public void updateSeat(Seat seat) {
		DbHelper.executeSQL("update seat set s_xid=?,s_yid=? where s_id=?", seat.getS_xid(), seat.getS_yid(),
				seat.getS_id());
	}

	/**
	 * 通过s_id查询位子
	 * 
	 * @param s_id
	 * @return Seat
	 */
	public Seat getSeatByS_id(int s_id) {
		String sql = "select * from seat where s_id=?";
		return DbHelper.getSingle(sql, Seat.class, s_id);
	}

	/**
	 * 获取位子数量
	 * 
	 * @return
	 */
	public int getSeatCount() {
		return DbHelper.getScalar("select count(*) from seat", long.class).intValue();
	}

	/**
	 * 获取全部位子
	 * 
	 * @return List<Seat>
	 */
	public List<Seat> getSeats() {
		String sql = "select * from seat";
		return DbHelper.getResults(sql, Seat.class);
	}

	/**
	 * 分页条件查询
	 * 
	 * @param page
	 *            第几页
	 * @param pageSize
	 *            每页数量
	 * @param seat
	 * @return List<Seat>
	 */
	public List<Seat> getSeatsByPage(int page, int pageSize, Seat seat) {
		String sql = "select s.*,m.mh_name from seat s,movie_hall m where s.mh_id=m.mh_id " + getSeatCondition(seat)
				+ "limit ?,?";
		return DbHelper.getResults(sql, Seat.class, (page - 1) * pageSize, pageSize);
	}

	/**
	 * 获得getSeatsByPage（）后半段sql语句
	 * 
	 * @param seat
	 * @return String
	 */
	private String getSeatCondition(Seat seat) {
		StringBuffer condition = new StringBuffer();

		if (seat.getMh_name() != null && seat.getMh_name().trim().length() != 0) {
			condition.append("and mh_name = '" + seat.getMh_name() + "'");
		}
		return condition.toString();
	}

	/**
	 * 增添电影
	 * 
	 * @param film
	 */
	public void addFilm(Film film) {
		String sql = "insert into film(f_name,f_director,f_play,f_intro,f_language,f_long,hot,f_date,f_type,f_avatar,c_id) values(?,?,?,?,?,?,?,?,?,?,?)";
		DbHelper.executeSQL(sql, film.getF_name(), film.getF_director(), film.getF_play(), film.getF_intro(),
				film.getF_language(), film.getF_long(), film.getHot(), film.getF_date(), film.getF_type(),
				film.getF_avatar(),film.getC_id());
	}

	/**
	 * 删除电影通过f_id
	 * 
	 * @param f_id
	 */
	public void delFilm(int f_id,int c_id) {
		String sql = "delete from film where c_id=? and f_id=?";
		DbHelper.executeSQL(sql,c_id,f_id);
	}

	/**
	 * 更改电影信息
	 * 
	 * @param film
	 */
	public void updateFilm(Film film) {
		String sql = "update film set f_name=?,f_director=?,f_play=?,f_intro=?,f_language=?,f_long=?,f_date=?,f_type=?,f_avatar=? where c_id=? and f_id=?";
		DbHelper.executeSQL(sql, film.getF_name(), film.getF_director(), film.getF_play(), film.getF_intro(),
				film.getF_language(), film.getF_long(), film.getF_date(), film.getF_type(), film.getF_avatar(),film.getC_id(),
				film.getF_id());
	}

	
	
	/**
	 * 查询电影通过f_id
	 * 
	 * @param f_id
	 * @return Film
	 */
	public Film getFilmByF_id(int f_id,int c_id) {
		String sql = "select * from film where c_id=? and f_id=?";
		return DbHelper.getSingle(sql, Film.class,c_id ,f_id);
	}

	/**
	 * 获取全部电影
	 * 
	 * @return
	 */
	public List<Film> getFilms() {
		String sql = "select * from film";
		return DbHelper.getResults(sql, Film.class);
	}

	/**
	 * 分页条件查询
	 * 
	 * @param page
	 *            第几页
	 * @param pageSize
	 *            每页的数量
	 * @param film
	 * @return List<Film>
	 */
	public List<Film> getFilmsByPage(int page, int pageSize, Film film) {
		String sql = "select * from film where film.c_id=? " + getFilmCondition(film) + " limit ?,?";
		return DbHelper.getResults(sql, Film.class,film.getC_id(), (page - 1) * pageSize, pageSize);
	}

	/**
	 * 获取getFilmsByPage（）后半段sql语句
	 * 
	 * @param film
	 * @return String
	 */
	private String getFilmCondition(Film film) {
		StringBuffer condition = new StringBuffer();
		if (film.getF_name() != null && film.getF_name().trim().length() != 0) {
			condition.append("and f_name like '%" + film.getF_name() + "%'");
		}
		if (film.getF_type() != null && film.getF_type().trim().length() != 0) {
			condition.append("and f_type like '%" + film.getF_type() + "%'");
		}
		return condition.toString();
	}

	/**
	 * 获取电影数量
	 * 
	 * @return int
	 */
	public int getFilmCount() {
		return DbHelper.getScalar("select count(*) from film", long.class).intValue();
	}

	/**
	 * 添加Timing
	 * 
	 * @param timing
	 */
	public void addTiming(Timing timing) {
		String sql = "insert into timing(f_id,mh_id,t_start,t_end,t_price,c_id) values(?,?,?,?,?,?)";
		DbHelper.executeSQL(sql, timing.getF_id(), timing.getMh_id(), timing.getT_start(), timing.getT_end(),
				timing.getT_price(),timing.getC_id());
	}

	/**
	 * 删除放映单
	 * 
	 * @param t_id
	 */
	public void delTimingById(int t_id,int f_id) {
		String sql = "delete from timing where t_id=? and t.f_id=?";
		DbHelper.executeSQL(sql, t_id,f_id);
	}

	/**
	 * 更改放映单
	 * 
	 * @param timing
	 */
	public void updateTiming(Timing timing) {
		DbHelper.executeSQL("update timing set f_id=?,mh_id=?,t_start=?,t_end=?,t_price=?  where t_id=?",
				timing.getF_id(), timing.getMh_id(), timing.getT_start(), timing.getT_end(), timing.getT_price(),
				timing.getT_id());
	}

	/**
	 * 获取单个放映表
	 * 
	 * @param t_id
	 * @return
	 */
	public Timing getTimingByT_id(int t_id,int c_id) {
		String sql = "select t.*,f.f_name,f.f_price,m.mh_name from timing t,film f,movie_hall m where f.f_id=t.f_id and m.mh_id=t.mh_id and t_id=? and t.c_id=? ";
		return DbHelper.getSingle(sql, Timing.class,t_id,c_id);
	}

	/**
	 * 获取全部放映单
	 * 
	 * @return
	 */
	public List<Timing> getTimings(int c_id) {
		String sql = "select t.*,f.f_name,m.mh_name from timing t,film f,movie_hall m where f.f_id=t.f_id and m.mh_id=t.mh_id and t.c_id=?";
		return DbHelper.getResults(sql, Timing.class,c_id);
	}

	/**
	 * 分页条件查询
	 * 
	 * @param page
	 * @param pageSize
	 * @param timing
	 * @return List<Timing>
	 */
	public List<Timing> getTimingsByPage(int page, int pageSize, Timing timing) {
		String sql = "select t.*,f.f_name,m.mh_name from timing t,film f,movie_hall m where f.f_id=t.f_id and m.mh_id=t.mh_id and t.c_id=? "
				+ getTimingCondition(timing) + " limit ?,?";
		return DbHelper.getResults(sql, Timing.class, timing.getC_id(),(page - 1) * pageSize, pageSize);
	}

	/**
	 * 获取getTimingsByPage（）后半段sql语句
	 * 
	 * @param timing
	 * @return String
	 */
	private String getTimingCondition(Timing timing) {
		StringBuffer condition = new StringBuffer();
		if (timing.getF_name() != null && timing.getF_name().trim().length() != 0) {
			condition.append("and f.f_name like '%" + timing.getF_name() + "%'");
		}
		if (timing.getMh_id() != null && !timing.getMh_id().trim().equals("0")) {
			condition.append("and t.mh_id = '" + timing.getMh_id() + "'");
 		}
		return condition.toString();
	}

	/**
	 * 
	 * @param id
	 *            电影院id
	 * @param sum
	 *            增加数量
	 */
	public void updateCinemaCnum(int id, int sum) {
		DbHelper.executeSQL("update cinema set c_num=c_num+? where c_id=?", sum, id);
	}

	/**
	 * 获取放映单数量
	 * 
	 * @return
	 */
	public int getTimingCount() {
		return DbHelper.getScalar("select count(*) from timing", long.class).intValue();
	}

	public Cinema getCinemaC_ic(int id) {
		return DbHelper.getSingle("select c_id from cinema c,movie_user m where c.mov_id=m.mov_id and m.mov_id=?",
				Cinema.class, id);
	}

}
