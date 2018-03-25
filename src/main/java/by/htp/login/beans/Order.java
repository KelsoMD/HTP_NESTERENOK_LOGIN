package by.htp.login.beans;

import java.util.Date;

public class Order extends Entity{
	
	private Book book;
	private Abonent abonent;
	private Date orderDate;
	private Date returnToDate;
	private Date returnDate;
	private boolean returned = false;
	private boolean outdated = false;
	private boolean aprooved = false;
	
	
	
	public Order() {
		super();
	}
	
	
	public Order(int id, Book book, Abonent abonent, Date orderDate, Date returnToDate, Date returnDate,
			boolean returned, boolean outdated, boolean aprooved) {
		super(id);
		this.book = book;
		this.abonent = abonent;
		this.orderDate = orderDate;
		this.returnToDate = returnToDate;
		this.returnDate = returnDate;
		this.returned = returned;
		this.outdated = outdated;
		this.aprooved = aprooved;
	}


	public Order(int id, Abonent abonent, Book book, Date orderDate) {
		super(id);
		this.abonent = abonent;
		this.book = book;
		this.orderDate = orderDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Abonent getAbonent() {
		return abonent;
	}
	public void setAbonent(Abonent abonent) {
		this.abonent = abonent;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getReturnToDate() {
		return returnToDate;
	}
	public void setReturnToDate(Date returnToDate) {
		this.returnToDate = returnToDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public boolean isReturned() {
		return returned;
	}
	public void setReturned(boolean returned) {
		this.returned = returned;
	}
	public boolean isOutdated() {
		return outdated;
	}
	public void setOutdated(boolean outdated) {
		this.outdated = outdated;
	}
	public boolean isAprooved() {
		return aprooved;
	}
	public void setAprooved(boolean aprooved) {
		this.aprooved = aprooved;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abonent == null) ? 0 : abonent.hashCode());
		result = prime * result + (aprooved ? 1231 : 1237);
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + (outdated ? 1231 : 1237);
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((returnToDate == null) ? 0 : returnToDate.hashCode());
		result = prime * result + (returned ? 1231 : 1237);
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
		Order other = (Order) obj;
		if (abonent == null) {
			if (other.abonent != null)
				return false;
		} else if (!abonent.equals(other.abonent))
			return false;
		if (aprooved != other.aprooved)
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (outdated != other.outdated)
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (returnToDate == null) {
			if (other.returnToDate != null)
				return false;
		} else if (!returnToDate.equals(other.returnToDate)) {
			return false;
		}
		if (returned != other.returned) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Order [book=" + book + ", abonent=" + abonent + ", orderDate=" + orderDate + ", returnToDate="
				+ returnToDate + ", returnDate=" + returnDate + ", returned=" + returned + ", outdated=" + outdated
				+ ", aprooved=" + aprooved + "]";
	}
	
	

}
