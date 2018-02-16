package by.htp.login.dao;

public interface UserDao extends BaseDao{
	
	public boolean checkLogin(String login);
	public boolean checkPassword(String user_login, String user_password);

}
