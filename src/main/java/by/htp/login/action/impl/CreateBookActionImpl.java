package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_SUCSESS_RD;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.User;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.BookServiceImpl;

public class CreateBookActionImpl implements BaseAction{
	
	BookService bs = new BookServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		
		User user = ActionHelper.getInstance().validateAdmin(request);
		if(user!=null && user.getRole()==1) {
		int authorId = Integer.parseInt(request.getParameter("authors"));
		String title = (request.getParameter("title"));
		String strDate = request.getParameter("calendar");
		Date publishYear = java.sql.Date.valueOf(strDate);
		bs.createBook(title, authorId, publishYear);
		HttpSession session = request.getSession(true); 
		session.setAttribute("prevAction", "create_book");
		return PAGE_SUCSESS_RD;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
