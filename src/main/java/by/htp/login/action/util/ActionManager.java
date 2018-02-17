package by.htp.login.action.util;

import by.htp.login.action.BaseAction;
import by.htp.login.action.impl.AddBookActionimpl;
import by.htp.login.action.impl.CheckLoginActionimpl;
import by.htp.login.action.impl.CreateUserActionImpl;
import by.htp.login.action.impl.FindBookActionImpl;
import by.htp.login.action.impl.ViewBookListActionImpl;

public class ActionManager {

	
	public static BaseAction defineAction(String action) {
		BaseAction act = null;
		switch (action) {
		case "check_login":
			act = new CheckLoginActionimpl();
			break;
		case "Registration":
			act = new CreateUserActionImpl();
			break;
		case "find_book":
			act = new FindBookActionImpl();
			break;
		case "view_books":
			act = new ViewBookListActionImpl();
			break;
		case "add_book":
			act = new AddBookActionimpl();
			break;
		}
		return act;
	}
}
