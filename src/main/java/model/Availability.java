package model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Availability {
	private int availability_List;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date;

	public int getAvailability_List() {
		return availability_List;
	}

	public void setAvailability_List(int availability_List) {
		this.availability_List = availability_List;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
