package com.park.airline14;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class QuizMain extends Configured implements Tool{
	public static void main(String[] args) throws Exception{
		System.exit(ToolRunner.run(new QuizMain(), args));
	}

	@Override
	public int run(String[] arg0) throws Exception {
		
		Job job = Job.getInstance(getConf(), "Nonsort");

		// 입출력 경로 지정
		FileInputFormat.addInputPath(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		
		job.setJarByClass(QuizMain.class);
//		job.setSortComparatorClass(PartSortComparator.class);
		job.setGroupingComparatorClass(PartSortComparator.class);
		job.setPartitionerClass(Partitioner01.class);
		
		// Map Reduce
		job.setMapperClass(Map01.class);
		job.setReducerClass(Reduce01.class);

		// 입출력 형식 지정
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		job.setMapOutputKeyClass(PartSort.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		// 출력 형식 지정
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.waitForCompletion(true);
		
		return 0;
	}
	
	
}
