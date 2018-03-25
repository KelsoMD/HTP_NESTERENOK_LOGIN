package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ADD_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.impl.AuthorServiceImpl;

public class SwitchAddAuthor implements BaseAction{
	
	AuthorService as = new AuthorServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		
		User user = ActionHelper.getInstance().validateAdmin(request);
		if (user!=null && user.getRole()==1) {
		return PAGE_ADD_AUTHOR;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}
}
