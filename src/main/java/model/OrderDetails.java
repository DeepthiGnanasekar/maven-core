package model;

import java.time.LocalDate;

public class OrderDetails {
	
	private int id;
	private LocalDate date;
	private  int quantyList;
	private String status;
    private long number;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getQuantyList() {
		return quantyList;
	}

	public  int setQuantyList(int quantyList) {
		return this.quantyList = quantyList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number2) {
		this.number = number2;
	}

}
