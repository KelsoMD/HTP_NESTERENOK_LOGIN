package by.htp.login.action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Author;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.UserDao;
import by.htp.login.dao.database.AuthorDaoimpl;
import by.htp.login.dao.database.UserDaoImpl;

public class CheckLoginActionimpl implements BaseAction {

	private UserDao dao = new UserDaoImpl();
	private AuthorDao dao1 = new AuthorDaoimpl();

	@Override
	public String act(HttpServletRequest request) {
		String page = "";
		if (dao.checkLogin(request.getParameter("login"))) {
			int result = dao.checkPassword(request.getParameter("login"), request.getParameter("password"));
			if (result == 0) {
				page = "/second.jsp";
			}
			if (result == 1) {
				List<Author> authors = dao1.readAll();
				request.setAttribute("authors", authors);
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
