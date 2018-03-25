package by.htp.login.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import by.htp.login.beans.Abonent;
import by.htp.login.dao.AbonentDao;
import by.htp.login.dao.database.AbonentDaoMySqlImpl;
import by.htp.login.service.AbonentService;

public class AbonentServiceImpl implements AbonentService{
	
	AbonentDao dao = new AbonentDaoMySqlImpl();

	@Override
	public void deleteAbonent(int id) {
		try {
			dao.delete(id);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Abonent> readAbonents() {
		return dao.readAll();
	}

	@Override
	public Abonent buildAbonent(int id) {
		Abonent abonent = null;
		try {
			abonent = dao.read(id);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return abonent;
	}

	@Override
	public void updateAbonent(Abonent abonent) {
		dao.update(abonent);
	}

	@Override
	public int createAbonent(String name, String lastname, String surname, Date birthDate, String number,
			String eMail, Date registrationDate) {
			return dao.createAbonent(new Abonent(name, lastname, surname, birthDate, number, eMail, registrationDate));
	}
}
