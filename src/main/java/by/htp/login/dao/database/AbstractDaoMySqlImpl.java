package by.htp.login.dao.database;

import by.htp.login.dao.database.util.WrapConnectionMySql;

public class AbstractDaoMySqlImpl {

	protected static final String SQL_USER_ROLE = "role";
	protected static final String SQL_USER_PASS = "password";
	protected static final String SQL_USER_LOGIN = "login";
	protected static final String SQL_USER_ID = "user_id";
	protected static final String SQL_USER_ABONENT = "abonent";
	
	protected static final String SQL_BOOK_AUTHOR = "author";
	protected static final String SQL_BOOK_ID = "book_id";
	protected static final String SQL_BOOK_TITLE = "title";
	protected static final String SQL_BOOK_PUBLISH_YEAR = "publish_year";
	
	protected static final String SQL_AUTHOR_ID = "author_id";
	protected static final String SQL_AUTHOR_NAME = "name";
	protected static final String SQL_AUTHOR_SURNAME = "surname";
	protected static final String SQL_AUTHOR_BIRTH_DATE = "birth_date";
	
	protected static final String SQL_ABONENT_ID = "abonent_id";
	protected static final String SQL_ABONENT_NAME = "name";
	protected static final String SQL_ABONENT_LASTNAME = "lastname";
	protected static final String SQL_ABONENT_NUMBER = "number";
	protected static final String SQL_ABONENT_EMAIL = "e_mail";
	protected static final String SQL_ABONENT_REG_DATE = "registration_date";
	
	protected static final String SQL_ORDER_ID = "order_id";
	protected static final String SQL_ORDER_ORDER_DATE = "order_date";
	protected static final String SQL_ORDER_RETURNTO_DATE = "return_to_date";
	protected static final String SQL_ORDER_RETURN_DATE = "return_date";
	protected static final String SQL_ORDER_RETURNED = "returned";
	protected static final String SQL_ORDER_APROOVED = "aprooved";
	protected static final String SQL_ORDER_OUTDATED = "outdated";
	protected static final String SQL_ORDER_BOOK = "book";
	
	
	
	WrapConnectionMySql wcn;
	
	public AbstractDaoMySqlImpl() {
		wcn = new WrapConnectionMySql();
	}
	
}
