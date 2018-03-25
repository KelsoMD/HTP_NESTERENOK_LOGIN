package by.htp.login.service;

import java.util.Date;
import java.util.List;

import by.htp.login.beans.Author;

public interface AuthorService {
	
	
	
	public List<Author> buildAuthors();
	
	public Author buildAuthor(int id);
	
	public void deleteAuthor(int id);
	
	public void createAuthor(String name, String surname, Date birthDate);

	public void updateAuthor(Author author);
	
	public List<Author> findAuthor(String surname);

}
