package by.htp.login.action.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.beans.User;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.UserServiceImpl;

public final class ActionHelper {

private static final String NAME_REG = "[a-яA-Я]+";
private static final String LOG_AND_PASS_REG = "[a-яA-Я]+\\d+";
private static final String NAME_MSG = "Ну буквы без пробелов!";

	UserService us = new UserServiceImpl();
	
	private static final ActionHelper instance = new ActionHelper();
	
	public static ActionHelper getInstance() {
		return instance;
	}

	public User validateAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		if (user!=null && user.getRole()==1) {
			return user;
		} else {
			return null;
		}
	}
	
	public User validateUser(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		if (user!=null && user.getRole()==0) {
			return user;
		} else {
			return null;
		}
	}

	public User validateAccount(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		return (User) session.getAttribute("user");
		
	}
	
	public boolean regValidation(HttpServletRequest req) {
		boolean flag= true;
		String pass = req.getParameter("password").trim();
		String name = req.getParameter("name").trim();
		String lastname = req.getParameter("lastname").trim();
		String surname = req.getParameter("surname").trim();
		String eMail = req.getParameter("e_mail").trim();
		
		if (!pass.matches(LOG_AND_PASS_REG) && pass.length() < 6) {
			req.setAttribute("pass_msg",
					"Пароль может содержать только буквы и цифры и должен быть не менее 6 символов");
			flag = false;
		}
		if (!name.matches(NAME_REG)) {
			req.setAttribute("name_msg", NAME_MSG);
			flag = false;
		}
		if (!lastname.matches(NAME_REG)) {
			req.setAttribute("lastname_msg", NAME_MSG);
			flag = false;
		}
		if (!surname.matches(NAME_REG)) {
			req.setAttribute("surname_msg", NAME_MSG);
			flag = false;
		}
		if (!eMail.contains("@")) {
			req.setAttribute("eMail_msg", "Я мало понимаю в почтовых адресах, но там должна быть собака");
			flag = false;
		}
		return flag;
	}
	
}
