package by.htp.login.dao.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import by.htp.login.beans.Abonent;
import by.htp.login.dao.AbonentDao;

public class AbonentDaoMySqlImpl extends AbstractDaoMySqlImpl implements AbonentDao {

	static final String INSERT_INTO_ABONENT = "INSERT INTO abonent (name, lastname, surname, birth_date, "
			+ "number, e_mail, registration_date) values (?, ?, ?, ?, ?, ?, ?)";
	static final String SELECT_ABONENT = "SELECT * FROM abonent WHERE id = ?;";
	static final String SELECT_ABONENT_ALL = "SELECT * from abonent;";
	static final String DELETE_ABONENT = "DELETE FROM abonent WHERE abonent_id = ?";
	static final String UPDATE_ABONENT = "UPDATE abonent SET name = ?, surname = ?, lastname = ?, birth_date = ?, number = ?, e_mail = ? WHERE abonent_id =?";
	static final String SELECT_ABONENT_ID = "SELECT * FROM abonent WHERE abonent_id = ?;";

	@Override
	public void create(Abonent t){

		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(INSERT_INTO_ABONENT)) {

			ps.setString(1, t.getName());
			ps.setString(2, t.getLastname());
			ps.setString(3, t.getSurname());
			ps.setString(4, t.getBirthDate().toString());
			ps.setString(5, t.getNumber());
			ps.setString(6, t.getEMail());
			ps.setString(7, t.getRegistrationDate().toString());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Abonent read(int id) throws IOException, ParseException {
		Abonent abonent = null;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_ABONENT_ID)) {

			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				abonent = new Abonent(rs.getInt(SQL_ABONENT_ID), rs.getString(SQL_ABONENT_NAME),
						rs.getString(SQL_ABONENT_LASTNAME), rs.getString(SQL_AUTHOR_SURNAME),
						rs.getDate(SQL_AUTHOR_BIRTH_DATE), rs.getString(SQL_ABONENT_NUMBER),
						rs.getString(SQL_ABONENT_EMAIL), rs.getDate(SQL_ABONENT_REG_DATE));
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
		return abonent;
	}

	@Override
	public void update(Abonent t) {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(UPDATE_ABONENT)) {

			ps.setString(1, t.getName());
			ps.setString(2, t.getSurname());
			ps.setString(3, t.getLastname());
			ps.setString(4, t.getBirthDate().toString());
			ps.setString(5, t.getNumber());
			ps.setString(6, t.getEMail());
			ps.setInt(7, t.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) throws IOException, ParseException {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(DELETE_ABONENT)) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Abonent> readAll() {
		List<Abonent> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()) {

			rs = st.executeQuery(SELECT_ABONENT_ALL);
			while (rs.next()) {
				list.add(new Abonent(rs.getString(SQL_ABONENT_NAME), rs.getString(SQL_ABONENT_LASTNAME),
						rs.getString(SQL_AUTHOR_SURNAME), rs.getDate(SQL_AUTHOR_BIRTH_DATE),
						rs.getString(SQL_ABONENT_NUMBER), rs.getString(SQL_ABONENT_EMAIL),
						rs.getDate(SQL_ABONENT_REG_DATE)));
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
		return list;
	}

	@Override
	public int createAbonent(Abonent abonent) {
		ResultSet rs = null;
		int id = 0;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(INSERT_INTO_ABONENT, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, abonent.getName());
			ps.setString(2, abonent.getSurname());
			ps.setString(3, abonent.getLastname());
			ps.setString(4, abonent.getBirthDate().toString());
			ps.setString(5, abonent.getNumber());
			ps.setString(6, abonent.getEMail());
			ps.setString(7, abonent.getRegistrationDate().toString());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
			id = rs.getInt(1);
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
		return id;
	}
}
