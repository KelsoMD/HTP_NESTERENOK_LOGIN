package by.htp.login.beans;

import java.util.Date;

public class Author extends Entity {

	private String name;
	private String surName;
	private Date birthDate;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Author(int id, String name, String surName, Date birthDate) {
		super(id);
		this.name = name;
		this.surName = surName;
		this.birthDate = birthDate;
	}
	
	public Author(int id, String name, String surName) {
		super(id);
		this.name = name;
		this.surName = surName;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Author other = (Author) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "Author [name=" + name + ", surName=" + surName + ", birthDate=" + birthDate + "]";
	}

}
