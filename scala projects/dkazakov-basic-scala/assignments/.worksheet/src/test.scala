object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(27); 



	val list = List(1,2,3);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(21); val res$0 = 
	list.updated(2, -1);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(23); val res$1 = 
	list.foldLeft(0)(_+_);System.out.println("""res1: Int = """ + $show(res$1));$skip(15); val res$2 = 
	list.mkString;System.out.println("""res2: String = """ + $show(res$2));$skip(59); val res$3 = 
	
	list.groupBy(x => x).map(x => (x._1, x._2.size)).toList;System.out.println("""res3: List[(Int, Int)] = """ + $show(res$3))}
}
