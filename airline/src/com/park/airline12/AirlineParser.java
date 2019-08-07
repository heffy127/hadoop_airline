package com.park.airline12;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int realTime;
	private int expectTime;
	private int cancelled;
	private String UniqueCarrier;
	private String TailNum;
	private String planeName1;
	private String planeName2;
	private String planeNum;
	private int distance;
	private int Month;
	private int WeatherDelay;

	final int CANCELLED = 1;
	final int NONAIRFLIGHT = 0;
	final static int SUSPENSIONOFAIRLINNE = -1;
	final static int NONDELAY = 0;
	final static int NOFLIGHT = -1;

	public AirlineParser() {
	}

	private int getDigitFromStr(String str, int defaultDigit) {
		if ("NA".equalsIgnoreCase(str))
			return defaultDigit;
		// else else가 없어도 위에 if에 해당하면 return하며 종료되기 때문에
		return Integer.parseInt(str);
	}

	public AirlineParser(Text value) {
		String[] airData = value.toString().split(",");

		planeName1 = airData[8];
		planeName2 = airData[10];
		planeNum = airData[9];
		realTime = getDigitFromStr(airData[11], NOFLIGHT);
		expectTime = getDigitFromStr(airData[12], NOFLIGHT);

	}

	
	
	public String getPlaneName1() {
		return planeName1;
	}

	public String getPlaneName2() {
		return planeName2;
	}

	public String getPlaneNum() {
		return planeNum;
	}

	public int getMonth() {
		return Month;
	}

	public int getWeatherDelay() {
		return WeatherDelay;
	}

	public int getDistance() {
		return distance;
	}

	public String getUniqueCarrier() {
		return UniqueCarrier;
	}

	public int getRealTime() {
		return realTime;
	}

	public int getExpectTime() {
		return expectTime;
	}

	public int getCancelled() {
		return cancelled;
	}
}