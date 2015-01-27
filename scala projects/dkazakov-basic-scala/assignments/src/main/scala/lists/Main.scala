package lists
import MaximumPathSum._
import PathData._

object Main {
  def main(args: Array[String]) {
    val paths = calculateOptimalPaths(smallProblemData)
    def printTest2(data: List[Path]): Unit = {
      for (list <- data) {
        println(" " + list.sum + " " + list.value)

      }
    }
    
    println("Length: " + paths.length)
    bestSum(List())
    println(bestSum(paths))
    println(bestSumNumbers(paths))
  }
}
