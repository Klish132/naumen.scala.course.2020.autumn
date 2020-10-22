package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'bool1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(3) == "3")
            assert(Exercises.prettyBooleanFormatter1("String") == "String")
            assert(Exercises.prettyBooleanFormatter1(List("a", "b", "c")) == "List(a, b, c)")
        }
        'bool2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(3) == "3")
            assert(Exercises.prettyBooleanFormatter2("String") == "String")
            assert(Exercises.prettyBooleanFormatter2(List("a", "b", "c")) == "List(a, b, c)")
        }
        'bool3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(3) == "3")
            assert(Exercises.prettyBooleanFormatter3("String") == "String")
            assert(Exercises.prettyBooleanFormatter3(List("a", "b", "c")) == "List(a, b, c)")
        }

        'max1 - {
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq(-2, -1, 0, 1, 2)) == 2)
            assert(Exercises.max1(Seq(1)) == 1)
            try {
                Exercises.max1(Seq())
            } catch {
                case e: UnsupportedOperationException => assert(true)
            }
        }
        'max2 - {
            assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
            assert(Exercises.max2(Seq(-2, -1, 0, 1, 2)) == Seq(2))
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq()) == Seq())
        }
        'max3 - {
            assert(Exercises.max3(Seq(1, 2, 3)).contains(3))
            assert(Exercises.max3(Seq(-2, -1, 0, 1, 2)).contains(2))
            assert(Exercises.max3(Seq(1)).contains(1))
            assert(Exercises.max3(Seq()).isEmpty)
        }

        'sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-1, 2) == 1)
            assert(Exercises.sum1(-5, -5) == -10)
            assert(Exercises.sum1(1, 0) == 1)
        }

        'sum2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(-1, 2) == 1)
            assert(Exercises.sum2(-5, -5) == -10)
            assert(Exercises.sum2(1, 0) == 1)
        }

        'sum3 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(-1, 2) == 1)
            assert(Exercises.sum2(-5, -5) == -10)
            assert(Exercises.sum2(1, 0) == 1)
        }

    }
}
