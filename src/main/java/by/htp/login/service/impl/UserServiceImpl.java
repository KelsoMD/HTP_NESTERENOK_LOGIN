package by.htp.login.service.impl;

import java.io.IOException;

import by.htp.login.beans.User;
import by.htp.login.dao.UserDao;
import by.htp.login.dao.database.UserDaoImpl;
import by.htp.login.service.AbonentService;
import by.htp.login.service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao dao = new UserDaoImpl(); 
	AbonentService as = new AbonentServiceImpl();

	@Override
	public User authorizeUser(String login, String password) {
		return dao.readUser(new User(login, password));
	}

	@Override
	public boolean checkLogin(String login) {
		
		return dao.checkLogin(login);
	}

	@Override
	public User checkPassword(String login, String password) {
		User user = dao.checkPassword(login, password);
		if(user!=null && user.getAbonent()!=null) {
		user.setAbonent(as.buildAbonent(user.getAbonent().getId()));
		}
		return user;
	}

	@Override
	public void createUser(User user) {
		try {
			dao.create(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
