package by.htp.login.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.dao.UserDao;
import by.htp.login.dao.database.UserDaoImpl;

public class CheckLoginActionimpl implements BaseAction {

	private UserDao dao = new UserDaoImpl();

	@Override
	public String act(HttpServletRequest request) {
		String page = "";
		if (dao.checkLogin(request.getParameter("login"))) {
			int result = dao.checkPassword(request.getParameter("login"), request.getParameter("password"));
			if (result == 0) {
				page = "/second.jsp";
			}
			if (result == 1) {
				page = "/secondadmin.jsp";
			}
			if (result == 3) {
				request.setAttribute("errorLogin", "Incorrect password");
				page = "/login.jsp";
			}
		} else {
			request.setAttribute("errorLogin", "Incorrect login");
			page = "/login.jsp";
		}
		return page;
	}
}
