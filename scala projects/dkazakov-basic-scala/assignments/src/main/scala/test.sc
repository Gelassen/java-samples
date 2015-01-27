object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet



	val list = List(1,2,3)                    //> list  : List[Int] = List(1, 2, 3)
	list.updated(2, -1)                       //> res0: List[Int] = List(1, 2, -1)
	list.foldLeft(0)(_+_)                     //> res1: Int = 6
	list.mkString                             //> res2: String = 123
	
	list.groupBy(x => x).map(x => (x._1, x._2.size)).toList
                                                  //> res3: List[(Int, Int)] = List((2,1), (1,1), (3,1))
}