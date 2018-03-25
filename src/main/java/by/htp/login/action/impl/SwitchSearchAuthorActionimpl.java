package by.htp.login.action.impl;
import static by.htp.login.action.util.ManagerConstantPool.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Book;
import by.htp.login.beans.User;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.BookServiceImpl;

public class SwitchSearchAuthorActionimpl implements BaseAction{
	
	BookService bs = new BookServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		
		User user = ActionHelper.getInstance().validateAccount(request);
		if (user!=null && user.getRole()==0) {
			List<Book> list = bs.readBooks();
			request.setAttribute("list", list);
			return PAGE_USER_AUTHOR;
		} else if(user!=null && user.getRole()==1){
			List<Book> list = bs.readBooksAdmin();
			request.setAttribute("list", list);
			return PAGE_ADMIN_BOOK_VIEW_AUTHOR;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
