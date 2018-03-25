package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.User;

public class SwitchRegActionImpl implements BaseAction{
	
	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		User user = ActionHelper.getInstance().validateAccount(request);
		if(user!=null) {
		request.setAttribute("errorLogin", user.getLogin());
		return PAGE_LOGIN_LOGED;
		} else {
			return PAGE_REGISTER;
		}
	}

}
