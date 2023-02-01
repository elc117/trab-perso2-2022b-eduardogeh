object Main {
  def main(args: Array[String]): Unit = {
    
    val precos: Seq[Double] = Seq(1.5, 2.0, 2.5)
    val soma = precos.fold(0.0) { (_ + _) }

    val nomes: Seq[String] = Seq("Uno", "Gol", "Palio")
    val lista1 = nomes.foldLeft("") ((a, b) => a + b + " Vermelho, ")
  
    println(s"$lista1")

    val lista2 = nomes.foldRight("") ((a, b) => a + b + " Vermelho, ")
    //utilizar ((a, b) => b + a + " Vermelho, ") como função para corrigir a ordem
    
    println(s"$lista2")

    def fatorial(n: Int): Int = {
      (1 to n).toList.foldRight(1) { (x, acc) => x * acc }
    }

    val numero = fatorial(5)
    println(s"$numero")
    
  }
}
