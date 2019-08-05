package com.park.airline8;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, IntWritable>{
   private String opt; // -D opt=dep(출발지연시간)
   
   //클래스 생성시 즉 MAP01생성시 초기화, 생성자 이후 동작됨
   @Override
   protected void setup(Context ctx) {
      opt = ctx.getConfiguration().get("opt");
   }
   @Override
   public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException {
      AirlineParser ap = new AirlineParser(value);
      
      int delay=0;
      if("dep".equalsIgnoreCase(opt)) delay = ap.getDepDelay();
      else if("arr".equalsIgnoreCase(opt)) delay = ap.getArrDelay();
      
      if(delay>0) {
         output.write(
               new Text(ap.getUniqueCarrier()), 
               new IntWritable(1)
               );
      }
   }

}