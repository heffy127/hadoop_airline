package com.park.airline12;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class Reduce01 extends Reducer<Text, Text, Text, Text> {

	private MultipleOutputs<Text, Text> multi;

	@Override
	protected void setup(Context ctx) {
		multi = new MultipleOutputs<Text, Text>(ctx);
	}

	public void reduce(Text key, Iterable<Text> values, Context output) throws IOException, InterruptedException {
		int max = 0;
		int time = 0;
		String name = "";
		String[] cmd = null;
		/*
		 * 하위 내용 함수화 작업(multiCount) int cnt=0;
		 * 
		 * for(IntWritable v : values) cnt += v.get();
		 */
		/*
		 * if("dep".equalsIgnoreCase(cmd[0])) multiCount("dep", cmd[1], values);
		 * if("arr".equalsIgnoreCase(cmd[0])) multiCount("arr", cmd[1], values);
		 */

		// 위에 것과 같은 코드
		// for (Text t : values) {
		//
		// }
		for (Text t : values) {
				cmd = t.toString().split(":");
				time = Integer.parseInt(cmd[2]);
				if (max < time) {
					max = time;
					name = cmd[0];
				}
		}

		multi.write(key.toString(), name, max);
	}

	@Override // setup과 달리정리해주는 코드
	protected void cleanup(Context ctx) throws IOException, InterruptedException {
		multi.close();
	}

}