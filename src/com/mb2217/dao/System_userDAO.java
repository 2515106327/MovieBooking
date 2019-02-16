package com.mb2217.dao;

import java.util.List;

import com.mb2217.entity.Area;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.System_user;

public class System_userDAO {
	public System_user getSystem_userByNameAndPwd(String sys_username, String sys_password) {
		return DbHelper.getSystem_userSingle("select * from system_user where sys_username=? and sys_password=?",
				System_user.class, sys_username, sys_password);
	}

	// Area 数据库链接开始
	public void addArea(Area area) {

		DbHelper.executeSQL("insert into area(a_name) values(?)", area.getA_name());
	}

	public Area getAreaById(int id) {
		return DbHelper.getSingle("select * from area where a_id=?", Area.class, id);
	}

	public void updateArea(Area area) {
		String sql = "update area set a_name=? where a_id=?";
		DbHelper.executeSQL(sql, area.getA_name(), area.getA_id());

	}

	public void delArea(int id) {
		String sql = "delete from area where a_id=?";
		DbHelper.executeSQL(sql, id);

	}

	public List<Area> getAreasByPage(int page, int pageSize) {
		String sql = "select * from area limit ?,?";
		return DbHelper.getResults(sql, Area.class, (page - 1) * pageSize, pageSize);
	}

	public int getAreaCount() {
		return DbHelper.getScalar("select count(*) from area", long.class).intValue();
	}

	public List<Area> getAreas() {
		return DbHelper.getResults("select a_id,a_name from area", Area.class);
	}
	// Area 数据库链接结束

	// Movie_user 数据可链接开始
	public void addMh_user(Movie_User mh_user) {
		DbHelper.executeSQL("insert into movie_user(mov_name,mov_password) values(?,?)", mh_user.getMov_name(),
				mh_user.getMov_password());
	}

	public Movie_User getMh_userById(int id) {
		return DbHelper.getSingle("select * from movie_user where mov_id=? ", Movie_User.class, id);
	}

	public void updateMh_user(Movie_User mh_user) {
		String sql = "update movie_user set mov_name=? ,mov_password=? where mov_id=?";
		DbHelper.executeSQL(sql, mh_user.getMov_name(), mh_user.getMov_password(), mh_user.getMov_id());

	}

	public void delMh_user(int id) {
		String sql = "delete from movie_user where mov_id=?";
		DbHelper.executeSQL(sql, id);

	}

	public List<Movie_User> getMh_usersByPage(int page, int pageSize) {
		String sql = "select * from movie_user limit ?,? ";
		return DbHelper.getResults(sql, Movie_User.class, (page - 1) * pageSize, pageSize);
	}

	public int getMh_userCount() {
		return DbHelper.getScalar("select count(*) from movie_user", long.class).intValue();
	}

	public List<Movie_User> getMovie_Users() {
		return DbHelper.getResults("select mov_id,mov_name,mov_password from movie_user", Movie_User.class);
	}
	// Movie_user 数据可链接结束

	// Cinema 数据库链接开始
	public void delCinema(int id) {
		String sql = "delete from cinema where c_id=?";
		DbHelper.executeSQL(sql, id);

	}

	public void addCinema(Cinema cinema) {
		DbHelper.executeSQL("insert into cinema(c_name,c_num,c_tel,c_adr,a_id,mov_id) values(?,?,?,?,?,?)",
				cinema.getC_name(), cinema.getC_num(), cinema.getC_tel(), cinema.getC_adr(), cinema.getA_id(),
				cinema.getMov_id());

	}

	public int getCinemaCount() {
		return DbHelper.getScalar("select count(*) from cinema", long.class).intValue();
	}

	public Cinema getCinemaById(int id) {
		return DbHelper.getSingle(
				"select cinema.*,area.a_name,movie_user.mov_name from cinema,area,movie_user where area.a_id=cinema.a_id and cinema.mov_id=movie_user.mov_id  and c_id=? ",
				Cinema.class, id);
	}

	public void updateCinema(Cinema cinema) {
		String sql = "update cinema set c_name=?,c_num=?,c_tel=?,c_adr=?,a_id=?,mov_id=? where c_id=?";
		DbHelper.executeSQL(sql, cinema.getC_name(), cinema.getC_num(), cinema.getC_tel(), cinema.getC_adr(),
				cinema.getA_id(), cinema.getMov_id(), cinema.getC_id());
	}

	public List<Cinema> getCinemaByPage(int page, int pageSize) {
		String sql = "select cinema.*,area.a_name,movie_user.mov_name from cinema,area,movie_user where area.a_id=cinema.a_id and cinema.mov_id=movie_user.mov_id limit ?,?";
		return DbHelper.getResults(sql, Cinema.class, (page - 1) * pageSize, pageSize);
	}

	public List<Cinema> getCinemaSearchByPage(int page, int pageSize, Cinema cinema) {
		String sql = "select cinema.*,area.a_name,movie_user.mov_name from cinema,area,movie_user where area.a_id=cinema.a_id and cinema.mov_id=movie_user.mov_id "
				+ CinemaSearchJudge(cinema) + " limit ?,?";
		return DbHelper.getResults(sql, Cinema.class, (page - 1) * pageSize, pageSize);
	}

	public String CinemaSearchJudge(Cinema cinema) {
		String c_name = cinema.getC_name().trim();
		int a_id = cinema.getA_id();
		String str = "";
		if (c_name != null && a_id != -1) {
			str =str+"and c_name like '%" + c_name + "%' and cinema.a_id='" + a_id + "'";
		}else if(c_name != null && a_id == -1){
			str =str+"and c_name like '%" + c_name + "%' ";
		}else if(c_name == null && a_id != -1){
			str =str+"and cinema.a_id='" + a_id + "'";
		}
		return str;
	}

	// Cinema 数据库链接结束

}
