package by.htp.login.action.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.beans.User;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.UserServiceImpl;

public final class ActionHelper {

private static final String NAME_REG = "[a-�A-�]+";
private static final String LOG_AND_PASS_REG = "[a-�A-�]+\\d+";
private static final String NAME_MSG = "�� ����� ��� ��������!";

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
					"������ ����� ��������� ������ ����� � ����� � ������ ���� �� ����� 6 ��������");
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
			req.setAttribute("eMail_msg", "� ���� ������� � �������� �������, �� ��� ������ ���� ������");
			flag = false;
		}
		return flag;
	}
	
}
