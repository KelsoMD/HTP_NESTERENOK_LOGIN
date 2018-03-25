package by.htp.login.action;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

public interface BaseAction {

	String act(HttpServletRequest request) throws IOException, ParseException; 
	
	
}
