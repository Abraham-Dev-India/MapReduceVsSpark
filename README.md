# MapReduceV/sSpark
* This project compares MapReduce with Spark on two operations - single record lookup and filter
* Both the spark and mapreduce jars were compiled separately and was deployed on an EC2 instance
* The analysis was done on a 5GB dataset and was downloaded from S3


********************************** COMMANDS USED *************************************

SPARK COMMAND
spark2-submit --class pagerank.rddPagerank --master yarn --deploy-mode client spark2.jar /user/ec2-user/spark_assignment/input/yellow_tripdata* /user/ec2-user/spark_assignment/output/spark/single_row_lookup82

MapReduce Command
hadoop jar mr2.jar mapreduce_fetch2.MapReduceDriver /user/ec2-user/spark_assignment/input/yellow_tripdata* /user/ec2-user/spark_assignment/output/mapred/filter_mapreduce


********** Job Run Time Comparison ***********
 
Single Record Lookup 
Map Reduce - 4Min 41sec
Spark RDD - 2Min 44sec

Filter 
Map-Reduce - 2Min 44sec 
Spark RDD - 2Min 5 sec

FINAL RESULT:

Spark RDD is significantly faster in the case of single row lookup, but the difference isn't that pronounced in the case of Filter operation

