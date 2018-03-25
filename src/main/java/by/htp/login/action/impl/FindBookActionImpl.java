package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ADMIN_BOOK_VIEW;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_USER;

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

public class FindBookActionImpl implements BaseAction{
	
	BookService bs = new BookServiceImpl();
	
	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		User user = ActionHelper.getInstance().validateAccount(request);
		if (user!=null && user.getRole()==0) {
		String title = request.getParameter("title");
		List<Book> list = bs.readByTitle(title);
		request.setAttribute("prevTitle", title);
		request.setAttribute("list", list);
		return PAGE_USER;
		} else if(user != null && user.getRole() == 1){
			String title = request.getParameter("title");
			List<Book> list = bs.readByTitleAdmin(title);
			request.setAttribute("list", list);
			request.setAttribute("prevTitle", title);
			return PAGE_ADMIN_BOOK_VIEW;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
