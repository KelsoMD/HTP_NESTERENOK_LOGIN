package by.htp.login.dao;

import java.util.List;
import by.htp.login.beans.*;

import by.htp.login.beans.*;

public interface AbonentDao extends BaseDao<Abonent>{
	
	List<Abonent> readAll();
	
	List<String> readTwoOrMore();
	
	List<String> readLessThenTwo();

}
