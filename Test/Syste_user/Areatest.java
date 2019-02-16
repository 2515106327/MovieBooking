package Syste_user;

import org.junit.Test;

import com.mb2217.dao.System_userDAO;
import com.mb2217.entity.Area;

public class Areatest {

	@Test
	public void addArea(){
		Area area = new Area();
		area.setA_name("金牛区");
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.addArea(area);
	}
	@Test
	public void delArea(){
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.delArea(1);
	}
	
	@Test
	public void upAreaData(){
		Area area = new Area();
		area.setA_id(2);
		area.setA_name("sdfsf");
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.updateArea(area);
	}
	@Test
	public void getAreaById(){
		System_userDAO system_userDAO = new System_userDAO();
		 Area area=system_userDAO.getAreaById(1);
		System.out.println("DFGHDgh"+area);
	}
	
	@Test
	public void getAreaCount(){
		System_userDAO system_userDAO = new System_userDAO();
		System.out.println(system_userDAO.getAreaCount());
	}
	@Test
	public void getAreas(){
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.getAreas().forEach(s->System.out.println(s));
	}
	@Test
	public void getAreasByPage(){
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.getAreasByPage(1, 2).forEach(k->System.out.println(k));
	}
	@Test
	public void test(){
		System.out.println(-1>>>1);
	}
}
