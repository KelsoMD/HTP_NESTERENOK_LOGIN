package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.PAGE_REGISTER;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_SUCSESS_RD;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.User;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.UserServiceImpl;

public class CreateUserActionImpl implements BaseAction {
	private UserService us = new UserServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException {

		if (us.checkLogin(request.getParameter("login"))) {
			request.setAttribute("login_msg", "Логин занят");
			return PAGE_REGISTER;
		} else {
			String login = request.getParameter("login");
			String pass = request.getParameter("password");
			User user = new User(login, pass);
			us.createUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("prevAction", "create_user");
			return PAGE_SUCSESS_RD;
		}
	}

}
