# PageRankUsingSpark
# This project compares MapReduce with Spark on three operations - single record lookup, filter and GroupBy
# Both the spark and mapreduce jars were compiled separately and was deployed on an EC2 instance


# COMMANDS USED

# SPARK COMMAND
spark2-submit --class pagerank.rddPagerank --master yarn --deploy-mode client spark2.jar /user/ec2-user/spark_assignment/input/yellow_tripdata* /user/ec2-user/spark_assignment/output/spark/single_row_lookup82

#MapReduce Command
hadoop jar mr2.jar mapreduce_fetch2.MapReduceDriver /user/ec2-user/spark_assignment/input/yellow_tripdata* /user/ec2-user/spark_assignment/output/mapred/filter_mapreduce
