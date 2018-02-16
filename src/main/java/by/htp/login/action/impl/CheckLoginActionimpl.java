package by.htp.login.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.dao.UserDao;
import by.htp.login.dao.database.UserDaoImpl;

public class CheckLoginActionimpl implements BaseAction {

	private UserDao dao = new UserDaoImpl();

	@Override
	public String act(HttpServletRequest request) {
		String page ="";

		if (dao.checkLogin(request.getParameter("login"))) {
			
			if (dao.checkPassword(request.getParameter("login"), request.getParameter("password"))) {
				page = "sucsess";
			} else {
				page = "Incorrect password";
			}
		} else {
			page = "Incorrect login";
		}
		return page;
	}

}
