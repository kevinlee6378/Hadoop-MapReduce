package stubs;

import static org.junit.Assert.assertEquals;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.junit.Test;

public class SentimentPartitionTest {

	SentimentPartitioner spart;

	@Test
	public void testSentimentPartition() {

		spart=new SentimentPartitioner();
		spart.setConf(new Configuration());
		int result;
		result = spart.getPartition(new Text("love"), new IntWritable(1), 3);
		assertEquals(0, result);
		result = spart.getPartition(new Text("deadly"), new IntWritable(1), 3);
		assertEquals(1, result);
		result = spart.getPartition(new Text("zodiac"), new IntWritable(1), 3);
		assertEquals(2, result);
		
		
		/*
		 * Test the words "love", "deadly", and "zodiac". 
		 * The expected outcomes should be 0, 1, and 2. 
		 */
        
 		/*
		 * TODO implement
		 */          
		
	}

}
