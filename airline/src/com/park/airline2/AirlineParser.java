package com.park.airline2;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private String month;
	
	public AirlineParser() { }
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		year = Integer.parseInt(airData[0]);
		month = airData[1];
	}
	
	
	public int getYear() {
		return year;
	}
	public String getMonth() {
		return month;
	}
	
}
