import org.apache.spark.rdd.RDD
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Boot {

  val numberOfCores = 4

  def tokenize(text: RDD[String]): RDD[String] =
    text.flatMap(_.split(" "))

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("Spark Seed")
      .setMaster(s"local[$numberOfCores]")

    implicit val sc = new SparkContext(conf)

    val book = sc.textFile("./data/input/pg1342.txt")

    val tokens = tokenize(book)

    val tokenAndCount =
      tokens
        .map(token => (token, 1))
        .reduceByKey(_ + _)

    tokenAndCount.saveAsTextFile("./data/output")
  }
}
