package com.jin.quiz04;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	private int dayOfWeek;
	
	public AirlineParser() {	}
	public AirlineParser(Text value) {	
		String [] airData = value.toString().split(",");
		year = Integer.parseInt(airData[0]);
		month = Integer.parseInt(airData[1]);
		dayOfWeek = Integer.parseInt(airData[3]);
	}
	
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
}
