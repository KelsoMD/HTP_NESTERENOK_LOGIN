package by.htp.login.dao;

import by.htp.login.beans.User;

public interface UserDao extends BaseDao<User> {

	public boolean checkLogin(String login);

	public User checkPassword(String login, String password);

	public User readUser(User user);


}
