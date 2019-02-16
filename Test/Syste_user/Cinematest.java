package Syste_user;

import org.junit.Test;

import com.mb2217.dao.System_userDAO;
import com.mb2217.entity.Cinema;

public class Cinematest {

	@Test
	public void addCinema(){
		Cinema c = new Cinema();
		c.setC_name("万达影院");
		c.setC_num(10);
		c.setC_tel("13530309972");
		c.setC_adr("成都工业学院2219");
		c.setA_id(7);
		c.setMov_id(5);
		System_userDAO su = new System_userDAO();
		su.addCinema(c);
		
	}
	@Test
	public void delCinema(){
		System_userDAO su = new System_userDAO();
		su.delCinema(5);
	}
	@Test
	public void updateCinema(){
		Cinema c = new Cinema();
		c.setC_name("万达影院1");
		c.setC_num(10);
		c.setC_tel("13530309972");
		c.setC_adr("成都工业学院2219");
		c.setA_id(7);
		c.setMov_id(5);
		c.setC_id(6);
		System_userDAO su = new System_userDAO();
		su.updateCinema(c);
	}
	@Test
	public void getCinemaById(){
		System_userDAO su = new System_userDAO();
		System.out.println(su.getCinemaById(4));
	}
	@Test 
	public void getCinemaByPage(){
		System_userDAO su = new System_userDAO();
		su.getCinemaByPage(1, 2).forEach(s->System.out.println(s));
	}
	
	
}
