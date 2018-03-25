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
import by.htp.login.beans.Author;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.impl.AuthorServiceImpl;

public class SaveAuthorActionImpl implements BaseAction{
	
	AuthorService as = new AuthorServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		User user = ActionHelper.getInstance().validateAdmin(request);
		if(user!=null) {
		Author author = as.buildAuthor(Integer.parseInt(request.getParameter("author_id")));
		author.setName(request.getParameter("name"));
		author.setSurName(request.getParameter("surname"));
		Date date = java.sql.Date.valueOf(request.getParameter("calendar"));
		author.setBirthDate(date);
		as.updateAuthor(author);
		HttpSession session = request.getSession();
		session.setAttribute("prevAction", "update_author");
		return PAGE_SUCSESS_RD;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
