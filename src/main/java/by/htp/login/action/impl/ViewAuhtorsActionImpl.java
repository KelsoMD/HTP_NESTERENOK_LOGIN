package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Author;
import by.htp.login.beans.User;
import by.htp.login.service.AuthorService;
import by.htp.login.service.impl.AuthorServiceImpl;

public class ViewAuhtorsActionImpl implements BaseAction{
	
	AuthorService as = new AuthorServiceImpl();

	@Override
	public String act(HttpServletRequest request){
		User user = ActionHelper.getInstance().validateAdmin(request);
		if(user!=null) {
		List<Author> list = as.buildAuthors();
		request.setAttribute("list", list);
		return PAGE_ADMIN_AUTHOR;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}
	

}
