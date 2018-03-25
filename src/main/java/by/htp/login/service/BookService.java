package by.htp.login.service;

import java.util.Date;
import java.util.List;

import by.htp.login.beans.Book;

public interface BookService {
	
	public void deleteBook(int id);
	
	public List<Book> readBooks();
	
	public List<Book> readBooksAdmin();
	
	public Book buildBook(int id);
	
	public void updateBook(Book book);
	
	public void createBook(String title, int author, Date publishYear);
	
	public List<Book> readByTitle(String title);
	
	public List<Book> readByAuthor(String author);
	
	public List<Book> readByTitleAdmin(String title);
	
	public List<Book> readByAuthorAdmin(String author);
	
	public void updateCount(int id);
	
	public void decrementCount(int id);
}
