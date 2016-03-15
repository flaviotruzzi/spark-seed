import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.{Matchers, FlatSpec}

class TokenizerSpec extends FlatSpec with Matchers with SharedSparkContext {

  behavior of "TokenizerSpec"

  "tokenize" should "tokenize  ¯\\_(ツ)_/¯." in {

    val text = sc.parallelize(Seq("This   is   a line", "This is another line"))

    val tokens = Boot.tokenize(text).collect().toSeq

    tokens should be (Seq("This", "is", "a", "line", "This", "is", "another", "line"))

  }

}
