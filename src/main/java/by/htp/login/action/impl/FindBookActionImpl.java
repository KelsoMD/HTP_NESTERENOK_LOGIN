package by.htp.login.action.impl;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Book;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.database.BookDaoMySqlImpl;

public class FindBookActionImpl implements BaseAction{
	BookDao dao = new BookDaoMySqlImpl();
	@Override
	public String act(HttpServletRequest request) throws IOException, NumberFormatException, ParseException {
		String title = request.getParameter("title");
		Book book = dao.read(title);
		request.setAttribute("book", book);
		
		return "\\second.jsp";
	}

}
