package com.park.airline10;


import org.apache.hadoop.io.Text;

public class AirlineParser {

   private int year;
   private int month;
   private int day;
   private int dayOfWeek;
   private int cancelled;
   private int arrDelay;
   private int distance;
   
   private String CarrierDelay;
   private String UniqueCarrier;
   public int getDepDelay() {
      return depDelay;
   }

   private int depDelay;

   final int NONDELAY = 0;// 상수화

   private int getDigitFromStr(String str, int defaultDigit) {
      if ("NA".equalsIgnoreCase(str)) {
         return defaultDigit;
      } else {
         return Integer.parseInt(str);
      }
   }

   public AirlineParser() {}

   public AirlineParser(Text value) {
      String[] airData = value.toString().split(",");

      distance = Integer.parseInt(airData[18]);
      

   }

   public int getDistance() {
	return distance;
   }

   public int getYear() {
      return year;
   }

   public int getMonth() {
      return month;
   }

   public int getDay() {
      return day;
   }

   public int getDayOfWeek() {
      return dayOfWeek;
   }

   public int getCancel() {
      return cancelled;
   }

   public int getArrDelay() {
      return arrDelay;
   }

   public String getCarrierDelay() {
      return CarrierDelay;
   }

   public String getUniqueCarrier() {
      return UniqueCarrier;
   }

}