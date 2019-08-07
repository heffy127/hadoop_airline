package com.park.test;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, Context output)
			throws IOException, InterruptedException {
		AirlineParser ap_jyp = new AirlineParser(value);
		
			output.write(new Text(ap_jyp.getUniqueCarrier_jyp() + "_" + ap_jyp.getTailNum_jyp()),
					new IntWritable(ap_jyp.getCarrierDelay_jyp()));

	}

	
}
