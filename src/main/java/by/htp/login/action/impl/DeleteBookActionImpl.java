package by.htp.login.action.impl;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.database.BookDaoMySqlImpl;

public class DeleteBookActionImpl implements BaseAction{
	
	
private BookDao dao = new BookDaoMySqlImpl();


	@Override
	public String act(HttpServletRequest request) throws IOException, NumberFormatException, ParseException {
		
		dao.delete(Integer.parseInt(request.getParameter("book_id")));
		request.setAttribute("bookadded", "Book deleted sucsessfully!");
		return "/secondadmin.jsp";
	}
	
	

}
