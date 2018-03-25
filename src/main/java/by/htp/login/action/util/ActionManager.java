package by.htp.login.action.util;

import static by.htp.login.action.util.ManagerConstantPool.REQUEST_LOGOUT;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_ADD_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_ADD_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_CHK_LOGIN;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_CONFIRM_ORDER;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_CONFIRM_RETURN;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_CREATE_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_CREATE_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_CREATE_USER_CARD;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_DELETE_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_DELETE_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_EDIT_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_EDIT_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_FIND_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_FIND_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_FIND_BOOK_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_MAIL;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_MAIN_PAGE;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_ORDER_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_REGISTRATION;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_SAVE_ABONENT;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_SAVE_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_SAVE_BOOK;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_START_EDIT;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_SWITCH_FIND_AUTHOR;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_SWITCH_FIND_TITLE;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_SWITCH_REG;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_UPDATE_COUNT;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_VIEW_AUTHORS;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_VIEW_AUTHORS_SELECT;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_VIEW_BOOKS;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_VIEW_ORDERS;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_VIEW_ORDERS_NEW;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_VIEW_ORDERS_RETURN;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_PARAM_VIEW_OUTDATED;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_SWITCH_CABINET;
import static by.htp.login.action.util.ManagerConstantPool.REQUEST_SWITCH_LOGIN;

import by.htp.login.action.BaseAction;
import by.htp.login.action.impl.CheckLoginActionimpl;
import by.htp.login.action.impl.ConfirmOrder;
import by.htp.login.action.impl.ConfirmRetunActionImpl;
import by.htp.login.action.impl.CreateAuthorActionImpl;
import by.htp.login.action.impl.CreateBookActionImpl;
import by.htp.login.action.impl.CreateUserActionImpl;
import by.htp.login.action.impl.CreateUserAndCardActionImpl;
import by.htp.login.action.impl.DefaultActionImpl;
import by.htp.login.action.impl.DeleteAuthorActionImpl;
import by.htp.login.action.impl.DeleteBookActionImpl;
import by.htp.login.action.impl.EditAuthorActionImpl;
import by.htp.login.action.impl.EditBookActionImpl;
import by.htp.login.action.impl.FindAuthorActionImpl;
import by.htp.login.action.impl.FindBookActionImpl;
import by.htp.login.action.impl.FindBookByAuthorActionImpl;
import by.htp.login.action.impl.LogoutActionImpl;
import by.htp.login.action.impl.MailActionImpl;
import by.htp.login.action.impl.MainPage;
import by.htp.login.action.impl.OrderBookSwitchActionImpl;
import by.htp.login.action.impl.SaveAbonentActionImpl;
import by.htp.login.action.impl.SaveAuthorActionImpl;
import by.htp.login.action.impl.SaveBookActionImpl;
import by.htp.login.action.impl.StartEditActionImpl;
import by.htp.login.action.impl.SwitchAddAuthor;
import by.htp.login.action.impl.SwitchAddBookActionImpl;
import by.htp.login.action.impl.SwitchCabinetActionImpl;
import by.htp.login.action.impl.SwitchLoginActionImpl;
import by.htp.login.action.impl.SwitchRegActionImpl;
import by.htp.login.action.impl.SwitchSearchAuthorActionimpl;
import by.htp.login.action.impl.SwitchSearchTitleActionImpl;
import by.htp.login.action.impl.UpdateCountActionImpl;
import by.htp.login.action.impl.ViewAuhtorsActionImpl;
import by.htp.login.action.impl.ViewBookListActionImpl;
import by.htp.login.action.impl.ViewNewOrdersActionImpl;
import by.htp.login.action.impl.ViewOrdersActionImpl;
import by.htp.login.action.impl.ViewOrdersToReturnActionImpl;
import by.htp.login.action.impl.ViewOutdatedList;

public class ActionManager {

	private ActionManager() {

	}

	public static BaseAction defineAction(String action) {
		BaseAction act = null;
		switch (action) {
		case REQUEST_PARAM_CHK_LOGIN:
			act = new CheckLoginActionimpl();
			break;
		case REQUEST_PARAM_REGISTRATION:
			act = new CreateUserActionImpl();
			break;
		case REQUEST_PARAM_FIND_BOOK:
			act = new FindBookActionImpl();
			break;
		case REQUEST_PARAM_VIEW_BOOKS:
			act = new ViewBookListActionImpl();
			break;
		case REQUEST_PARAM_ADD_BOOK:
			act = new SwitchAddBookActionImpl();
			break;
		case REQUEST_PARAM_VIEW_AUTHORS_SELECT:
			act = new ViewAuhtorsActionImpl();
			break;
		case REQUEST_PARAM_DELETE_BOOK:
			act = new DeleteBookActionImpl();
			break;
		case REQUEST_PARAM_EDIT_BOOK:
			act = new EditBookActionImpl();
			break;
		case REQUEST_PARAM_SAVE_BOOK:
			act = new SaveBookActionImpl();
			break;
		case REQUEST_PARAM_CREATE_BOOK:
			act = new CreateBookActionImpl();
			break;
		case REQUEST_PARAM_MAIN_PAGE:
			act = new MainPage();
			break;
		case REQUEST_PARAM_VIEW_AUTHORS:
			act = new ViewAuhtorsActionImpl();
			break;
		case REQUEST_PARAM_ADD_AUTHOR:
			act = new SwitchAddAuthor();
			break;
		case REQUEST_PARAM_CREATE_AUTHOR:
			act = new CreateAuthorActionImpl();
			break;
		case REQUEST_PARAM_DELETE_AUTHOR:
			act = new DeleteAuthorActionImpl();
			break;
		case REQUEST_PARAM_SAVE_AUTHOR:
			act = new SaveAuthorActionImpl();
			break;
		case REQUEST_PARAM_EDIT_AUTHOR:
			act = new EditAuthorActionImpl();
			break;
		case REQUEST_PARAM_SWITCH_REG:
			act = new SwitchRegActionImpl();
			break;
		case REQUEST_PARAM_CREATE_USER_CARD:
			act = new CreateUserAndCardActionImpl();
			break;
		case REQUEST_PARAM_SWITCH_FIND_AUTHOR:
			act = new SwitchSearchAuthorActionimpl();
			break;
		case REQUEST_PARAM_SWITCH_FIND_TITLE:
			act = new SwitchSearchTitleActionImpl();
			break;
		case REQUEST_PARAM_FIND_BOOK_AUTHOR:
			act = new FindBookByAuthorActionImpl();
			break;
		case REQUEST_PARAM_ORDER_BOOK:
			act = new OrderBookSwitchActionImpl();
			break;
		case REQUEST_SWITCH_LOGIN:
			act = new SwitchLoginActionImpl();
			break;
		case REQUEST_LOGOUT:
			act = new LogoutActionImpl();
			break;
		case REQUEST_SWITCH_CABINET:
			act = new SwitchCabinetActionImpl();
			break;
		case REQUEST_PARAM_START_EDIT:
			act = new StartEditActionImpl();
			break;
		case REQUEST_PARAM_SAVE_ABONENT:
			act = new SaveAbonentActionImpl();
			break;
		case REQUEST_PARAM_VIEW_ORDERS_NEW:
			act = new ViewNewOrdersActionImpl();
			break;
		case REQUEST_PARAM_CONFIRM_ORDER:
			act = new ConfirmOrder();
			break;
		case REQUEST_PARAM_VIEW_ORDERS_RETURN:
			act = new ViewOrdersToReturnActionImpl();
			break;
		case REQUEST_PARAM_CONFIRM_RETURN:
			act = new ConfirmRetunActionImpl();
			break;
		case REQUEST_PARAM_VIEW_OUTDATED:
			act = new ViewOutdatedList();
			break;
		case REQUEST_PARAM_VIEW_ORDERS:
			act = new ViewOrdersActionImpl();
			break;
		case REQUEST_PARAM_MAIL:
			act = new MailActionImpl();
			break;
		case REQUEST_PARAM_UPDATE_COUNT:
			act = new UpdateCountActionImpl();
			break;
		case REQUEST_PARAM_FIND_AUTHOR:
			act = new FindAuthorActionImpl();
			break;
		default:
			act = new DefaultActionImpl();
		}
		return act;
	}
}
