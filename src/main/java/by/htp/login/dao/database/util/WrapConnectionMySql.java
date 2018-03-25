package by.htp.login.dao.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WrapConnectionMySql implements AutoCloseable {

	private Connection cn;
	
	

	public WrapConnectionMySql() {
		super();
	}

	public Connection getConnection() throws SQLException {

		String url = getConnectInitValue()[0];
		String login = getConnectInitValue()[1];
		String pass = getConnectInitValue()[2];
		
		try {
			
			Class.forName(getConnectInitValue()[3]);
			cn = DriverManager.getConnection(url, login, pass);
			
		} catch (ClassNotFoundException e) {
			
			throw new SQLException("Driver not loaded", e);
			
		}
		return cn;
	}

	@Override
	public void close() throws Exception {
		cn.close();

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
