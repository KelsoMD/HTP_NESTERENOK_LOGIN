package by.htp.login.action.impl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Book;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.database.BookDaoMySqlImpl;

public class ViewBookListActionImpl implements BaseAction {
	private BookDao dao = new BookDaoMySqlImpl();

	@Override
	public String act(HttpServletRequest request) throws NumberFormatException, IOException, ParseException {
		
		List<Book> books = dao.readAll();
			request.setAttribute("list", books);
		return "/secondadmin.jsp";
	}

}
