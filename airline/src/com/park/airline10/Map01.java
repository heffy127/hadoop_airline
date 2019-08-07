package com.park.airline10;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, IntWritable>{
   
	@Override
	public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException {
		AirlineParser ap = new AirlineParser(value);
		
		if(ap.getDistance() > 0) {
			output.write(new Text("Distance All"), new IntWritable(ap.getDistance()));
			output.getCounter(DistanceCount.nonZeroCnt).increment(1);
		} else if(ap.getDistance() == 0) {
			output.getCounter(DistanceCount.zeroCnt).increment(1);
		}
	}
	
}