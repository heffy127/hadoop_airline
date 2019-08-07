package com.park.airline14;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce01 extends Reducer<PartSort, IntWritable, Text, IntWritable>{

	@Override
	public void reduce(PartSort key, Iterable<IntWritable> values, Context ctx) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int cnt = 0;
		
		for(IntWritable v : values)
			cnt += v.get();
		
		ctx.write(new Text(key.getYear() + "." + key.getMonth()), new IntWritable(cnt));
	}
	
}
