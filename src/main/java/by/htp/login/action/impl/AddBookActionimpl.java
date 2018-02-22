package by.htp.login.action.impl;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Author;
import by.htp.login.beans.Book;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.database.AuthorDaoimpl;
import by.htp.login.dao.database.BookDaoMySqlImpl;

public class AddBookActionimpl implements BaseAction{
BookDao dao = new BookDaoMySqlImpl();
AuthorDao dao1 = new AuthorDaoimpl();
	@Override
	public String act(HttpServletRequest request) throws IOException, NumberFormatException, ParseException {
		
		Book book = new Book();
		Author author = new Author();
		request.getAttribute("value");
		System.out.println(request.getParameter("authors"));
		author.setId(Integer.parseInt(request.getParameter("authors")));
		book.setAuthor(author);
		book.setTitle(request.getParameter("title"));
		dao.create(book);
		request.setAttribute("bookadded", "Book added sucsessfully!");
		return "/secondadmin.jsp";
	}

}
