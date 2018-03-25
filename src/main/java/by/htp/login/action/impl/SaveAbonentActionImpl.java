package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_SUCSESS_RD;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.User;
import by.htp.login.service.AbonentService;
import by.htp.login.service.impl.AbonentServiceImpl;

public class SaveAbonentActionImpl implements BaseAction{
	
	
	AbonentService as = new AbonentServiceImpl();
	
	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		
		User user = ActionHelper.getInstance().validateUser(request);
		if(user!=null) {

			user.getAbonent().setName(request.getParameter("name"));
			user.getAbonent().setLastname(request.getParameter("lastname"));
			user.getAbonent().setSurname(request.getParameter("surname"));
			String strDate = request.getParameter("birth_date");
			Date birthDate = java.sql.Date.valueOf(strDate);
			user.getAbonent().setBirthDate(birthDate);
			user.getAbonent().setNumber(request.getParameter("number"));
			user.getAbonent().setEMail(request.getParameter("e_mail"));
			as.updateAbonent(user.getAbonent());
			HttpSession session = request.getSession();
			session.setAttribute("prevAction", "update_abonent");
			return PAGE_SUCSESS_RD;
			
		} else {
			
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		
		}
	}

}
