package com.mb2217.service;

import java.util.List;


import com.mb2217.dao.System_userDAO;
import com.mb2217.entity.Area;
import com.mb2217.entity.PageBean;




public class AreaService {
	
	public void addArea(Area area) {
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.addArea(area);
	}


	public void delArea(int id) {
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.delArea(id);
	}

	public void updateArea(Area area2) {
		System_userDAO system_userDAO = new System_userDAO();
		system_userDAO.updateArea(area2);
	}

	public Area getAreaById(int id) {
		System_userDAO system_userDAO = new System_userDAO();
		return system_userDAO.getAreaById(id);
	}
	
	
	public PageBean<Area> getAreasByPage(int page) {
		int pageSize = 5;
		PageBean<Area> pageBean = new PageBean<Area>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);

		System_userDAO system_userDAO = new System_userDAO();
		List<Area> data = system_userDAO.getAreasByPage(page, pageSize);
		pageBean.setData(data);
		int totalNum = system_userDAO.getAreaCount();
		pageBean.setTotalNum(totalNum);

		pageBean.setActualSize(data.size());
		int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
		pageBean.setTotalPage(totalPage);

		return pageBean;

	}


	public List<Area> getAreas() {
		System_userDAO system_userDAO = new System_userDAO();
		return system_userDAO.getAreas();
	}

	

	
}
