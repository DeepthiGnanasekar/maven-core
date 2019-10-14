package model;

import java.time.LocalDate;

public class ReserveDetails {
	private int id;
	private LocalDate date;
	private int reservedList;
	private int reservedOrder;
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
	public  int getReservedList() {
		return reservedList;
	}

	public void setReservedList(int reservedList) {
		this.reservedList = reservedList;
	}

	public double getReservedOrder() {
		return reservedOrder;
	}

	public void setReservedOrder(int reservedOrder) {
		this.reservedOrder = reservedOrder;
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
