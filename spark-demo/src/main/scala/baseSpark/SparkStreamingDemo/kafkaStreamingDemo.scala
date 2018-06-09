package baseSpark.SparkStreamingDemo

import kafka.serializer.StringDecoder
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.kafka.KafkaUtils

/**
  * Created by bigdata on 18-1-29.
  * kafkaStreaming  使用检查点checkpoint的标准创建方法
  */
object kafkaStreamingDemo {
  val checkdir = "file:///home/hduser/spark/spark-1.6.1/checkpointdir/xx"
  val batch: Int = 30
  val topic = "thirddata"

  def main(args: Array[String]): Unit = {

    val ssc = StreamingContext.getOrCreate(checkdir, statActions)
    ssc.start()
    ssc.awaitTermination()

  }

  def statActions(): StreamingContext = {
    val sparkConf = new SparkConf().setAppName(this.getClass.getName.replace("$", "")).setMaster("local[2]")
    val sparkContext = new SparkContext(sparkConf)
    val streamingContext = new StreamingContext(sparkContext, Seconds(batch))
    val kafkaParams = Map[String, String]("metadata.broker.list" -> "master-yyft:9092,slaves01-yyft:9092,slaves02-yyft:9092")
    val topics = Set[String]("thirddata")
    val messages = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](streamingContext, kafkaParams, topics)

    val keysDStream = messages.map(_._1)
    keysDStream.foreachRDD(rdd => {
      rdd.foreachPartition(iter => {
        println("a : " + iter)
        iter.foreach(println(_))
      })
    })
    val valuesDStream: DStream[String] = messages.map(_._2)
    valuesDStream.foreachRDD(rdd => {
      rdd.foreachPartition(iter => {
        println("b : " + iter)
        iter.foreach(println(_))
      })
    })

    streamingContext.checkpoint(checkdir)
    streamingContext
  }


}
