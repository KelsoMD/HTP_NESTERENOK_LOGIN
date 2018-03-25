package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ADMIN_NEW_ORDERS;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;

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

public class ConfirmOrder implements BaseAction {

	OrderService os = new OrderServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {

		User user = ActionHelper.getInstance().validateAdmin(request);
		if (user != null && user.getRole() == 1) {
			int orderId = Integer.parseInt(request.getParameter("order_id"));
			Order order = os.readOrder(orderId);
			order.setAprooved(true);
			os.updateOrder(order);
			List<Order> list = os.createNewOrderList();
			request.setAttribute("list", list);
			return PAGE_ADMIN_NEW_ORDERS;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
