package com.park.airline13;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String year;
	private int month;
	private int cancelled;
	public int NONCANCELLED = 0;
	
	public AirlineParser() {}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		year = airData[0];
		month = Integer.parseInt(airData[1]);
		cancelled = Integer.parseInt(airData[21]);
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getCancelled() {
		return cancelled;
	}

	public void setCancelled(int cancelled) {
		this.cancelled = cancelled;
	}

	
}
