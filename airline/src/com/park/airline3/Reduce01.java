package com.park.airline3;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce01 extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{

	@Override
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter arg3)
			throws IOException {
		// TODO Auto-generated method stub
		int cnt = 0;
		
		while(values.hasNext()) {
			cnt += values.next().get();
		}
		
		
		
		String day = key.toString();
		switch (Integer.parseInt(day)) {
		case 1:
			day = "월 요 일";
			break;
		case 2:
			day = "화 요 일";
			break;
		case 3:
			day = "수 요 일";
			break;
		case 4:
			day = "목 요 일";
			break;
		case 5:
			day = "금 요 일";
			break;
		case 6:
			day = "토 요 일";
			break;
		default:
			day = "일 요 일";
			break;
		}
		
		
		output.collect(new Text(day), new IntWritable(cnt));
	}
	
}
