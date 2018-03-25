package by.htp.login.action.impl;
import static by.htp.login.action.util.ManagerConstantPool.*;
import java.io.IOException;
import java.text.ParseException;


import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;

public class DefaultActionImpl implements BaseAction{

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		request.setAttribute("errorMsg", "Данная операция временно не поддерживается");
		return PAGE_ERROR;
	}

}
