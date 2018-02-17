package by.htp.login.action.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.beans.Abonent;
import by.htp.login.dao.AbonentDao;
import by.htp.login.dao.database.AbonentDaoMySqlImpl;

public class ViewAbonentsListActionImpl implements BaseAction{
	private AbonentDao dao = new AbonentDaoMySqlImpl();

	@Override
	public String act(HttpServletRequest request) throws NumberFormatException, IOException, ParseException {
		
		List<Abonent> list= dao.readAll();
		for (Abonent abonent : list) {
			//out.println(abonent);
		}
		return null;
		
	}
}
