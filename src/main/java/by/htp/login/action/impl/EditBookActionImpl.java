package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_EDITBOOK;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Author;
import by.htp.login.beans.Book;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;

public class EditBookActionImpl implements BaseAction{
	BookService bs = new BookServiceImpl();
	AuthorService as = new AuthorServiceImpl();
	@Override
	public String act(HttpServletRequest request){
		
		User user = ActionHelper.getInstance().validateAdmin(request);
		if (user!=null) {
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		request.setAttribute("user", user);
		List<Author> list = as.buildAuthors();
		Book book = bs.buildBook(bookId);
		request.setAttribute("selectedAuthor", book.getAuthor());
		request.setAttribute("authorz", list);
		request.setAttribute("bookid", book.getId());
		request.setAttribute("title", book.getTitle());
		request.setAttribute("publish_year", book.getPublishDate());
		
		return PAGE_EDITBOOK;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}
	
	

}
