package by.htp.login.action.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Author;
import by.htp.login.beans.Book;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.database.AuthorDaoimpl;
import by.htp.login.dao.database.BookDaoMySqlImpl;

public class SaveBookActionImpl implements BaseAction{
	
	private BookDao bookDao = new BookDaoMySqlImpl();
	private AuthorDao authorDao = new AuthorDaoimpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, NumberFormatException, ParseException {
		
		Book book = bookDao.read(Integer.parseInt(request.getParameter("book_id")));
		book.setTitle(request.getParameter("title"));
		Author author = null;
		author = authorDao.read(Integer.parseInt(request.getParameter("authors")));
		book.setAuthor(author);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.parse(request.getParameter("calendar")));
		Date date = dateFormat.parse(request.getParameter("calendar"));
		book.setPublishDate(date);
		bookDao.update(book);
		System.out.println("updated");
		
		return "/secondadmin.jsp";
	}

}
