package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Author;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.impl.AuthorServiceImpl;

public class CreateAuthorActionImpl implements BaseAction{
	
	AuthorService as = new AuthorServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		User user = ActionHelper.getInstance().validateAdmin(request);
		if (user!=null && user.getRole()==1	) {
		String name = request.getParameter("name");
		String surName = request.getParameter("surname");
		String strDate = request.getParameter("calendar");
		Date birthDate = java.sql.Date.valueOf(strDate);
		as.createAuthor(name, surName, birthDate);
		List<Author> list = as.buildAuthors();
		request.setAttribute("list", list);
		HttpSession session = request.getSession(true); 
		session.setAttribute("prevAction", "create_author");
		return PAGE_SUCSESS_RD;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
