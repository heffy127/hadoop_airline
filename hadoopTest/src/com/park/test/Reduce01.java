package com.park.test;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce01 extends Reducer<Text, IntWritable, Text, Text>{

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context output) throws IOException, InterruptedException {
		
		int allCnt = 0; // 전체 운항 횟수
		int delayCnt = 0; // 지연 횟수
		double delayRate = 0; // 지연율
		
		for(IntWritable n : values) {
			int delayTime = n.get();
			++allCnt;
			
			if(delayTime > 0) {
				++delayCnt;
			}
		}
		
		delayRate = (double)delayCnt / allCnt;
		String rateText = String.format("%.8f", delayRate);
		output.write(key, new Text(rateText));
	}

	
}
