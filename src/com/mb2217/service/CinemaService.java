package com.mb2217.service;

import java.util.List;

import com.mb2217.dao.System_userDAO;
import com.mb2217.entity.Area;
import com.mb2217.entity.Cinema;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.PageBean;


public class CinemaService {
	public void addCinema(Cinema cinema) {
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.addCinema(cinema);
	}

	public PageBean<Cinema> getCinemasByPage(int page) {
		int pageSize = 5;
		PageBean<Cinema> pageBean = new PageBean<Cinema>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);

		System_userDAO system_userDAO = new System_userDAO();
		List<Cinema> data = system_userDAO.getCinemaByPage(page, pageSize);
		pageBean.setData(data);
		int totalNum = system_userDAO.getCinemaCount();
		pageBean.setTotalNum(totalNum);

		pageBean.setActualSize(data.size());
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);

		return pageBean;

	}
	
	public PageBean<Cinema> getCinemasSearchByPage(int page,Cinema cinema) {
		
		
		int pageSize = 5;
		PageBean<Cinema> pageBean = new PageBean<Cinema>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);

		System_userDAO system_userDAO = new System_userDAO();
		List<Cinema> data = system_userDAO.getCinemaSearchByPage(page, pageSize,cinema);
		pageBean.setData(data);
		int totalNum = system_userDAO.getCinemaCount();
		pageBean.setTotalNum(totalNum);

		pageBean.setActualSize(data.size());
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}

	public Cinema getCinemaById(int id) {
		System_userDAO system_userDAO = new System_userDAO();
		return system_userDAO.getCinemaById(id);
	}

	public void updateCinema(Cinema cinema) {
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.updateCinema(cinema);

	}

	public void delCinema(int id) {
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.delCinema(id);
	}

	

	public List<Area> getAreas() {
		System_userDAO system_userDAO = new System_userDAO();
		return system_userDAO.getAreas();
	}
	public List<Movie_User> getMovie_Users() {
		System_userDAO system_userDAO = new System_userDAO();
		return system_userDAO.getMovie_Users();
	}

	


}
