package pagerank;

/*
 * PageRank Spark Implementation
 * 
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.broadcast.Broadcast;

import com.google.common.collect.Iterables;
import scala.Tuple2;

public class rddPagerank {

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();

		SparkConf sparkConf = new SparkConf().setAppName("Spark_PageRank_RDD1").setMaster("local[2]")
				.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
		JavaSparkContext context = new JavaSparkContext(sparkConf);

		String input = args[0];
		String output = args[1];

		System.out.println("Reading the files...");

		JavaRDD<String> initialRDD = context.textFile(input);

		JavaRDD<String> filterRDD = initialRDD.filter(data -> {
			List<String> filterData = new ArrayList<String>();
			filterData = Arrays.asList(data.split(","));

			if (filterData.size() > 4) {

				String vendorID = filterData.get(0).trim();
				String tpep_pickup_datetime = filterData.get(1).trim();
				String tpep_dropoff_datetime = filterData.get(2).trim();
				String passenger_count = filterData.get(3).trim();
				String trip_distance = filterData.get(4).trim();

				if (vendorID.equals("2") && tpep_pickup_datetime.equals("2017-10-01 00:15:30")
						&& tpep_dropoff_datetime.equals("2017-10-01 00:25:11") && passenger_count.equals("1")
						&& trip_distance.equals("2.17")) {

					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		});

		filterRDD.saveAsTextFile(output + "RDD_PageRanks");

		long total = System.currentTimeMillis() - start;
		System.out.println("Computaion time taken: " + total / 60000 + " mins");
		for (String filter : filterRDD.collect()) {
			System.out.println("*" + filter);
		}
		
		
		context.close();
		total = System.currentTimeMillis() - start;
		System.out.println("total time taken: " + total / 60000 + " mins");

	}

}
