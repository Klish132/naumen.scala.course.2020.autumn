object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](val shelter: List[T]) {

    def +[N >: T <: Animal](new_animal: N): Shelter[N] = {
      new Shelter(shelter :+ new_animal)
    }

    def ++[N >: T <: Animal](other_shelter: Shelter[N]): Shelter[Animal] = {
      new Shelter(shelter ++ other_shelter.shelter)
    }

    def getNames: Seq[String] = {
      for {animal <- shelter} yield animal.name
    }

    def feed(food: Food[T]): List[String] = {
      for {animal <- shelter} yield food.feed(animal)
    }
  }

  trait Food[-T <: Animal] {
    val name = ""
    def feed(animal: T): String = {
      animal.name + " eats " + this.name
    }
  }

  case object Meat extends Food[Animal] {
    override val name: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val name: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val name: String = "bread"
  }

}
