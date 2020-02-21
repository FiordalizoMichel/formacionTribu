object TamHabitacionesFMLG extends App {

  def readFile(fileName: String): Iterator[String] = io.Source.fromFile(fileName).getLines
  val ds: Array[Array[String]] = readFile("src/main/scala/resorces/RealEstate.csv").map(_.split(",")).toArray
  val finalList = ds
    .filter(row => {val cell = row(3)
        cell.matches("\\d+")})
    .map( row => { row(3).toInt match {
        case 1 => "chico"
        case 2 => "mediano"
        case 3 => "grande"
        case 4 => "familiar"
        case _ => }})

  finalList.foreach(println(_))
}
