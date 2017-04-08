package stubs;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.io.compress.SnappyCodec;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class CreateSequenceFileParameter extends Configured implements Tool {


  @Override
  public int run(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.printf("Usage: CreateSequenceFileParameter [-D mapred.output.compress={true, false}] <input dir> <output dir>\n");
      return -1;
    }
    Configuration conf = getConf();
    boolean compressed =  conf.getBoolean("mapred.output.compress", true);
    Job job = new Job(getConf());
    job.setJarByClass(CreateSequenceFileParameter.class);
    job.setJobName("Create Sequence File Parameter");

    
    /*
     * TODO implement
     */
    job.setOutputFormatClass(SequenceFileOutputFormat.class);
    job.setNumReduceTasks(0);
    
    FileInputFormat.setInputPaths(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    if (compressed){
    	FileOutputFormat.setCompressOutput(job,true);
    	FileOutputFormat.setOutputCompressorClass(job,SnappyCodec.class);
    
    	SequenceFileOutputFormat.setOutputCompressionType(job,CompressionType.BLOCK);
    }
    
    boolean success = job.waitForCompletion(true);
    return success ? 0 : 1;
  }

  public static void main(String[] args) throws Exception {
    int exitCode = ToolRunner.run(new Configuration(), new CreateSequenceFileParameter(), args);
    System.exit(exitCode);
  }
}
