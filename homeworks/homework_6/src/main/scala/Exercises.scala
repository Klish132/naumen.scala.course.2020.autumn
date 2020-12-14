import scala.math.{pow, round, sqrt}

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    seq.reverse
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    val sqr = sqrt(5)
    val a = (1 + sqr) / 2
    val b = (1 - sqr) / 2
    val result = ((pow(a, idx) - pow(b, idx) )/ sqr).toInt
    result
  }

  def fibonacci(idx: Int): Seq[Int] = {
    var result = scala.collection.mutable.ArrayBuffer.empty[Int]
    for (i <- 0 to idx) {
      result += fibonacci4Index(i)
    }
    result
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val result = text.split("").map(s =>
      if (MORSE.contains(s.toUpperCase))
        " " + MORSE(s.toUpperCase)
      else if (s == " ") "  "
      else s)
    result.mkString("").substring(1)
  }


  def wordReverse(text: String): String = {
    var result = scala.collection.mutable.ArrayBuffer.empty[String]
    val sb = new StringBuilder(text.length)
    for(s <- text) {
      if ((s.toLower >= 'a' && s.toLower <= 'z') || (s.toLower >= 'а' && s.toLower <= 'я'))
        sb.append(s)
      else {
        if (sb.nonEmpty) {
          if (sb.toString().charAt(0).isUpper)
            result += sb.toString().toLowerCase.reverse.capitalize
          else
            result += sb.toString().reverse
          sb.clear()
        }
        result += s.toString
      }
    }
    result.mkString("")
  }
}
