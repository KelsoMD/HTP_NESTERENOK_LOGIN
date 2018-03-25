package by.htp.login.dao.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.login.beans.Abonent;
import by.htp.login.beans.Book;
import by.htp.login.beans.Order;
import by.htp.login.dao.OrderDao;

public class OrderDaoSqlImpl extends AbstractDaoMySqlImpl implements OrderDao {

	static final String INSERT_INTO_ORDER = "INSERT INTO card (book, abonent, order_date, return_to_date) VALUES (?, ?, ?, ?)";
	static final String SELECT_NOT_APROOVED = "SELECT * FROM card where aprooved = 0;";
	static final String SELECT_APROOVED = "SELECT * FROM card WHERE aprooved = 1 AND returned = 0";
	static final String SELECT_OUTDATED = "SELECT * FROM card WHERE aprooved = 1 AND returned = 0 AND outdated = 1";
	static final String SELECT_ORDER = "SELECT * FROM card WHERE order_id = ?";
	static final String UPDATE_ORDER = "UPDATE card SET book =?, abonent = ?, order_date = ?, return_to_date =?, return_date = ?, returned = ?, aprooved = ?, outdated = ? WHERE order_id =?";
	static final String SELECT_ALL = "Select * from card;"; 
	static final String SELECT_OUTDATED_USER = "SELECT * FROM card WHERE outdated = 1 AND returned = 0 AND abonent = ?;";
	static final String SELECT_ORDERS_IN_USER = "SELECT * FROM card WHERE aprooved = 1 AND returned = 0 AND abonent = ?;";
	static final String SELECT_ORDERS_USER = "SELECT * FROM card WHERE abonent = ?;";
	
	@Override
	public void create(Order order) throws IOException {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(INSERT_INTO_ORDER)) {

			ps.setInt(1, order.getBook().getId());
			ps.setInt(2, order.getAbonent().getId());
			ps.setString(3, order.getOrderDate().toString());
			ps.setString(4, order.getReturnToDate().toString());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Order read(int id) throws IOException, ParseException {
		Order order = null;
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_ORDER)){
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			int orderId = rs.getInt(SQL_ORDER_ID);
			int bookId = rs.getInt(SQL_ORDER_BOOK);
			int abonentId = rs.getInt(SQL_USER_ABONENT);
			Date orderDate = rs.getDate(SQL_ORDER_ORDER_DATE);
			Date returnToDate = rs.getDate(SQL_ORDER_RETURNTO_DATE);
			Date returnDate = rs.getDate(SQL_ORDER_RETURN_DATE);
			boolean aprooved = rs.getBoolean(SQL_ORDER_APROOVED);
			boolean outdated = rs.getBoolean(SQL_ORDER_OUTDATED);
			boolean returned = rs.getBoolean(SQL_ORDER_RETURNED);
			
			order = new Order(orderId, new Book(bookId), new Abonent(abonentId), orderDate, returnToDate, returnDate, returned, outdated, aprooved);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return order;

	}

	@Override
	public void update(Order t) {
		
		try(Connection cn = wcn.getConnection();PreparedStatement ps = cn.prepareStatement(UPDATE_ORDER)){
			ps.setInt(1, t.getBook().getId());
			ps.setInt(2, t.getAbonent().getId());
			ps.setString(3, t.getOrderDate().toString());
			ps.setString(4, t.getReturnToDate().toString());
			if (t.getReturnDate()!=null) {
			ps.setString(5, t.getReturnDate().toString());
			} else {
				ps.setString(5, null);
			}
			ps.setBoolean(6, t.isReturned());
			ps.setBoolean(7, t.isAprooved());
			ps.setBoolean(8, t.isOutdated());
			ps.setInt(9, t.getId());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) throws IOException, ParseException {
		throw new UnsupportedOperationException();

	}

	@Override
	public List<Order> returnNotAprooved() {

		List<Order> list = new ArrayList<>();
		ResultSet rs = null;

		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()) {

			rs = st.executeQuery(SELECT_NOT_APROOVED);
			while (rs.next()) {
				int id = rs.getInt("order_id");
				int abonent = rs.getInt("abonent");
				int book = rs.getInt("book");
				Date orderDate = rs.getDate("order_date");
				list.add(new Order(id, new Abonent(abonent), new Book(book), orderDate));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Order> returnAprooved() {
		List<Order> list = new ArrayList<>();
		ResultSet rs = null;

		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()) {

			rs = st.executeQuery(SELECT_APROOVED);
			while (rs.next()) {
				list.add(buildOrder(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	@Override
	public List<Order> returnOutdated() {
		List<Order> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection();Statement st = cn.createStatement()){
			
			rs = st.executeQuery(SELECT_OUTDATED);
			while(rs.next()) {
				list.add(buildOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	
	private Order buildOrder(ResultSet rs) throws SQLException {
		
		int id = rs.getInt(SQL_ORDER_ID);
		int book = rs.getInt(SQL_ORDER_BOOK);
		int abonent = rs.getInt(SQL_USER_ABONENT);
		Date orderDate = rs.getDate(SQL_ORDER_ORDER_DATE);
		Date returnTo = rs.getDate(SQL_ORDER_RETURNTO_DATE);
		Date returnDate = rs.getDate(SQL_ORDER_RETURN_DATE);
		boolean returned = rs.getBoolean(SQL_ORDER_RETURNED);
		boolean outdated = rs.getBoolean(SQL_ORDER_OUTDATED);
		boolean aprooved = rs.getBoolean(SQL_ORDER_APROOVED);
		
		return new Order(id, new Book(book), new Abonent(abonent), orderDate, returnTo, returnDate, returned,outdated,aprooved);
	}

	@Override
	public List<Order> returnAll() {
		List<Order> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()){
			rs = st.executeQuery(SELECT_ALL);
			while(rs.next()) {
				list.add(buildOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<Order> returnOutdatedUser(int id) {
		List<Order> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection();PreparedStatement ps = cn.prepareStatement(SELECT_OUTDATED_USER)){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(buildOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<Order> returnOrdersInUser(int id) {
		List<Order> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection();PreparedStatement ps = cn.prepareStatement(SELECT_ORDERS_IN_USER)){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(buildOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<Order> returnOrdersUser(int id) {
		List<Order> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection();PreparedStatement ps = cn.prepareStatement(SELECT_ORDERS_USER)){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(buildOrder(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	
}
