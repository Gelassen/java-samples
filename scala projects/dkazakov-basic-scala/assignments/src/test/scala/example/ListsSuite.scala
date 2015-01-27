package example

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object
 * `Lists` that need to be implemented as part of this assignment. A test
 * suite is simply a collection of individual tests for some specific
 * component of a program.
 *
 * A test suite is created by defining a class which extends the type
 * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
 * find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed
 * inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 * 
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {

  /**
   * Tests are written using the `test` operator which takes two arguments:
   *
   * - A description of the test. This description has to be unique, no two
   *   tests can have the same description.
   * - The test body, a piece of Scala code that implements the test
   *
   * The most common way to implement a test body is using the method `assert`
   * which tests that its argument evaluates to `true`. So one of the simplest
   * successful tests is the following:
   */
  test("one plus one is two")(assert(1 + 1 == 2))


  /**
   * In Scala, it is allowed to pass an argument to a method using the block
   * syntax, i.e. `{ argument }` instead of parentheses `(argument)`.
   *
   * This allows tests to be written in a more readable manner:
   */
  test("one plus one is three?") {
    assert(1 + 1 == 2) // This assertion fails! Go ahead and fix it.
  }


  /**
   * One problem with the previous (failing) test is that ScalaTest will
   * only tell you that a test failed, but it will not tell you what was
   * the reason for the failure. The output looks like this:
   *
   * {{{
   *    [info] - one plus one is three? *** FAILED ***
   * }}}
   *
   * This situation can be improved by using a special equality operator
   * `===` instead of `==` (this is only possible in ScalaTest). So if you
   * run the next test, ScalaTest will show the following output:
   *
   * {{{
   *    [info] - details why one plus one is not three *** FAILED ***
   *    [info]   2 did not equal 3 (ListsSuite.scala:67)
   * }}}
   *
   * We recommend to always use the `===` equality operator when writing tests.
   */
  test("details why one plus one is not three") {
    assert(1 + 1 === 2) // Fix me, please!
  }


  /**
   * In order to test the exceptional behavior of a methods, ScalaTest offers
   * the `intercept` operation.
   *
   * In the following example, we test the fact that the method `intNotZero`
   * throws an `IllegalArgumentException` if its argument is `0`.
   */
  test("intNotZero throws an exception if its argument is 0") {
    intercept[IllegalArgumentException] {
      intNotZero(0)
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }


  /**
   * Now we finally write some tests for the list functions that have to be
   * implemented for this assignment. We fist import all members of the
   * `List` object.
   */ 
  import Lists._
  

  /**
   * We only provide two very basic tests for you. Write more tests to make
   * sure your `length` and `min` methods work as expected.
   *
   * In particular, write tests for corner cases: negative numbers, zeros,
   * empty lists, lists with repeated elements, etc.
   *
   * It is allowed to have multiple `assert` statements inside one test,
   * however it is recommended to write an individual `test` statement for
   * every tested aspect of a method.
   */
  test("length of the list") {
    assert(length(List(1,2,0)) === 3)
  }
  
  test("length of the list. Negative") {
    assert(length(List(1,-20,0)) === 3)
  }
    
  test("length of the list. Zeros") {
    assert(length(List(0,0,0)) === 3)
  }
      
  test("length of the list. Empty") {
    assert(length(List()) === 0)
  }
  
  test("length of the list. Only one") {
    assert(length(List(1)) === 1)
  }
        
  test("length of the list. Repeated") {
    assert(length(List(42,42,42)) === 3)
  }
          
  test("length of the list. More than few") {
    assert(length(List(1,2,0,1,2,0,1,2,0,1,2,0)) === 12)
  }
  
  test("min of a few numbers") {
    assert(min(List(3, 2, 7)) === 2)
  }
  
  test("min of a few numbers. Negative") {
    assert(min(List(3, 2, -7)) === -7)
  }
    
  test("min of a few numbers. Zeros") {
    assert(min(List(3, 2, 0)) === 0)
  }
      
  test("min of a few numbers. Empty") {
    intercept[NoSuchElementException] {
      min(List())
    }
  }
        
  test("min of a few numbers. Only one") {
    assert(min(List(7)) === 7)
  }
          
  test("min of a few numbers. Repeated") {
    assert(min(List(27, 27, 27)) === 27)
  }
            
  test("min of a few numbers. More than few") {
    assert(min(List(3, 2, 7, 982, 3, 4, 9, 81, -23, -784, -50, 1, 1, -238)) === -784)
  }
}
