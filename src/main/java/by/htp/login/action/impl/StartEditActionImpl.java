package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_CABINET_EDIT;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.User;

public class StartEditActionImpl implements BaseAction{
	
	

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		
		User user = ActionHelper.getInstance().validateUser(request);
		if (user!=null) {
			
			request.setAttribute("name", user.getAbonent().getName());
			request.setAttribute("lastname", user.getAbonent().getLastname());
			request.setAttribute("surname", user.getAbonent().getSurname());
			request.setAttribute("birthDate", user.getAbonent().getBirthDate());
			request.setAttribute("number", user.getAbonent().getNumber());
			request.setAttribute("e_mail", user.getAbonent().getEMail());
			
			return PAGE_CABINET_EDIT;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
