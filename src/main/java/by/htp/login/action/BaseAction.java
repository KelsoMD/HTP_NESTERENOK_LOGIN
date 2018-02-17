package by.htp.login.action;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.controller.RegistrationException;

public interface BaseAction {

	String act(HttpServletRequest request) throws IOException, NumberFormatException, ParseException; 
	
	
}
