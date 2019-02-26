import hello.beer.recommend.BeerRecommendServiceGrpc.BeerRecommendService
import hello.beer.recommend.{Beer, BeerStyle, RecommendRequest, RecommendResponse}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class DefaultBeerRecommendService extends BeerRecommendService {
  override def recommend(request: RecommendRequest): Future[RecommendResponse] = {
    Future {
      RecommendResponse(Seq(
        Beer("Punk IPA", BeerStyle.IPA, Seq("Chinook", "Simcoe", "Ahtanum", "Sauvin", "Amarillo", "Cascade")),
        Beer("Jack Hammer", BeerStyle.IPA, Seq("foo", "bar")),
        Beer("Hazy Jane", BeerStyle.IPA, Seq("foo", "bar"))
      ))
    }
  }
}
