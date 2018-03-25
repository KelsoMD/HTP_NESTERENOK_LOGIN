package by.htp.login.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.login.beans.Book;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.database.AuthorDaoimpl;
import by.htp.login.dao.database.BookDaoMySqlImpl;
import by.htp.login.service.BookService;

public class BookServiceImpl implements BookService {

	BookDao dao = new BookDaoMySqlImpl();
	AuthorDao authorDao = new AuthorDaoimpl();

	@Override
	public void deleteBook(int id) {
		try {
			dao.delete(id);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> readBooks() {
		List<Book> books = new ArrayList<>();
		try {
			books = dao.readAll();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book buildBook(int id) {
		Book book = null;
		try {
			book = dao.read(id);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return book;
	}

	@Override
	public void updateBook(Book book) {
		dao.update(book);
	}

	@Override
	public void createBook(String title, int author, Date publishYear) {

		Book t = null;
		try {
			t = new Book(title, authorDao.read(author), publishYear);
			dao.create(t);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> readByTitle(String title) {
		List<Book> list = new ArrayList<>();
			try {
				list = dao.readByTitle(title);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		return list;
	}
	

	@Override
	public List<Book> readByAuthor(String author) {
		List<Book> list = new ArrayList<>();
		try {
			list = dao.readByAuthor(author);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book> readBooksAdmin() {
		List<Book> books = new ArrayList<>();
		try {
			books = dao.readAllAdmin();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void updateCount(int id) {
		dao.updateCount(id);
	}

	@Override
	public List<Book> readByTitleAdmin(String title) {
		List<Book> list = new ArrayList<>();
		try {
			list = dao.readByTitleAdmin(title);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	return list;
	}

	@Override
	public List<Book> readByAuthorAdmin(String author) {
		List<Book> list = new ArrayList<>();
		try {
			list = dao.readByAuthorAdmin(author);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void decrementCount(int id) {
		dao.decrementCount(id);
	}
}
