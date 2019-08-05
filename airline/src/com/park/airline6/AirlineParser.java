package com.park.airline6;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String unique;
	private int delay;
	
	public AirlineParser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		if(!airData[24].equalsIgnoreCase("NA")) {
			unique = airData[8];
			delay = Integer.parseInt(airData[24]);
		}
	}
	public String getUnique() {
		return unique;
	}
	public int getDelay() {
		return delay;
	}
}
