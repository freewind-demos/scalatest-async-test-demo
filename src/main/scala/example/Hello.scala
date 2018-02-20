package example
import cats.data.EitherT

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Hello extends App {

  def hello(name: String): Future[String] = Future.apply {
    Thread.sleep(500)
    s"Hello, $name!"
  }

  def helloEither(name: String): Future[Either[Int, String]] = Future.apply {
    try {
      Left(name.toInt)
    } catch {
      case e: Throwable => Right(name)
    }
  }

  def helloEitherT(name: String): EitherT[Future, Int, String] = EitherT.apply {
    Future.apply {
      try {
        Left(name.toInt)
      } catch {
        case e: Throwable => Right(name)
      }
    }
  }
}
