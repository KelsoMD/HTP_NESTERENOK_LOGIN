package by.htp.login.action.impl;

import static by.htp.login.action.util.ManagerConstantPool.MSG_ERROR_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_CABINET;
import static by.htp.login.action.util.ManagerConstantPool.PAGE_ERROR;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.action.BaseAction;
import by.htp.login.action.util.ActionHelper;
import by.htp.login.beans.Order;
import by.htp.login.beans.User;
import by.htp.login.service.OrderService;
import by.htp.login.service.impl.OrderServiceImpl;

public class SwitchCabinetActionImpl implements BaseAction{
	OrderService os = new OrderServiceImpl();

	@Override
	public String act(HttpServletRequest request) throws IOException, ParseException {
		
		User user = ActionHelper.getInstance().validateUser(request);
		if (user!=null) {
			
			request.setAttribute("name", user.getAbonent().getName());
			request.setAttribute("lastname", user.getAbonent().getLastname());
			request.setAttribute("surname", user.getAbonent().getSurname());
			request.setAttribute("birthDate", user.getAbonent().getBirthDate());
			request.setAttribute("number", user.getAbonent().getNumber());
			request.setAttribute("e_mail", user.getAbonent().getEMail());
			List<Order> list1 = os.userOutadetList(user.getAbonent().getId());
			request.setAttribute("list1", list1);
			List<Order> list2 = os.userInList(user.getAbonent().getId());
			request.setAttribute("list2", list2);
			List<Order> list3 = os.userOrdersList(user.getAbonent().getId());
			request.setAttribute("list3", list3);
			return PAGE_CABINET;
		} else {
			request.setAttribute("errorMsg", MSG_ERROR_LOGIN);
			return PAGE_ERROR;
		}
	}

}
