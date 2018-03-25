package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_EDIT_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Author;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.impl.AuthorServiceImpl;

public class EditAuthorActionImpl implements BaseAction{
	
	AuthorService as = new AuthorServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		User user = ActionHelper.getInstance().validateAdmin(request);	
		
		if (user!=null) {
		int authorId = Integer.parseInt(request.getParameter("author_id"));
		request.setAttribute("user", user);
		Author author = as.buildAuthor(authorId);
		request.setAttribute("author_id", author.getId());
		request.setAttribute("name", author.getName());
		request.setAttribute("surname", author.getSurName());
		request.setAttribute("birth_date", author.getBirthDate());
		return PAGE_EDIT_AUTHOR;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
