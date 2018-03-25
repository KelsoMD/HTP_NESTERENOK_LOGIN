package by.htp.login.dao;

import java.io.IOException;
import java.text.ParseException;

import by.htp.login.beans.Entity;

public interface BaseDao<T extends Entity> {

	public void create(T t) throws IOException;
	
	public T read(int id) throws IOException, ParseException;
	
	public void update(T t);
	
	public void delete(int id) throws IOException, ParseException;
		
}
