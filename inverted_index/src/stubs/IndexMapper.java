package stubs;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;

public class IndexMapper extends Mapper<Text, Text, Text, Text> {

  @Override
  public void map(Text key, Text value, Context context) throws IOException,
      InterruptedException {
	  	FileSplit fs = (FileSplit) context.getInputSplit();
	  	String fileName = fs.getPath().getName();
	  	String wordIndex = fileName + "@" + key.toString();
	  	String lowerCaseLine = value.toString().toLowerCase();
	  	for (String word : lowerCaseLine.split("\\W+")){
	  		if (word.length() >0) {
	  			context.write(new Text(word), new Text(wordIndex));
	  		}
	  	}
    /*
     * TODO implement
     */
    
  }
}