package com.mb2217.service;

import com.mb2217.dao.System_userDAO;
import com.mb2217.entity.System_user;

public class System_userService {

	public System_user login(String name,String password) {
		System_userDAO system_userDAO=new System_userDAO();
		return system_userDAO.getSystem_userByNameAndPwd(name, password);
		
	} 
}
