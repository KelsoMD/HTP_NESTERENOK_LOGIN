package by.htp.login.dao;

import java.util.List;

import by.htp.login.beans.Author;
import by.htp.login.beans.Book;

public interface AuthorDao extends BaseDao<Author>{
	
	List<Author> readAll();

}
