package by.htp.login.action.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Author;
import by.htp.login.beans.Book;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.database.AuthorDaoimpl;
import by.htp.login.dao.database.BookDaoMySqlImpl;

public class EditBookActionImpl implements BaseAction{
	private BookDao bookDao = new BookDaoMySqlImpl();
	private AuthorDao authorDao = new AuthorDaoimpl();
	@Override
	public String act(HttpServletRequest request) throws IOException, NumberFormatException, ParseException {
		
		Book book = bookDao.read(Integer.parseInt(request.getParameter("book_id")));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/editbookadmin.jsp");
		List<Author> list = authorDao.readAll();
		request.setAttribute("selectedAuthor", book.getAuthor());
		request.setAttribute("authors", list);
		request.setAttribute("bookid", book.getId());
		request.setAttribute("title", book.getTitle());
		request.setAttribute("publish_year", book.getPublishDate());
		return "/editbookadmin.jsp";
	}
	
	

}
