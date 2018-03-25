package by.htp.login.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import by.htp.login.beans.Abonent;
import by.htp.login.beans.Book;
import by.htp.login.beans.Order;
import by.htp.login.dao.AbonentDao;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.OrderDao;
import by.htp.login.dao.database.AbonentDaoMySqlImpl;
import by.htp.login.dao.database.BookDaoMySqlImpl;
import by.htp.login.dao.database.OrderDaoSqlImpl;
import by.htp.login.service.OrderService;

public class OrderServiceImpl implements OrderService {
	

	OrderDao dao = new OrderDaoSqlImpl();
	BookDao bDao = new BookDaoMySqlImpl();
	AbonentDao aDao = new AbonentDaoMySqlImpl();

	@Override
	public void createOrder(Book book, Abonent abonent, Date orderDate, Date returnToDate) {

		Order order = new Order();
		order.setBook(book);
		order.setAbonent(abonent);
		order.setOrderDate(orderDate);
		order.setReturnToDate(returnToDate);
		try {
			dao.create(order);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> createNewOrderList() {

		List<Order> list = dao.returnNotAprooved();
		for (Order order : list) {
			try {
				Abonent abonent = aDao.read(order.getAbonent().getId());
				Book book = bDao.read(order.getBook().getId());
				order.setAbonent(abonent);
				order.setBook(book);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public void updateOrder(Order order) {
		dao.update(order);
	}

	@Override
	public Order readOrder(int orderId) {
		Order order = null;
		try {
			order = dao.read(orderId);
			order.setAbonent(aDao.read(order.getAbonent().getId()));
			order.setBook(bDao.read(order.getBook().getId()));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> createAproovedOrderList() {
		List<Order> list = dao.returnAprooved();
		for (Order order : list) {
			Abonent abonent;
			try {
				abonent = aDao.read(order.getAbonent().getId());
				Book book = bDao.read(order.getBook().getId());
				order.setAbonent(abonent);
				order.setBook(book);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Order> createOutdatedList() {
		Date today = new Date();
		List<Order> list = dao.returnAprooved();
		for (Order order : list) {
				try {
					Abonent abonent = aDao.read(order.getAbonent().getId());
					Book book = bDao.read(order.getBook().getId());
					order.setAbonent(abonent);
					order.setBook(book);
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				}
		}
		Iterator<Order> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().getReturnToDate().after(today)) {
				it.remove();
			}
		}
		return list;
	}

	@Override
	public List<Order> createOrderList() {
		List<Order> list = dao.returnAll();
		for(Order order : list) {
			try {
			Abonent abonent = aDao.read(order.getAbonent().getId());
			Book book = bDao.read(order.getBook().getId());
			order.setAbonent(abonent);
			order.setBook(book);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Order> userOutadetList(int id) {
		List<Order> list = dao.returnOutdatedUser(id);
		for (Order order : list) {
			try {
				Abonent abonent = aDao.read(order.getAbonent().getId());
				Book book = bDao.read(order.getBook().getId());
				order.setAbonent(abonent);
				order.setBook(book);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Order> userInList(int id) {
		List<Order> list = dao.returnOrdersInUser(id);
		for (Order order : list) {
			try {
				Abonent abonent = aDao.read(order.getAbonent().getId());
				Book book = bDao.read(order.getBook().getId());
				order.setAbonent(abonent);
				order.setBook(book);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Order> userOrdersList(int id) {
		List<Order> list = dao.returnOrdersUser(id);
		for (Order order : list) {
			try {
				Abonent abonent = aDao.read(order.getAbonent().getId());
				Book book = bDao.read(order.getBook().getId());
				order.setAbonent(abonent);
				order.setBook(book);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
