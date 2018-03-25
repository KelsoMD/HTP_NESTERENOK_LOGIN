package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.service.OrderService;
import by.htp.login.service.impl.OrderServiceImpl;

public class MailActionImpl implements BaseAction{
	
	OrderService os = new OrderServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		request.setAttribute("errorMsg", "Функция временно недоступна");
		return PAGE_ERROR;
	}
	
	

}
