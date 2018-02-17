package by.htp.login.dao;

import java.io.IOException;

import java.text.ParseException;
import java.util.List;

import by.htp.login.beans.*;

public interface BookDao extends BaseDao<Book> {
	
	List<Book> readAll() throws NumberFormatException, IOException, ParseException;

}
