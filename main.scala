// import org.apache.spark.sql.streaming.Trigger

// // Create DataFrame representing the stream of input lines from connection to localhost:9999
// val lines = spark.readStream
//   .format("socket")
//   .option("host", "localhost")
//   .option("port", 9999)
//   .load()

// // Split the lines into words
// // val words = lines.as[String].flatMap(_.split(" "))
// val words = lines.as[String]

// // Generate running word count
// // val wordCounts = words.groupBy("value").count()
// val wordCounts = words


// // Start running the query that prints the running counts to the console
// val query = wordCounts.writeStream
//   // .outputMode("complete")
//   .outputMode("append")
//   // .outputMode("update")
//   .format("console")
//   .trigger(Trigger.Continuous("1 second"))
//   .start()

// query.awaitTermination()

// org.apache.spark.sql.AnalysisException: Complete output mode not supported when there are no streaming aggregations on streaming DataFrames/Datasets;;


import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.types.{StringType, StructType, DoubleType}

sc.setLogLevel("ERROR")

// spark
//   .readStream
//   .format("rate")
//   .option("rowsPerSecond", "10")
//   .option("")

val lines = spark
  .readStream
  .format("kafka")
  // .option("kafka.bootstrap.servers", "host1:port1,host2:port2")
  .option("kafka.bootstrap.servers", "localhost:9092")
  .option("subscribe", "test")
  .load()
  // .selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
  .select( $"value" cast StringType as "value" )

val df = lines
  .select($"value")
  .select( split( $"value", "\t").as("value_list") )
  .select(
    $"value_list".getItem(0) cast StringType as "id",
    $"value_list".getItem(1) cast StringType as "timestamp",
    $"value_list".getItem(2) cast DoubleType as "lat",
    $"value_list".getItem(3) cast DoubleType as "lon",
    $"value_list".getItem(4) cast DoubleType as "err"
  )

val query = df.writeStream
  .format("console")
  // .format("kafka")
  // .option("kafka.bootstrap.servers", "host1:port1,host2:port2")
  // .option("topic", "topic1")
  // .trigger(Trigger.Continuous("2 second"))  // only change in query
  .start()

query.awaitTermination()

