package com.mb2217.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.mb2217.entity.User;



public class UserDao {
	public void addUser(User user){
		String sql="insert into User(u_id,u_username,u_password,u_sex) values(?,?,?,?)";
		DbHelper.executeSQL(sql,user.getU_id(),user.getU_username(),user.getU_password(),user.getU_sex());
	
		
	}
	public void updateUser(User user){
		String sql="update User set u_username=?,u_password=? where u_id=?";
		DbHelper.executeSQL(sql,user.getU_username(),user.getU_password(),user.getU_id());
		
	}
	public void deleteUser(int id){
		String sql="delete from User where u_id=?";
		DbHelper.executeSQL(sql,id);
	}
	public User getUserById(String u_username,String u_password) {
		String sql = "select * from user where u_username=? and u_password=?";
		User user=DbHelper.getSingle(sql, User.class,u_username,u_password);
		return user;
	}
	public List<User> getUserAll(){
		List<User> users = new ArrayList<User>();
		String sql = "select * from User";
		users=DbHelper.getResults(sql, User.class);
		return users;
	
	}
	public void updateArtar(int u_id, String u_avatar) {
		// TODO Auto-generated method stub
		DbHelper.executeSQL("update User set u_avatar=? where u_id=?", u_avatar, u_id);
		
	}
	public static boolean isExist(String u_username) {
		String sql = "select count(*) from user where u_username='" + u_username + "'";
		Connection conn = DbHelper.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getInt(1) != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
