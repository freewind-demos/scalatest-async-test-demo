package example

import org.scalatest._

class HelloSpec extends AsyncFunSuite with Matchers {

  test("The Hello object should say hello") {
    Hello.hello("Scala") map { result =>
      result shouldEqual "Hello, Scala!"
    }
  }

  test("helloEither Left") {
    Hello.helloEither("123") map { result =>
      result shouldEqual Left(123)
    }
  }

  test("helloEither Right") {
    Hello.helloEither("abc") map { result =>
      result shouldEqual Right("abc")
    }
  }

  test("helloEitherT Left") {
    Hello.helloEitherT("123").value.map({ result =>
      result shouldEqual Left(123)
    })
  }

}
