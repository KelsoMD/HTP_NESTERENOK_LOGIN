package by.htp.login.beans;

import java.util.Date;

public class Abonent extends Entity{
	
	private String name;
	private String surName;
	private Date registrationDate;
	
	public Abonent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Abonent(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public Abonent(int id, String name, String surName, Date registrationDate) {
		super(id);
		this.name = name;
		this.surName = surName;
		this.registrationDate = registrationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		Abonent other = (Abonent) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Abonent [name=" + name + ", surName=" + surName + ", registrationDate=" + registrationDate + "]";
	}
	
	

}
