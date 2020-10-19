package example

object Main extends App {
  val name = "Artem Shishkin"

  val greetings: List[String] = List("Hello", "Hola", "Hallo")

  def greet(name: String, greeting: String) : Unit = println(s"$greeting Scala! This is $name.")

  greetings.foreach(greeting => greet(name, greeting))

  greetings.foreach(greeting => greet(name.reverse, greeting))
}
