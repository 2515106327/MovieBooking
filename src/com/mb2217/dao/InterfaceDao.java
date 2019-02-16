package com.mb2217.dao;

import java.util.ArrayList;
import java.util.List;
import com.mb2217.entity.Area;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Film;
import com.mb2217.entity.Movie_Hall;
import com.mb2217.entity.Seat;
import com.mb2217.entity.Timing;
import com.mb2217.entity.User;
import com.mb2217.entity.Booking;

public class InterfaceDao {
	public List<Film> getTimingfilmAll(int page,int pageSize,Film film){//查询电影
		List<Film>  movies= new ArrayList<Film>();
		String sql = "select distinct film.* from film,timing where film.f_id=timing.f_id "+ createCondition(film)+ "limit ?,?";
		movies=DbHelper.getResults(sql, Film.class,(page - 1) * pageSize, pageSize);
		return movies;
}
	public Film getFilmById(int f_id) {//查询单个电影
		String sql = "select film.*  from film  where film.f_id=?";
		Film film=DbHelper.getSingle(sql,Film.class,f_id);
		return film;
	}
	public Cinema getCinemaById(int c_id) {//查询单个电影院
		String sql = "select cinema.*  from cinema  where cinema.c_id=?";
		Cinema cinema=DbHelper.getSingle(sql,Cinema.class,c_id);
		return cinema;
	}
private String createCondition(Film film) {
	StringBuffer condition = new StringBuffer();
	if (film.getF_language()!= null && !film.getF_language().trim().equals("0")) {
		condition.append(" and film.f_language='"+film.getF_language() +"'");
	}
	if (film.getF_type()!= null && film.getF_type().trim().length() != 0) {
		condition.append(" and  film.f_type like'%" + film.getF_type() + "%'");
	}
	return condition.toString();
}

 public List<Area> getAreaAll(){//查询地区
	 List<Area>  areas= new ArrayList<Area>();
		String sql = "select area.* from area ";
		areas=DbHelper.getResults(sql, Area.class);
		return areas;
}
 public List<Cinema> getCinemas(){//查询影院
	 List<Cinema>  cinemas= new ArrayList<Cinema>();
		String sql = "select distinct cinema.c_name from cinema ";
		cinemas=DbHelper.getResults(sql, Cinema.class);
		return cinemas;
}

 public List<Cinema> getCinema(int page ,int pageSize,Cinema cinema){//按条件查询影院
	 List<Cinema>  cinemas= new ArrayList<Cinema>();
		String sql = "select  cinema.* from cinema where  1=1 " + createConditioncinema(cinema)+" limit ?,?";
		System.out.println(sql);
		cinemas=DbHelper.getResults(sql, Cinema.class,(page - 1) * pageSize, pageSize);
		return cinemas;
}


 private String createConditioncinema(Cinema cinema) {
	 StringBuffer condition = new StringBuffer();

		if (cinema.getA_id()!= 0) {
			condition.append(" and cinema.a_id='"+cinema.getA_id() +"'");
		}
		if (cinema.getC_name()!= null && cinema.getC_name().trim().length()!=0) {
			condition.append(" and cinema.c_name='"+cinema.getC_name() +"'");
		}
		if (cinema.getF_id()!= 0) {
			condition.append(" and cinema.c_id in (select cinema.c_id from cinema,timing,movie_hall where cinema.c_id=movie_hall.c_id and timing.mh_id=movie_hall.mh_id and timing.f_id= "+cinema.getF_id() +")");
		}
		return condition.toString();
}
 public List<Timing> getTiming(int page,int pageSize,int c_id,int f_id){//查询影院放映表
	 List<Timing> timings= new ArrayList<Timing>();
		String sql = "select timing.* from timing,movie_hall where timing.mh_id=movie_hall.mh_id and movie_hall.c_id=? and timing.f_id=?  limit ?,?";
		timings=DbHelper.getResults(sql, Timing.class,c_id,f_id,(page - 1) * pageSize, pageSize);
		return timings;
}

 public List<Film> getCinemaFilm(int c_id){//查询影院电影
	 List<Film> films= new ArrayList<Film>();
		String sql = "select distinct film.* from film,timing,movie_hall where timing.mh_id=movie_hall.mh_id and film.f_id=timing.f_id and movie_hall.c_id=? ";
		films=DbHelper.getResults(sql,Film.class,c_id);
		return films;
}
 public int getFilmCount(Film film){
		return DbHelper.getScalar("select count(*) from film where 1=1"+ createCondition(film), long.class).intValue();
	}
 public int getCinemaCount(Cinema cinema){
		return DbHelper.getScalar("select count(*) from cinema where 1=1 "+createConditioncinema(cinema), long.class).intValue();
	}
 public int getTimingCount(int c_id,int f_id){
	 String sql="select count(*) from timing,movie_hall,film where timing.mh_id=movie_hall.mh_id and movie_hall.c_id=? and film.f_id=?";
		return DbHelper.getScalar(sql,long.class,c_id,f_id).intValue();
	}
 public List<Film> getFilmAll(){
	 List<Film> films= new ArrayList<Film>();
		String sql =  "select distinct film.* from film,timing where film.f_id=timing.f_id  order by  hot desc";
		films=DbHelper.getResults(sql,Film.class);
		return films;
}
 public List<Film> getFilmData(){
	 List<Film> films= new ArrayList<Film>();
		String sql =  "select distinct film.* from film,timing where film.f_id=timing.f_id  order by  f_date desc";
		films=DbHelper.getResults(sql,Film.class);
		return films;
}
 public List<Seat> getseats(String mh_id){
	 List<Seat> seats= new ArrayList<Seat>();
		String sql =  "select distinct seat.* from seat where seat.mh_id=?";
		seats=DbHelper.getResults(sql,Seat.class,mh_id);
		return seats;
}
public void  UpdateSeat(Seat seat){
	String sql =  "update seat set s_op=? where mh_id=? and s_id=?";
	DbHelper.executeSQL(sql, seat.isS_op(),seat.getS_id(),seat.getS_id());
}
public void  Booking(Booking booking){
	String sql =  "insert into booking(b_id,t_id,s_id,u_id,b_date,b_paym) values(?,?,?,?,?,?)";
	DbHelper.executeSQL(sql,booking.getB_id(),booking.getT_id(),booking.getS_id(),booking.getU_id(),booking.getB_date(),booking.getB_paym());
}
public Timing getTiming(int t_id){//获取单个放映表
	String sql="select timing.* from timing where t_id=?";
	return DbHelper.getSingle(sql,Timing.class,t_id);
}
}
