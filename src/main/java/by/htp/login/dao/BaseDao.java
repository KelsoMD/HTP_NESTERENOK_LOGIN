package by.htp.login.dao;

import by.htp.login.beans.Entity;

public interface BaseDao {

	public void create(Entity e);
	
	public Entity read(int id);
	
	public void update(Entity e);
	
	public void delete(int id);
		
}
