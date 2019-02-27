import hello.beer.recommend.{BeerRecommendServiceGrpc, RecommendRequest}
import io.grpc.{ManagedChannel, ManagedChannelBuilder}

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

object ClientMain {

  val host = "localhost"
  val port = 50051

  def main(args: Array[String]) = {
    val channel: ManagedChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build
    val stub = BeerRecommendServiceGrpc.blockingStub(channel)
    val res = stub.recommend(RecommendRequest("brewdog"))
    res.beer.foreach { beer =>
      println(s"${beer.name}: ${beer.style}")
    }

    val asyncStub = BeerRecommendServiceGrpc.stub(channel)
    val asyncRes = asyncStub.recommend(RecommendRequest("brewdog"))
    implicit val ec = ExecutionContext.global
    asyncRes.onComplete {
      case Success(r) =>
        r.beer.foreach { beer =>
          println(s"${beer.name}: ${beer.style} ${beer.hop}")
        }
      case Failure(e) => e.printStackTrace()
    }
  }

}
