package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ADMIN_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_USER;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Book;
import by.htp.login.beans.Order;
import by.htp.login.beans.User;
import by.htp.login.service.BookService;
import by.htp.login.service.OrderService;
import by.htp.login.service.impl.BookServiceImpl;
import by.htp.login.service.impl.OrderServiceImpl;

public class MainPage implements BaseAction {

	OrderService os = new OrderServiceImpl();
	BookService bs = new BookServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {

		User user = ActionHelper.getInstance().validateAccount(request);
		if (user != null && (user.getRole() == 1)) {
			List<Order> list = os.createOutdatedList();
			for(Order order : list) {
				order.setOutdated(true);
				os.updateOrder(order);
			}
			request.setAttribute("list", list);
			return PAGE_ADMIN_BOOK;
		} else if (user != null && (user.getRole() == 0)) {
			List<Book> list = bs.readBooks();
			request.setAttribute("list", list);
			return PAGE_USER;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}
}
