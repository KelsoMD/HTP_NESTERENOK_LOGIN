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

public class ViewBookListActionImpl implements BaseAction {
	
	BookService bs = new BookServiceImpl();

	@Override
	public String act(HttpServletRequest request){
		User user = ActionHelper.getInstance().validateAccount(request);
		if (user!=null && user.getRole()==1) {
		List<Book> books = bs.readBooksAdmin();
			request.setAttribute("list", books);
		return PAGE_ADMIN_BOOK_VIEW;
		} else if(user!=null && user.getRole()==0){
			List<Book> books = bs.readBooks();
			request.setAttribute("list", books);
			return PAGE_USER;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}
}
