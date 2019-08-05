package com.park.airline5;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class Map01 extends MapReduceBase 
implements Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		AirlineParser ap = new AirlineParser(value);
		String mydate;
		if(0 < ap.getDate() && ap.getDate() < 11) {
			mydate = "01 ~ 10";
			
		} else if (10 < ap.getDate() && ap.getDate() < 21) {
			mydate = "11 ~ 20";
			
		} else {
			mydate = "21 ~ 31";
			
		}
		output.collect(new Text(mydate), new IntWritable(ap.getFlight()));	
		
	}

}
