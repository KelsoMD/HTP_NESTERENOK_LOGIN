package by.htp.login.beans;

import java.io.Serializable;

public class User extends Entity implements Serializable{
	
	private static final long serialVersionUID = 4908874150936828921L;
	private String login;
	private String password;
	private int role;
	private Abonent abonent;

	public User() {
		super();
	}
	
	

	public User(int id, String login, String password, int role) {
		super(id);
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public User(int id, String login, String password, int role, Abonent abonent) {
		super(id);
		this.login = login;
		this.password = password;
		this.role = role;
		this.abonent = abonent;
	}
	
	public User(String login, String password, int role) {
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}



	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public int getRole() {
		return role;
	}



	public void setRole(int role) {
		this.role = role;
	}



	public Abonent getAbonent() {
		return abonent;
	}



	public void setAbonent(Abonent abonent) {
		this.abonent = abonent;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", role=" + role + "]";
	}	
}
