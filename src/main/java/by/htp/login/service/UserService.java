package by.htp.login.service;

import by.htp.login.beans.User;

public interface UserService {
	
	public User authorizeUser(String login, String password);
	public boolean checkLogin(String login);
	public User checkPassword(String login, String password);
	public void createUser(User user);

}
