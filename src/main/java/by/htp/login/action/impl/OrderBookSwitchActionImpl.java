package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Book;
import by.htp.login.beans.User;
import by.htp.login.service.BookService;
import by.htp.login.service.OrderService;
import by.htp.login.service.impl.BookServiceImpl;
import by.htp.login.service.impl.OrderServiceImpl;

public class OrderBookSwitchActionImpl implements BaseAction {

	OrderService os = new OrderServiceImpl();
	BookService bs = new BookServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {

		User user = ActionHelper.getInstance().validateUser(request);

		if (user != null && user.getAbonent() != null) {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date orderDate = java.sql.Date.valueOf(sf.format(new Date()));
			Calendar returnTo = Calendar.getInstance();
			returnTo.setTime(orderDate);
			returnTo.add(Calendar.DATE, RENT_DAYS);
			Date returnToDate = java.sql.Date.valueOf(sf.format(new Date(returnTo.getTimeInMillis())));
			Book book = new Book(Integer.parseInt(request.getParameter("book_id")));
			os.createOrder(book, user.getAbonent(), orderDate, returnToDate);
			request.setAttribute("order", "Book ordered");
			bs.decrementCount(Integer.parseInt(request.getParameter("book_id")));
			if (request.getParameter("search") != null
					&& request.getParameter("search").equals(REQUEST_PARAM_SEARCH_BOOK)) {
				List<Book> list = bs.readByTitle(request.getParameter("prevTitle"));
				request.setAttribute("list", list);
				return PAGE_USER;
			} else if (request.getParameter("search") != null
					&& request.getParameter("search").equals(REQUEST_PARAM_SEARCH_AUTHOR)) {
				List<Book> list = bs.readByAuthor(request.getParameter("prevAuthor"));
				request.setAttribute("list", list);
				return PAGE_USER_AUTHOR;
			} else {
				return PAGE_ERROR;
			}
		} else {
		}
		request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
		return PAGE_ERROR;
	}
}
