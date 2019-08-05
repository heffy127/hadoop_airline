package com.park.airline5;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int date;
	private int flight;
	final int FLIGHT = 0;
	
	public AirlineParser() {
		super();
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		date = Integer.parseInt(airData[2]);
		flight = Integer.parseInt(airData[21]);
	}

	public int getDate() {
		return date;
	}

	public int getFlight() {
		return flight;
	}
	
}
