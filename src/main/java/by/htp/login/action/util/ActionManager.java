package by.htp.login.action.util;

import by.htp.login.action.BaseAction;
import by.htp.login.action.impl.CheckLoginActionimpl;
import by.htp.login.action.impl.CreateUserActionImpl;

public class ActionManager {

	
	public static BaseAction defineAction(String action) {
		BaseAction act = null;
		switch (action) {
		case "CheckLogin":
			act = new CheckLoginActionimpl();
			break;
		case "Registration":
			act = new CreateUserActionImpl();
			break;
		}
		return act;
	}
}
