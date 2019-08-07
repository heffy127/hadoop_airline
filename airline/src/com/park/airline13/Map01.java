package com.park.airline13;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, PartSort, IntWritable>{

	@Override
	public void map(LongWritable key, Text value, Context ctx) throws IOException, InterruptedException {
		
		PartSort data = new PartSort(value);
		
		if(data.getCancelled() == data.NONCANCELLED)
			ctx.write(data, new IntWritable(1));
	}

}
