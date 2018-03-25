package by.htp.login.dao.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.login.beans.Abonent;
import by.htp.login.beans.User;
import by.htp.login.dao.UserDao;

public class UserDaoImpl extends AbstractDaoMySqlImpl implements UserDao {

	static final String INSERT_INTO_USERS = "INSERT INTO users (login, password, role, abonent) VALUES (?, ?, ?, ?);";
	static final String SELECT_USER_LOGIN = "SELECT * FROM users WHERE login = ?;";
	static final String SELECT_USER_ID = "SELECT * FROM users WHERE user_id = ?;";

	@Override
	public void create(User t) {
		try (Connection connection = wcn.getConnection();
				PreparedStatement st = connection.prepareStatement(INSERT_INTO_USERS);) {

			st.setString(1, t.getLogin());
			st.setString(2, t.getPassword());
			st.setInt(3, t.getRole());
			if(t.getAbonent()!=null) {
			st.setInt(4, t.getAbonent().getId());
			} else {
				st.setString(4, "null");
			}
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User readUser(User user) {
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_USER_LOGIN)) {
			ps.setString(1, user.getLogin());
			rs = ps.executeQuery();
			if(rs.next()) {
			user = buildUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	@Override
	public User read(int id) {
		User user = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_USER_ID)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			user = buildUser(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void update(User t) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean checkLogin(String userLogin) {
		boolean result = false;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_USER_LOGIN)) {
			ps.setString(1, userLogin);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public User checkPassword(String login, String password) {
		User user = null;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_USER_LOGIN)) {
			ps.setString(1, login);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(SQL_USER_PASS) != null && rs.getString(SQL_USER_PASS).equals(password)) {
					user = buildUser(rs);
				} else {
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	private User buildUser(ResultSet rs) throws SQLException {
		return new User(rs.getInt(SQL_USER_ID), rs.getString(SQL_USER_LOGIN), rs.getString(SQL_USER_PASS),
				rs.getInt(SQL_USER_ROLE), new Abonent(rs.getInt(SQL_USER_ABONENT)));
	}

}
