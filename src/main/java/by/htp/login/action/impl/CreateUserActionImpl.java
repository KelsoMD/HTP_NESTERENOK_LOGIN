package by.htp.login.action.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.User;
import by.htp.login.controller.RegistrationException;
import by.htp.login.dao.UserDao;
import by.htp.login.dao.database.UserDaoImpl;

public class CreateUserActionImpl implements BaseAction{
	private UserDao dao = new UserDaoImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException {
		User user = new User(request.getParameter("login"), request.getParameter("password"));
		if (dao.checkLogin(request.getParameter("login"))) {
			return "false";
		} else {
		dao.create(user);
		}
		return "true";
	}

}
