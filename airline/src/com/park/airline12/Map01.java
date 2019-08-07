package com.park.airline12;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map01 extends Mapper<LongWritable, Text, Text, Text> {

	// multiple output 실습

	/*
	 * @Override public void map(Text key, Text value, Context output){ override를 쓰는
	 * 이유 : 재정의 시 오타를 방지하기 위해서라도 사용, override없이 오타가 발생하면 내부 메소드를 새로 만든 것과 같음(위의
	 * Mapper의 메소드 재정의가 아니여서 오류발생위험) }
	 */
	@Override
	public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException {
		AirlineParser ap = new AirlineParser(value);

		if (ap.getRealTime() > 0 && ap.getExpectTime() > 0) {
			output.write(new Text("a"), new Text(ap.getPlaneName1() + "_" + ap.getPlaneName2() + ":" + ap.getPlaneNum() +  ":" + String.valueOf(ap.getRealTime())));
			output.write(new Text("b"), new Text(ap.getPlaneName1() + "_" + ap.getPlaneName2() + ":" + ap.getPlaneNum() + ":" + String.valueOf(ap.getExpectTime())));
		}

		// 실제 넘어가는 데이터
		// dep:uc, arr:uc
	}
}
