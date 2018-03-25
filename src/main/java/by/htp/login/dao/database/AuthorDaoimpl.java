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

import by.htp.login.beans.Author;
import by.htp.login.dao.AuthorDao;

public class AuthorDaoimpl extends AbstractDaoMySqlImpl implements AuthorDao{
	
	static final String INSERT_INTO_AUTHOR = "INSERT INTO author (name, surname, birth_date) values (?, ?, ?)";
	static final String SELECT_AUTHOR_ID = "SELECT * FROM author WHERE author_id = ?;";
	static final String UPDATE_AUTHOR = "UPDATE author SET name = ?, surname = ?, birth_date = ? WHERE author_id = ?";
	static final String DELETE_AUTHOR = "DELETE FROM author WHERE author_id = ?";
	static final String SELECT_AUTHOR_ALL = "SELECT * FROM author;";
	static final String SELET_AUTHOR_LIKE = "SELECT * FROM author WHERE surname like concat('%', ?,'%');";

	@Override
	public void create(Author t) throws IOException {
		
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(INSERT_INTO_AUTHOR)){
			
			ps.setString(1, t.getName());
			ps.setString(2, t.getSurName());
			ps.setString(3, t.getBirthDate().toString());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Author read(int id) throws IOException, ParseException {
		Author author = null;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement st = cn.prepareStatement(SELECT_AUTHOR_ID);){
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			author = buildAuthor(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return author;
	}


	@Override
	public void update(Author t) {
		
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(UPDATE_AUTHOR)){
			
			ps.setString(1, t.getName());
			ps.setString(2, t.getSurName());
			ps.setString(3, t.getBirthDate().toString());
			ps.setInt(4, t.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) throws IOException, ParseException {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(DELETE_AUTHOR)){
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Author> readAll() {
		List<Author> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection();Statement st = cn.createStatement()){

			rs = st.executeQuery(SELECT_AUTHOR_ALL);
			while (rs.next()) {
				list.add(buildAuthor(rs));
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

	private Author buildAuthor(ResultSet rs) throws SQLException {
		return new Author(rs.getInt(SQL_AUTHOR_ID), rs.getString(SQL_AUTHOR_NAME), rs.getString(SQL_AUTHOR_SURNAME),
				rs.getDate(SQL_AUTHOR_BIRTH_DATE));
	}

	@Override
	public List<Author> findAuthor(String surname) {
		List<Author> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELET_AUTHOR_LIKE)){
			
			ps.setString(1, surname);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(buildAuthor(rs));
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
