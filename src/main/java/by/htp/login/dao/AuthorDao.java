package by.htp.login.dao;

import java.util.List;

import by.htp.login.beans.Author;

public interface AuthorDao extends BaseDao<Author>{
	
	List<Author> readAll();
	
	List<Author> findAuthor(String surname);

}
