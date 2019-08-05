package com.park.airline3;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String day;
	
	public AirlineParser() { }
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		day = airData[3];
	}
	public String getDay() {
		return day;
	}

}
