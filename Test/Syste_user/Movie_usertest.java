package Syste_user;

import org.junit.Test;

import com.mb2217.dao.System_userDAO;
import com.mb2217.entity.Movie_User;

public class Movie_usertest {

	@Test
	public void addMovie_user(){
		Movie_User mu = new Movie_User();
		mu.setMov_name("1606031120");
		mu.setMov_password("123456");
		System_userDAO su = new System_userDAO();
		su.addMh_user(mu);
	}
	
	@Test
	public void delMovie_user(){
		System_userDAO su = new System_userDAO();
		su.delMh_user(4);
	}
	@Test
	public void updateMovie_user(){
		Movie_User mu = new Movie_User();
		mu.setMov_name("1606031117");
		mu.setMov_password("123456");
		mu.setMov_id(1);
		System_userDAO su = new System_userDAO();
		su.updateMh_user(mu);
	}
	@Test
	public void getMovie_userById(){
		System_userDAO su = new System_userDAO();
		System.out.println(su.getMh_userById(3));
	}
	@Test
	public void getMovie_users(){
		System_userDAO su = new System_userDAO();
		su.getMovie_Users().forEach(s->System.out.println(s));
	}
	@Test
	public void getMovie_userByPage(){
		System_userDAO su = new System_userDAO();
		su.getMh_usersByPage(1, 2).forEach(s->System.out.println(s));
	}
}
