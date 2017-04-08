package stubs;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.SequenceFile.Writer;


public class SequenceFileWriter {

  public static void main(String[] args) throws IllegalArgumentException, IOException {

    Configuration config = new Configuration();
    Writer writer = SequenceFile.createWriter(config, Writer.file(new Path(args[1])), Writer.keyClass(Text.class), Writer.valueClass(Text.class));
    for (String line: FileUtils.readLines(new File(args[0]))){
    	int i = line.indexOf(' ');
   	  	String ip = line.substring(0, i);
   	  	writer.append(new Text(ip), new Text(line));
    }
    writer.close();
    
  }
}
