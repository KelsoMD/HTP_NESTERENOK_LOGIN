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

import by.htp.login.beans.Book;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.BookDao;

public class BookDaoMySqlImpl extends AbstractDaoMySqlImpl implements BookDao {

	static final String INSERT_INTO_BOOK = "INSERT INTO book (title, author, publish_year) values (?, ?, ?)";
	static final String SELECT_BOOK_ID = "SELECT * FROM book WHERE book_id = ?;";
	static final String SELECT_AUTHOR_ID = "SELECT * FROM author WHERE author_id = ?";
	static final String UPDATE_BOOK = "UPDATE book SET title = ?, author = ?, publish_year = ? WHERE book_id =?";
	static final String DELETE_BOOK = "DELETE FROM book WHERE book_id = ?";
	static final String SELECT_AUTHOR_ALL = "SELECT * FROM author;";
	static final String SELECT_BOOK_ALL_ADMIN = "SELECT * FROM book;";
	static final String SELECT_BOOK_ALL_USER = "SELECT * FROM book WHERE count > 0;";
	static final String SELECT_BOOK_TITLE = "SELECT * FROM book WHERE title like concat('%', ?,'%') AND count > 0;";
	static final String SELECT_BOOK_AUTHOR = "SELECT * FROM book JOIN author ON book.author = author.author_id WHERE author.surname like concat('%', ?,'%') AND book.count > 0;";
	static final String UPDATE_COUNT = "UPDATE book SET count = count + 1 WHERE book_id = ?;";
	static final String DECREMENT_COUNT = "UPDATE book SET count = count - 1 WHERE book_id = ?;";
	static final String SELECT_BOOK_TITLE_ADMIN = "SELECT * FROM book WHERE title like concat('%', ?,'%');";
	static final String SELECT_BOOK_AUTHOR_ADMIN = "SELECT * FROM book JOIN author ON book.author = author.author_id WHERE author.surname like concat('%', ?,'%');";
	
	@Override
	public void create(Book book) throws IOException {

		try (Connection cn = wcn.getConnection(); PreparedStatement prst = cn.prepareStatement(INSERT_INTO_BOOK);) {

			prst.setString(1, book.getTitle());
			prst.setInt(2, book.getAuthor().getId());
			prst.setString(3, book.getPublishDate().toString());
			prst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book read(int id) throws IOException, ParseException {

		Book book = null;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_BOOK_ID)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			book = buildBook(rs);
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
		return book;
	}

	@Override
	public void update(Book book) {

		try (Connection cn = wcn.getConnection(); PreparedStatement prst = cn.prepareStatement(UPDATE_BOOK);) {

			prst.setString(1, book.getTitle());
			prst.setInt(2, book.getAuthor().getId());
			prst.setString(3, book.getPublishDate().toString());
			prst.setInt(4, book.getId());
			prst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) throws IOException, ParseException {

		try (Connection cn = wcn.getConnection(); PreparedStatement prst = cn.prepareStatement(DELETE_BOOK);) {

			prst.setInt(1, id);
			prst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Book> readAll() throws IOException, ParseException {
		List<Book> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement();) {
			rs = st.executeQuery(SELECT_BOOK_ALL_USER);
			while (rs.next()) {
				list.add(buildBook(rs));
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

	private Book buildBook(ResultSet rs) throws SQLException, IOException, ParseException {
		AuthorDao ad = new AuthorDaoimpl();
		return new Book(rs.getInt(SQL_BOOK_ID), rs.getString(SQL_BOOK_TITLE), ad.read(rs.getInt(SQL_BOOK_AUTHOR)),
				rs.getDate(SQL_BOOK_PUBLISH_YEAR));
	}

	@Override
	public List<Book> readByTitle(String titlePart) throws IOException, ParseException {
		List<Book> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_BOOK_TITLE)) {

			ps.setString(1, titlePart);
			rs = ps.executeQuery();

			while(rs.next()) {
			list.add(buildBook(rs));
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
	public List<Book> readByAuthor(String author) throws IOException, ParseException {
		List<Book> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_BOOK_AUTHOR)){
			
			ps.setString(1, author);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(buildBook(rs));
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
	public List<Book> readAllAdmin() throws IOException, ParseException {
		List<Book> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement();) {
			rs = st.executeQuery(SELECT_BOOK_ALL_ADMIN);
			while (rs.next()) {
				list.add(buildBook(rs));
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
	public void updateCount(int id) {
		try(Connection cn = wcn.getConnection();PreparedStatement ps = cn.prepareStatement(UPDATE_COUNT)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> readByTitleAdmin(String title) throws IOException, ParseException {
		List<Book> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_BOOK_TITLE_ADMIN)) {

			ps.setString(1, title);
			rs = ps.executeQuery();

			while(rs.next()) {
			list.add(buildBook(rs));
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
	public List<Book> readByAuthorAdmin(String author) throws IOException, ParseException {
		List<Book> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SELECT_BOOK_AUTHOR_ADMIN)){
			
			ps.setString(1, author);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(buildBook(rs));
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
	public void decrementCount(int id) {
		try(Connection cn = wcn.getConnection();PreparedStatement ps = cn.prepareStatement(DECREMENT_COUNT)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
