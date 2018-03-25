package by.htp.login.dao;

import java.util.List;

import by.htp.login.beans.Abonent;

public interface AbonentDao extends BaseDao<Abonent>{
	
	List<Abonent> readAll();
	
	int createAbonent(Abonent abonent);
	

}
