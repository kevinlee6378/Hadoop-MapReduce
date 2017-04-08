package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCoMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
	  String lowercaseLine = value.toString().toLowerCase();
	  String firstWord = "";
	  for (String s :lowercaseLine.split("\\W+")){
		  if (s.length() > 0){
			  if (firstWord != ""){
				  String pair = firstWord + ", " + s;
				  context.write(new Text(pair), new IntWritable(1));
			  }
			  firstWord = s;
		  }
	  }
    /*
     * TODO implement
     */
    
  }
}
