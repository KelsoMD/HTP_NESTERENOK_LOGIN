package by.htp.login.action.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Author;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.database.AuthorDaoimpl;

public class ViewAuhtorsActionImpl implements BaseAction{
	
	AuthorDao dao = new AuthorDaoimpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, NumberFormatException, ParseException {
		List<Author> list = dao.readAll();
		request.setAttribute("list", list);
		return "/secondadmin.jsp";
	}
	

}
