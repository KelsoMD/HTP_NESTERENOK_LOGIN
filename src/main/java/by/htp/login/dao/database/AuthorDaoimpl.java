package by.htp.login.dao.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.login.beans.Author;
import by.htp.login.dao.AuthorDao;

public class AuthorDaoimpl implements AuthorDao{

	@Override
	public void create(Author t) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Author read(int id) throws NumberFormatException, IOException, ParseException {
		Author author = null;
		Connection connection = null;
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);

			String sql = "SELECT * FROM author WHERE author_id = ?;";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			author = new Author(rs.getInt("author_id"), rs.getString("name"), rs.getString("surname"),
					rs.getDate("birth_date"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return author;
	}

	@Override
	public Author read(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Author t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws NumberFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Author> readAll() {
		List<Author> list = new ArrayList<>();
		Connection connection = null;
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);

			String sql = "SELECT * FROM author;";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Author(rs.getInt("author_id"),rs.getString("name"),rs.getString("surname"),rs.getDate("birth_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	private String[] getConnectInitValue() {
		ResourceBundle rb = ResourceBundle.getBundle("db_config");
		String dbURL = rb.getString("db.url");
		String user = rb.getString("db.login");
		String pass = rb.getString("db.pass");
		String driver = rb.getString("db.driver.name");

		return new String[] { dbURL, user, pass, driver };
	}
}
