# Fold, FoldLeft e FoldRight em Scala

O Fold é uma função de alta ordem utilizado em várias linguagens, em sua essencia, os três métodos possuem funções semelhantes mas executam as operações de maneiras diferentes

Os Metodos basicamente tem dois parâmetros na sua utilização, que seriam o valor inicial, e uma função, por exemplo:
```scala
    lista.fold(VALOR_INICIAL) {FUNÇÃO}
```

# Fold
O método fold sozinho, é utilizado para iterar pelos elementos de coleções, sejam elas quais forem, cabe ressaltar que a sua ordem de iteração depende de como ele é implementado em diferentes coleções, por exemplo em uma lista ele pode percorrer da esquerda para a direita (foldLeft) e em um vetor da direita para a esquerda (foldRight), portanto dependendo do uso pode trazer resultados diferentes

Por exemplo o código abaixo que soma os valores de uma sequência com valor inicial 0:
```scala
    val precos: Seq[Double] = Seq(1.5, 2.0, 2.5)
    val soma = precos.fold(0.0) { (_ + _) }
```

# FoldLeft & FoldRight
Como dito anteriormente o foldLeft implementa a iteração da esquerda para direita, e o foldRight da direita para a esquerda, para exemplificar como isso pode funcionar termeos que analisar exemplos.

Veja o funcionamento do FoldLeft ao concatenar uma Lista de Strings com um valor predefinido:

```scala
    val nomes: Seq[String] = Seq("Uno", "Gol", "Palio")
    
    val lista = nomes.foldLeft("") ((a, b) => a + b + " Vermelho, ")
    
    println(s"$lista")
```
A Saida desse código é:
```bash
    Uno Vermelho, Gol Vermelho, Palio Vermelho,
```

Agora, utilizando a mesma sequencia e valores com o método FoldRight, o resultado será assim: 
```bash
    UnoGolPalio Vermelho,  Vermelho,  Vermelho,
```

Isso acontece pois a iteração é posicional, ou seja, na primeira iteração não existe "b" pois ele esta fora dos limites da lista, na segunda iteração o b passa a ser o  "Palio Vermelho", e a frente dele é colocado o "Gol" e atrás o "Vermelho", para evitar isso basta trocar o a e o b de posição na função

Uma utilização interessante do foldRight pode ser o calculo do fatorial de um numero, veja abixo:

```scala
    def fatorial(n: Int): Int = {
      (1 to n).toList.foldRight(1) { (x, acumulador) => x * acumulador }
    }

    val numero = fatorial(5)
    println(s"$numero")
```
A saida da aplicação é 120, ainda é possivel perceber a utilidade do valor inicial, já que, supondo que o fatorial de 0 seja exigido, a lista estará vazia, e não ocorrerá iteração, mas mesmo assim, o valor inicial sera retornado, que no caso é 1, visto que na matemática o fatorial de 0 é 1


