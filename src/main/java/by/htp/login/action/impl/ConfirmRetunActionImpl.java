package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ADMIN_RETURN_ORDER;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Order;
import by.htp.login.beans.User;
import by.htp.login.service.OrderService;
import by.htp.login.service.impl.OrderServiceImpl;

public class ConfirmRetunActionImpl implements BaseAction{
	
	OrderService os = new OrderServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		User user = ActionHelper.getInstance().validateAdmin(request);
		if (user!=null) {
			int orderId = Integer.parseInt(request.getParameter("order_id"));
			Order order = os.readOrder(orderId);
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date returnDate = java.sql.Date.valueOf(sf.format(new Date()));	
			order.setReturnDate(returnDate);
			order.setReturned(true);
			os.updateOrder(order);
			List<Order> list = os.createAproovedOrderList();
			request.setAttribute("list", list);
			return PAGE_ADMIN_RETURN_ORDER;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
