package com.park.quiz;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce01 extends MapReduceBase implements Reducer<Text, LongWritable, Text, LongWritable>{

	@Override
	public void reduce(Text key, Iterator<LongWritable> values, OutputCollector<Text, LongWritable> output, Reporter arg3)
			throws IOException {
		// TODO Auto-generated method stub
		output.collect(key, values.next());
	}
	
	
}
