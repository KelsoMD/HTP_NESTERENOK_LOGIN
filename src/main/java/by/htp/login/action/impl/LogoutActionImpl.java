package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.action.BaseAction;

public class LogoutActionImpl implements BaseAction{

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		HttpSession session = request.getSession();
		session.invalidate();
		return PAGE_INDEX;
	}

}
