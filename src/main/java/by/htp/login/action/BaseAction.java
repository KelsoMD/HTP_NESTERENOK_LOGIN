package by.htp.login.action;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.controller.RegistrationException;

public interface BaseAction {

	String act(HttpServletRequest request); 
	
	
}
