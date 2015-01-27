package lists

import scala.annotation.tailrec
import scala.Option

/**
	Problem described here: http://projecteuler.net/problem=67
*/
object MaximumPathSum {

  // sum - is maximum sum of numbers along this path.
  // value - is last number in this path.
  // previous - is link to previous number from this path.
  case class Path(sum:Long, value: Int, previous: Option[Path])

  // Extends previous path by one number of triangle
  def extendPath(newValue: Int, previous: Option[Path]): Path = {
    if (!previous.isDefined) Path(newValue, newValue, None)
    else Path(previous.get.sum + newValue, newValue, previous)
  }

  // Find optimal solution (path with maximum sum) for every number from the bottom line of triangle. 
  // You can split this function to several ones.
  def calculateOptimalPaths(data: List[List[Int]]): List[Path] = {
    def findMaxFromNeightbours(nextLine: List[Int], currentLine: List[Path], acc: List[Path]): List[Path] = currentLine match {
      case Nil => acc
      case head :: Nil => acc
      case head :: others =>  {
        // get new sum and make a new list of path
        findMaxFromNeightbours(nextLine.tail, currentLine.tail, 
            acc :+ extendPath(nextLine.head, if (head.sum < others.head.sum) Some(others.head) else Some(head)))
      }
    }
    def calculate(data: List[List[Int]], acc: List[Path]): List[Path] = data match {
      case Nil => acc
      case head :: others => {
        calculate(others, findMaxFromNeightbours(head, acc, Nil))
      }

    }
  	def reverseInput(data: List[List[Int]], acc: List[List[Int]]): List[List[Int]] = data match {
  	  case Nil => acc
  	  case head :: others => reverseInput(data.tail, head :: acc)
  	}    
  	// prepare path set from bottom line
    def initialPath(data: List[Int]): List[Path] = {
      for (value <- data) 
        yield extendPath(value, None)
    }
    
  	
    val reversed: List[List[Int]] = reverseInput(data, Nil)
    calculate(reversed.tail, initialPath(reversed.head))
  }

  // Return list of number along the path (staring from top of triangle to bottom).
  def numbersForPath(path:Option[Path]): List[Int] = path match {
    case Some(path) => path.value :: numbersForPath(path.previous)
    case _ => Nil
  }

  // Select path that have maximum sum. Should return empty list if paths is empty list.
  def bestPath(paths:List[Path]): Option[Path] = paths match {
    case Nil => None
    case _ => Some(paths.reduceLeft((first: Path, second: Path) => if (first.sum  > second.sum ) first  else second ))
  }

  // Return sum for best path from paths. Should return zero if paths is empty list. Reuse bestPath to find best path.
  def bestSum(paths:List[Path]): Long = bestPath(paths).getOrElse(Path(0, 0, None)).sum 

  // Return number along best path. Should return empty list if paths is empty list. Reuse both bestPath and numbersForPath.
  def bestSumNumbers(paths:List[Path]): List[Int] = numbersForPath(bestPath(paths))
}