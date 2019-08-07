package com.park.test;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private String uniqueCarrier_jyp;
	private String tailNum_jyp;
	private int carrierDelay_jyp;
	public final int NODELAY_jyp = 0;
	
	public AirlineParser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int noNa(String data, int NODELAY) {
		if("NA".equalsIgnoreCase(data)) {
			return NODELAY;
		} else {
			return Integer.parseInt(data);
		}
	}
	
	public AirlineParser(Text value) {
		String[] airData_jyp = value.toString().split(",");
		uniqueCarrier_jyp = airData_jyp[8];
		tailNum_jyp = airData_jyp[10];
		carrierDelay_jyp = noNa(airData_jyp[24], NODELAY_jyp);
	}

	public String getUniqueCarrier_jyp() {
		return uniqueCarrier_jyp;
	}

	public void setUniqueCarrier_jyp(String uniqueCarrier_jyp) {
		this.uniqueCarrier_jyp = uniqueCarrier_jyp;
	}

	public String getTailNum_jyp() {
		return tailNum_jyp;
	}

	public void setTailNum_jyp(String tailNum_jyp) {
		this.tailNum_jyp = tailNum_jyp;
	}

	public int getCarrierDelay_jyp() {
		return carrierDelay_jyp;
	}

	public void setCarrierDelay_jyp(int carrierDelay_jyp) {
		this.carrierDelay_jyp = carrierDelay_jyp;
	}


	
}
