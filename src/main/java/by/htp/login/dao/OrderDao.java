package by.htp.login.dao;

import java.util.List;

import by.htp.login.beans.Order;

public interface OrderDao extends BaseDao<Order>{
	
	public List<Order> returnNotAprooved();
	
	public List<Order> returnAprooved();
	
	public List<Order> returnOutdated();
	
	public List<Order> returnAll();
	
	public List<Order> returnOutdatedUser(int id);
	
	public List<Order> returnOrdersInUser(int id);
	
	public List<Order> returnOrdersUser(int id);

}
