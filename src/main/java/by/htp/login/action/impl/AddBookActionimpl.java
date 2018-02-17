package by.htp.login.action.impl;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Author;
import by.htp.login.beans.Book;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.database.BookDaoMySqlImpl;

public class AddBookActionimpl implements BaseAction{
BookDao dao = new BookDaoMySqlImpl();
	@Override
	public String act(HttpServletRequest request) throws IOException, NumberFormatException, ParseException {
		
		Book book = new Book();
		Author author = new Author();
		author.setId(Integer.parseInt(request.getParameter("authorid")));
		book.setAuthor(author);
		book.setTitle(request.getParameter("title"));
		dao.create(book);
		request.setAttribute("bookadded", "Book added sucsessfully!");
		return "/secondadmin.jsp";
	}

}
