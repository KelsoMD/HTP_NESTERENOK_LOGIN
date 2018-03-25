package by.htp.login.action.impl;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.service.OrderService;
import by.htp.login.service.impl.OrderServiceImpl;

public class ViewOrdersActionImpl implements BaseAction{
	
	OrderService os = new OrderServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		throw new UnsupportedOperationException();
	}

}
