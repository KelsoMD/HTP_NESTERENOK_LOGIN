package by.htp.login.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import by.htp.login.beans.Author;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.database.AuthorDaoimpl;
import by.htp.login.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
	
	AuthorDao dao = new AuthorDaoimpl();

	@Override
	public List<Author> buildAuthors() {
		return dao.readAll();
	}

	@Override
	public Author buildAuthor(int authorId) {
		Author author = null;
		try {
			author = dao.read(authorId);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public void deleteAuthor(int id) {
		
		try {
			dao.delete(id);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void createAuthor(String name, String surname, Date birthDate){
		Author author = new Author(name, surname, birthDate);
		
		try {
			dao.create(author);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAuthor(Author author) {
		dao.update(author);
	}

	@Override
	public List<Author> findAuthor(String surname) {
		return dao.findAuthor(surname);
	}

}
