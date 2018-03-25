package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_SUCSESS_RD;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Author;
import by.htp.login.beans.Book;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;

public class SaveBookActionImpl implements BaseAction {

	BookService bs = new BookServiceImpl();
	AuthorService as = new AuthorServiceImpl();

	@Override
	public String act(HttpServletRequest request) {
		
		User user = ActionHelper.getInstance().validateAdmin(request);
		if(user!=null) {

		Book book = bs.buildBook(Integer.parseInt(request.getParameter("book_id")));
		book.setTitle(request.getParameter("title"));
		Author author = null;
		author = as.buildAuthor(Integer.parseInt(request.getParameter("authors")));
		book.setAuthor(author);
		Date date = java.sql.Date.valueOf(request.getParameter("calendar"));
		book.setPublishDate(date);
		bs.updateBook(book);
		HttpSession session = request.getSession();
		session.setAttribute("prevAction", "update_book");
		return PAGE_SUCSESS_RD;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
