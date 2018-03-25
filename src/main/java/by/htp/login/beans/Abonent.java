package by.htp.login.beans;

import java.io.Serializable;
import java.util.Date;

public class Abonent extends Entity implements Serializable{
	
	private static final long serialVersionUID = -4818924727442672151L;
	private String name;
	private String lastname;
	private String surname;
	private Date birthDate;
	private String number;
	private String eMail;
	private Date registrationDate;
	
	public Abonent() {
	}
	public Abonent(int id) {
		super(id);

	}
	public Abonent(int id, String name, String lastname, String surname, Date birthDate, String number, String eMail,
			Date registrationDate) {
		super(id);
		this.name = name;
		this.lastname = lastname;
		this.surname = surname;
		this.birthDate = birthDate;
		this.number = number;
		this.eMail = eMail;
		this.registrationDate = registrationDate;
	}
	
	public Abonent(String name, String lastname, String surname, Date birthDate, String number, String eMail,
			Date registrationDate) {
		this.name = name;
		this.lastname = lastname;
		this.surname = surname;
		this.birthDate = birthDate;
		this.number = number;
		this.eMail = eMail;
		this.registrationDate = registrationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String eMail) {
		this.eMail = eMail;
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
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Abonent [name=" + name + ", lastname=" + lastname + ", surname=" + surname + ", birthDate=" + birthDate
				+ ", number=" + number + ", e_mail=" + eMail + ", registrationDate=" + registrationDate + "]";
	}
	
	
	
	
	
	

}
