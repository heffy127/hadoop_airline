package com.park.airline7;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class Reduce01 extends MapReduceBase implements Reducer<Text, IntWritable, Text, Text>{

	@Override
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, Text> output, Reporter arg3)
			throws IOException {	
		
		int delay = 0; // 지연시간
		int delayAll = 0; // 총 지연시간
		int allCnt = 0; // 모든 운항횟수
		int delayCnt = 0; // 지연 운항횟수
		double delayAvg = 0; // 평균 도착 지연 시간
		double delayRate = 0; // 지연율
		
		while(values.hasNext()) {
			delay = values.next().get();
			allCnt++;
			
			if(delay > 0) {
				delayCnt++;
				delayAll += delay;
			}
		}
		
		delayAvg = (double)delayAll / delayCnt; // 평균 도착 지연 시간
		if(Double.isNaN(delayAvg)) {
			delayAvg = 0;
		}
		
		delayRate = ((double)delayCnt / allCnt) * 100; // 지연율
		if(Double.isNaN(delayRate)) {
			delayRate = 0;
		}
		
		String sentence = String.format("sum : %d, avg : %.2f, delayrate : %.2f", delayAll, delayAvg, delayRate);
		output.collect(key, new Text(sentence));
	}

}
