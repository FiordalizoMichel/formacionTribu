object CuentaPalabrasFMLG extends App {

  def readFile(fileName: String): Iterator[String] = io.Source.fromFile(fileName).getLines

  val ds = readFile("src/main/scala/resorces/tusa.txt")
    .flatMap(_.split(" "))
    .map(word => (word
      .replaceAll("(?i)[^a-zá|é|í|ó|ú\\s]", "").toLowerCase, 1))
    .toList
    .groupBy(_._1).mapValues( _.map(_._2).sum)
    .toArray
    .sortBy(_._2)
    .reverse

  val resultado = ds.foreach(println(_))

}
