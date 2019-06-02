package recfun

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
      if (c == 0)
        1
      else if (r == 0)
        0
      else
        pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def calc(chars: List[Char], sum: Int): Boolean = {
        if (sum < 0)
          false
        else if (chars.isEmpty)
          sum == 0
        else {
          if (chars.head == '(')
            calc(chars.tail, sum + 1)
          else if (chars.head == ')')
            calc(chars.tail, sum - 1)
          else
            calc(chars.tail, sum)
        }
      }
      calc(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) {
        1
      }
      else if (coins.isEmpty || money < 0) {
        0
      }
      else {
        var res: Int = countChange(money, coins.tail) // Dont take this coin
        if (money - coins.head >= 0) {
          res = res + countChange(money - coins.head, coins) // Take the coin more than one
        }
        res
      }
    }
  }
