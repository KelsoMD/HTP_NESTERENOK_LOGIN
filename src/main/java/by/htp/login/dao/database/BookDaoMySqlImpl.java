package by.htp.login.dao.database;

import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import by.htp.login.beans.Author;
import by.htp.login.beans.Book;
import by.htp.login.dao.BookDao;

public class BookDaoMySqlImpl implements BookDao {

	{
		try {
			Class.forName(getConnectInitValue()[3]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Book entity) throws IOException {
		Book book = (Book) entity;
		Connection connection = null;
		String[] newBook = new String[2];
		newBook[0] = book.getTitle();
		newBook[1] = ""+book.getAuthor().getId();
		String insert = "insert into book (title, author, publish_year) values (?, ?, ?)";
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);

			PreparedStatement prst = connection.prepareStatement(insert);
			prst.setString(1, newBook[0]);
			prst.setInt(2, Integer.parseInt(newBook[1]));
			prst.setDate(3, (Date) book.getPublishDate());
			prst.executeUpdate();

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
	}

	@Override
	public Book read(int id) throws NumberFormatException, IOException, ParseException {
		Connection connection = null;
		String sql1 = "SELECT * from book WHERE book_id = ?;";
		String sql2 = "SELECT * from author WHERE author_id = ?";
		Book book = null;
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);

			connection.setAutoCommit(false);

			PreparedStatement ps1 = connection.prepareStatement(sql1);
			ps1.setInt(1, id);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int authorId = rs1.getInt("author");
			String title = rs1.getString("title");
			int bookId = rs1.getInt("book_id");
			Date publishYear = rs1.getDate("publish_year");

			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, authorId);
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			Author author = new Author(rs2.getInt("author_id"), rs2.getString("name"), rs2.getString("surname"),
					rs2.getDate("birth_date"));
			book = new Book(bookId, title, author, publishYear);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}

	@Override
	public void update(Book entity) {
		Connection connection = null;
		String sql = "UPDATE book SET title = ?, author = ?, publish_year = ? WHERE book_id =?";
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = sdf.format(entity.getPublishDate());
			Date sqlDate = Date.valueOf(strDate);

			connection = DriverManager.getConnection(url, login, pass);
			PreparedStatement prst = connection.prepareStatement(sql);
			prst.setString(1, entity.getTitle());
			prst.setInt(2, entity.getAuthor().getId());
			prst.setDate(3, sqlDate);
			prst.setInt(4, entity.getId());
			prst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void delete(int id) throws NumberFormatException, IOException, ParseException {
		Connection connection = null;
		String insert = "delete from book where book_id = ?";
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);

			PreparedStatement prst = connection.prepareStatement(insert);
			prst.setInt(1, id);
			prst.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Book> readAll() throws NumberFormatException, IOException, ParseException {
		List<Book> list = new ArrayList<>();
		Map<Integer, Author> authorMap = new HashMap<>();
		Connection connection = null;
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);

			connection.setAutoCommit(false);
			String sql1 = "SELECT * FROM author;";
			Statement st1 = connection.createStatement();
			ResultSet rs1 = st1.executeQuery(sql1);
			while (rs1.next()) {
				authorMap.put(rs1.getInt("author_id"), new Author(rs1.getInt("author_id"), rs1.getString("name"),
						rs1.getString("surname"), rs1.getDate("birth_date")));
			}

			Statement st2 = connection.createStatement();
			ResultSet rs2 = st2.executeQuery("SELECT * FROM book;");
			while (rs2.next()) {
				list.add(new Book(rs2.getInt("book_id"), rs2.getString("title"), authorMap.get(rs2.getInt("author")), rs2.getDate("publish_year")));
			}
			connection.commit();
		} catch (SQLException e1) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
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

	@Override
	public Book read(String s) {
		Connection connection = null;
		String sql1 = "SELECT * from book WHERE title = ?;";
		String sql2 = "SELECT * from author WHERE author_id = ?";
		Book book = null;
		try {
			String url = getConnectInitValue()[0];
			String login = getConnectInitValue()[1];
			String pass = getConnectInitValue()[2];

			connection = DriverManager.getConnection(url, login, pass);

			connection.setAutoCommit(false);

			PreparedStatement ps1 = connection.prepareStatement(sql1);
			ps1.setString(1, s);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			int authorId = rs1.getInt("author");
			String title = rs1.getString("title");
			int bookId = rs1.getInt("book_id");
			Date publishYear = rs1.getDate("publish_year");

			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, authorId);
			ResultSet rs2 = ps2.executeQuery();
			rs2.next();
			Author author = new Author(rs2.getInt("author_id"), rs2.getString("name"), rs2.getString("surname"),
					rs2.getDate("birth_date"));
			book = new Book(bookId, title, author, publishYear);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return book;
	}

}
