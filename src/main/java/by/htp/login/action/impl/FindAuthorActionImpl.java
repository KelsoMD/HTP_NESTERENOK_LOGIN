package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Author;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.impl.AuthorServiceImpl;

public class FindAuthorActionImpl implements BaseAction {
	AuthorService as = new AuthorServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		User user = ActionHelper.getInstance().validateAdmin(request);
		if (user != null) {
			List<Author> list = as.findAuthor(request.getParameter("surname"));
			request.setAttribute("list", list);
			request.setAttribute("prevAuthor", request.getParameter("surname"));
			return PAGE_ADMIN_AUTHOR;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
