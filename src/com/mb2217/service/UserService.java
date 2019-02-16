package com.mb2217.service;

import java.util.List;


import com.mb2217.dao.UserDao;
import com.mb2217.entity.User;


public class UserService {

		public void addUser(User user) {
			UserDao userDAO = new UserDao();
			if (UserDao.isExist(user.getU_username())) {
				return;
			}
			userDAO.addUser(user);
		}

		public void deleteUser(int id){
			  UserDao UserDao=new UserDao();
					UserDao.deleteUser(id);;
				}
				public void updateUser(User user){
					UserDao UserDao=new UserDao();
					UserDao.updateUser(user);
				}
				public User getUser(String u_username,String u_password){
					UserDao UserDao=new UserDao();
					User user=UserDao.getUserById(u_username,u_password);
					return user;
				}
				public List<User> getUsers(){
					return new UserDao().getUserAll();
				}
				public void updateArtar(int u_id, String u_avatar) {
					UserDao userDAO = new UserDao();
					userDAO.updateArtar(u_id,u_avatar);
				}
	

}
