package com.park.airline8;

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

public class ValueMain extends Configured implements Tool{

   public static void main(String[] args) throws Exception {
      System.exit(ToolRunner.run(new ValueMain(), args));
   }

   @Override
   public int run(String[] arg0) throws Exception {
      Job conf = Job.getInstance(getConf(), "ArrDep");
      
      // conf.setJobName("value test");
      
      //출력형식지정
      conf.setOutputKeyClass(Text.class);
      conf.setOutputValueClass(IntWritable.class);

      // Map reduce
      conf.setMapperClass(Map01.class);
      conf.setReducerClass(Reduce01.class);
      
      conf.setInputFormatClass(TextInputFormat.class);
      conf.setOutputFormatClass(TextOutputFormat.class);
      
      FileInputFormat.setInputPaths(conf, new Path(arg0[0]));
      FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
      
      //JobClient.runJob(conf);
      conf.waitForCompletion(true);
      return 0;
   }
}

