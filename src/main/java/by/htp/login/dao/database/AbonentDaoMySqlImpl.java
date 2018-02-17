package by.htp.login.dao.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.login.beans.Abonent;
import by.htp.login.beans.Entity;
import by.htp.login.dao.AbonentDao;

public class AbonentDaoMySqlImpl implements AbonentDao {

	{
		try {
			Class.forName(getConnectInitValue()[3]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Abonent entity) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Abonent read(int id) throws NumberFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Abonent entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws NumberFormatException, IOException, ParseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Abonent> readAll() {
		List<Abonent> list = new ArrayList<>();
		String request = "SELECT * from abonent;";
		Connection connection = null;
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(request);
			while (rs.next()) {
				Abonent abonent = new Abonent();
				abonent.setId(rs.getInt("abonent_id"));
				abonent.setName(rs.getString("name"));
				abonent.setSurName(rs.getString("surname"));
				abonent.setRegistrationDate(rs.getDate("registration_date"));
				list.add(abonent);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<String> readTwoOrMore() {
		List<String> list = new ArrayList<>();
		String sql = "select abonent.name, abonent.surname, count(books_read.abonent) from books_read join abonent on books_read.abonent = abonent.abonent_id group by books_read.abonent having count(books_read.abonent)>1;";
		Connection connection = null;
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				list.add(rs.getString("abonent.name") + " " + rs.getString("abonent.surname") + " read "
						+ rs.getInt("count(books_read.abonent)") + " books");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<String> readLessThenTwo() {
		List<String> list = new ArrayList<>();
		String sql = "select abonent.name, abonent.surname, abonent.registration_date, "
				+ "count(books_read.abonent) from books_read join abonent on books_read.abonent = abonent.abonent_id "
				+ "group by books_read.abonent having count(books_read.abonent)<=2;";
		Connection connection = null;
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				list.add(rs.getString("abonent.name") + " " + rs.getString("abonent.surname") + " read "
						+ rs.getInt("count(books_read.abonent)") + " books");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	private String[] getConnectInitValue() {

		ResourceBundle rs = ResourceBundle.getBundle("db_config");
		String dbURL = rs.getString("db.url");
		String login = rs.getString("db.login");
		String pass = rs.getString("db.pass");
		String drvName = rs.getString("db.driver.name");

		return new String[] { dbURL, login, pass, drvName };

	}

	@Override
	public Abonent read(String s) {
		// TODO Auto-generated method stub
		return null;
	}


}
