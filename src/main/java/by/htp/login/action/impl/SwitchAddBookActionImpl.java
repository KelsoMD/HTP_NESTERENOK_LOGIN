package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ADD_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Author;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;

public class SwitchAddBookActionImpl implements BaseAction{
	
AuthorService as = new AuthorServiceImpl();
BookService bs = new BookServiceImpl();

	@Override
	public String act(HttpServletRequest request){
		
		User user = ActionHelper.getInstance().validateAdmin(request);
		if (user!=null && user.getRole()==1) {
		List<Author> authors = as.buildAuthors();
		request.setAttribute("authors", authors);
		return PAGE_ADD_BOOK;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
