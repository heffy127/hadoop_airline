package com.park.airline7;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String tailNum;
	private int delayTime;
	
	
	
	public AirlineParser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");
		tailNum = airData[10];
		if(!airData[24].equalsIgnoreCase("NA")) {
			delayTime = Integer.parseInt(airData[24]);
		}else {
			delayTime = 0;
		}
	}
	
	
	public String getTailNum() {
		return tailNum;
	}
	public int getDelayTime() {
		return delayTime;
	}
	
	
}
