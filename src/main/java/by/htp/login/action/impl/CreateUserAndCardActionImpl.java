package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_SUCSESS_RD;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.User;
import by.htp.login.service.AbonentService;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.AbonentServiceImpl;
import by.htp.login.service.impl.UserServiceImpl;

public class CreateUserAndCardActionImpl implements BaseAction {
	UserService us = new UserServiceImpl();
	AbonentService as = new AbonentServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {

		if (ActionHelper.getInstance().regValidation(request)) {
			if (us.checkLogin(request.getParameter("login").trim())) {
				request.setAttribute("login_msg", "Логин занят");
				return PAGE_REGISTER;
			} else {
				String login = request.getParameter("login").trim();
				String pass = request.getParameter("password").trim();
				User user = new User(login, pass);

				String name = request.getParameter("name").trim();
				String lastname = request.getParameter("lastname").trim();
				String surname = request.getParameter("surname").trim();
				Date birthDate = java.sql.Date.valueOf(request.getParameter("birth_date"));
				String number = request.getParameter("number").trim();
				String eMail = request.getParameter("e_mail");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date regDate = new Date();
				Date registrationDate = java.sql.Date.valueOf(dateFormat.format(regDate));
				int id = as.createAbonent(name, lastname, surname, birthDate, number, eMail, registrationDate);
				user.setAbonent(as.buildAbonent(id));
				us.createUser(user);
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				session.setAttribute("prevAction", "create_user_and_card");
				return PAGE_SUCSESS_RD;
			}
		} else {
			return PAGE_REGISTER;
		}
	}

}
