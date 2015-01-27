package functions

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == r || c == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checker(opend: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) {
        opend == 0
      } else {
        val newAmount = calcAmount(opend, chars.head)
        if (newAmount < 0) false
        else checker(newAmount, chars.tail)
      }
    }
    def calcAmount(amount: Int, value: Char): Integer = {
      if (value == '(') amount + 1
      else if (value == ')') amount - 1
      else amount
    }

    checker(0, chars);
  }

  /**
   * Exercise 3
   *
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def calc(money: Int, coins: List[Int], acc: Int): Int = {
      if (money < 0) acc
      else if (coins.isEmpty) {
        if (money == 0) acc + 1 else acc
      }
      else calc(money, coins.tail, acc) + calc(money - coins.head, coins, acc)
    }
    calc(money, coins, 0)
  }
  
}
