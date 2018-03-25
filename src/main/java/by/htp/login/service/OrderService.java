package by.htp.login.service;

import java.util.Date;
import java.util.List;

import by.htp.login.beans.Abonent;
import by.htp.login.beans.Book;
import by.htp.login.beans.Order;

public interface OrderService {
	
	public void createOrder(Book book, Abonent abonent, Date orderDate, Date returnToDate);
	
	public List<Order> createNewOrderList();
	
	public List<Order> createAproovedOrderList();
	
	public List<Order> createOutdatedList();
	
	public List<Order> createOrderList();
	
	public void updateOrder(Order order);
	
	public Order readOrder(int orderId);
	
	public List<Order> userOutadetList(int id);
	
	public List<Order> userInList(int id);
	
	public List<Order> userOrdersList(int id);
	
	

}
