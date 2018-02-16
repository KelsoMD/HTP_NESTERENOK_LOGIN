package by.htp.login.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import by.htp.login.beans.Entity;
import by.htp.login.beans.User;
import by.htp.login.dao.UserDao;

public class UserDaoImpl implements UserDao{
	
	{
		try {
			Class.forName(getConnectInitValue()[3]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Entity e) {
		User user = (User) e;
		String url = getConnectInitValue()[0];
		String login = getConnectInitValue()[1];
		String pass = getConnectInitValue()[2];
		
		try (Connection connection = DriverManager.getConnection(url, login, pass)){
			PreparedStatement st = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?);");
			st.setString(1, user.getLogin());
			st.setString(2, user.getPassword());
			st.executeUpdate();
		} catch (SQLException exc) {
			exc.printStackTrace();
		} 
		
	}

	@Override
	public Entity read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Entity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkLogin(String user_login) {
		boolean result = false;
		User user = null;
		String url = getConnectInitValue()[0];
		String login = getConnectInitValue()[1];
		String pass = getConnectInitValue()[2];
		
		try (Connection connection = DriverManager.getConnection(url, login, pass)){
			PreparedStatement st = connection.prepareStatement("SELECT login FROM users WHERE login = ?;");
			st.setString(1, user_login);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				result = true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	@Override
	public boolean checkPassword(String user_login, String user_password) {
		boolean result = false;
		User user = null;
		String url = getConnectInitValue()[0];
		String login = getConnectInitValue()[1];
		String pass = getConnectInitValue()[2];
		
		try (Connection connection = DriverManager.getConnection(url, login, pass)){
			PreparedStatement st = connection.prepareStatement("SELECT password FROM users WHERE login = ?;");
			st.setString(1, user_login);
			ResultSet rs = st.executeQuery();
			rs.next();
			if (rs.getString("password")!=null) {
				if (rs.getString("password").equals(user_password)) {
					result = true;
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	private String[] getConnectInitValue() {

		ResourceBundle rs = ResourceBundle.getBundle("db_config");
		String dbURL = rs.getString("db.url");
		String login = rs.getString("db.login");
		String pass = rs.getString("db.pass");
		String drvName = rs.getString("db.driver.name");

		return new String[] { dbURL, login, pass, drvName };

	}

}
