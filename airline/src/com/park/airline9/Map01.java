package com.park.airline9;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException {
		AirlineParser ap = new AirlineParser(value);

		if (ap.getWeatherDelay() > 0) {
			output.getCounter(Month.values()[ap.getMonth() - 1]).increment(ap.getWeatherDelay());
		}

		output.write(new Text("Bad Weather"), new IntWritable(ap.getDistance()));

	}
}
