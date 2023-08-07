import zio.*
import zio.direct.*
import zio.http.*


object App extends ZIOAppDefault:

  given CanEqual[Path, Path] = CanEqual.derived
  given CanEqual[Method, Method] = CanEqual.derived

  private val app = Http.collectZIO:
    case Method.GET -> Path.root =>
      defer:
        val random = Random.nextIntBounded(5).run
        Response.text((random + 3).toString)

  def run =
    Server.serve(app.withDefaultErrorResponse).provide(Server.default)
