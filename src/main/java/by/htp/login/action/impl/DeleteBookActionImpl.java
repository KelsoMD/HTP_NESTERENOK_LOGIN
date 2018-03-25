package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Book;
import by.htp.login.beans.User;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.BookServiceImpl;

public class DeleteBookActionImpl implements BaseAction{
	
	private BookService bs = new BookServiceImpl();


	@Override
	public String act(HttpServletRequest request){
		User user = ActionHelper.getInstance().validateAdmin(request);
		if(user!=null) {
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		bs.deleteBook(bookId);
		request.setAttribute("bookadded", "Book deleted sucsessfully!");
		if (request.getParameter("search") != null
				&& request.getParameter("search").equals(REQUEST_PARAM_SEARCH_BOOK)) {
			List<Book> list = bs.readByTitle(request.getParameter("prevTitle"));
			request.setAttribute("list", list);
			return PAGE_ADMIN_BOOK_VIEW;
		} else if (request.getParameter("search") != null
				&& request.getParameter("search").equals(REQUEST_PARAM_SEARCH_AUTHOR)) {
			List<Book> list = bs.readByAuthor(request.getParameter("prevAuthor"));
			request.setAttribute("list", list);
			return PAGE_ADMIN_BOOK_VIEW_AUTHOR;
		} else {
			return PAGE_ERROR;
		}
	} else {
	}
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}	
