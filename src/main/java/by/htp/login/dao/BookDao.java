package by.htp.login.dao;

import java.io.IOException;

import java.text.ParseException;
import java.util.List;

import by.htp.login.beans.*;

public interface BookDao extends BaseDao<Book> {
	
	List<Book> readAll() throws IOException, ParseException;
	
	List<Book> readAllAdmin() throws IOException, ParseException;
	
	List<Book> readByTitle(String title) throws IOException, ParseException;
	
	List<Book> readByAuthor(String author) throws IOException, ParseException;
	
	List<Book> readByTitleAdmin(String title) throws IOException, ParseException;
	
	List<Book> readByAuthorAdmin(String author) throws IOException, ParseException;
	
	void updateCount(int id);
	
	void decrementCount(int id);

}
