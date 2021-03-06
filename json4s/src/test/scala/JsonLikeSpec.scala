import net.bmjames.json.scalacheck.ArbitraryInstances
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.json4s.JValue
import net.bmjames.json.JsonLikeLaws
import net.bmjames.json.json4s._


object JsonLikeSpec extends Properties("JsonLike[JValue]") {

  val instances = ArbitraryInstances[JValue]
  import instances._

  val laws = new JsonLikeLaws[JValue]

  property("array") = forAll(laws.array _)

  property("obj") = forAll(laws.obj _)

  property("int") = forAll(laws.int _)

  property("bool") = forAll(laws.bool _)

  property("string") = forAll(laws.string _)

  property("double") = forAll(laws.double _)

}
