package by.htp.login.service;

import java.util.Date;
import java.util.List;

import by.htp.login.beans.Abonent;

public interface AbonentService {

	public void deleteAbonent(int id);
	
	public List<Abonent> readAbonents();
	
	public Abonent buildAbonent(int id);
	
	public void updateAbonent(Abonent abonent);
	
	public int createAbonent(String name, String lastname, String surname, Date birthDate, String number, String eMail,
			Date registrationDate);
	
}
