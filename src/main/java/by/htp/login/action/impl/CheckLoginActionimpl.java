package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.PAGE_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_SUCSESS_RD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.OrderService;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;
import by.htp.login.service.impl.OrderServiceImpl;
import by.htp.login.service.impl.UserServiceImpl;

public class CheckLoginActionimpl implements BaseAction {

	UserService us = new UserServiceImpl();
	AuthorService as = new AuthorServiceImpl();
	BookService bs = new BookServiceImpl();
	OrderService os = new OrderServiceImpl();

	@Override
	public String act(HttpServletRequest request) {

		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession(true);
		
		if (us.checkLogin(login)) {
			User user = us.checkPassword(login, pass);
			if (user != null) {
				session.setAttribute("user", user);
				if (user.getRole() == 1) {
					session.setAttribute("prevAction", "login_admin");
					return PAGE_SUCSESS_RD;
				} else {
					session.setAttribute("prevAction", "login_user");
					return PAGE_SUCSESS_RD;
				}
			} else {
				request.setAttribute("errorLogin", "Incorrect password");
				return PAGE_LOGIN;
			}
		} else {
			request.setAttribute("errorLogin", "Login incorrect or not exist");
			return PAGE_LOGIN;
		}
	}
}
