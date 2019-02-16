package com.mb2217.service;


import java.util.List;

import com.mb2217.dao.System_userDAO;
import com.mb2217.entity.Movie_User;
import com.mb2217.entity.PageBean;

public class Mh_userService {

	public Movie_User getMh_userById(int id) {
		System_userDAO system_userDAO = new System_userDAO();
		return system_userDAO.getMh_userById(id);
	}

	public void addMh_user(Movie_User mh_user) {
		System_userDAO system_userDAO = new System_userDAO();
	    system_userDAO.addMh_user(mh_user);
	}

	public static void delMh_user(int id) {
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.delMh_user(id);
	}

	public static void updateMh_user(Movie_User mh_user) {
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.updateMh_user(mh_user);
	}

	public PageBean<Movie_User> getMh_usersByPage(int page) {
		int pageSize = 5;
		PageBean<Movie_User> pageBean = new PageBean<Movie_User>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);

		System_userDAO system_userDAO = new System_userDAO();
		List<Movie_User> data = system_userDAO.getMh_usersByPage(page, pageSize);
		pageBean.setData(data);
		int totalNum = system_userDAO.getMh_userCount();
		pageBean.setTotalNum(totalNum);

		pageBean.setActualSize(data.size());
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);

		return pageBean;
	}

	public List<Movie_User> getMovie_Users() {
		System_userDAO system_userDAO = new System_userDAO();
		return system_userDAO.getMovie_Users();
	}

}
