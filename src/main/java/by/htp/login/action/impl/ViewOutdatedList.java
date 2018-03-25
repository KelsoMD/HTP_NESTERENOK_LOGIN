package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Order;
import by.htp.login.beans.User;
import by.htp.login.service.OrderService;
import by.htp.login.service.impl.OrderServiceImpl;

public class ViewOutdatedList implements BaseAction {

	ActionHelper ah = new ActionHelper();
	OrderService os = new OrderServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		User user = ah.validateAdmin(request);
		if (user != null && user.getRole() == 1) {
			List<Order> list = os.createOutdatedList();
			request.setAttribute("list", list);
			return PAGE_ADMIN_BOOK;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
