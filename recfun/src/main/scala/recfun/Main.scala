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
    if (c == 0 && r == 0) 1
    else {
      if (r < 0) 0
      else {
        pascal(c - 1, r - 1) + pascal(c, r - 1)
      }
    }
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def loop(chars: List[Char], acc: Int): Int = {
      if (acc<0 || chars.isEmpty) acc
      else{
        loop(chars.tail, acc + howCountChar(chars.head))
      }
    }
    def howCountChar(char: Char): Int = {
      if (char=='(') 1
      else{
        if (char==')') -1
        else 0
      }
    }
    loop(chars,0)==0
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def loop(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) 0
      else {
        if (money == 0) 1
        else loop(money - coins.head, coins) + loop(money, coins.tail)
      }
    }
    if (money<=0) 0
    else loop(money, coins)
  }
}

