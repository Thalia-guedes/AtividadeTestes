package Exercicio

fun main() {
    val add = Compra()
    val carrinho = mutableListOf<Frutas>()

    carrinho.add(Maca("Maça", 0.60))
    carrinho.add(Maca("Maça", 0.60))
    carrinho.add(Maca("Maça", 0.60))
    carrinho.add(Laranja("Laranja", 0.25))


    println("TOTAL: R$%.2f".format(add.Calcular(carrinho)))

    println(add.Calcular(add.comprarComOfertas(1, carrinho)))

    //ETAPA 3
    add.notificarCliente(carrinho)
    carrinho.clear()
    add.notificarCliente(carrinho)

    // ETAPA 4
    println("FRUTAS DISPONÍVEIS: \n[1] Maça: 3      [2] Laranja: 5")
    println("Informe a quantidade e o código da fruta para comprar. ")
    add.comprarComEstoque(1, 6, carrinho)
    for (i in carrinho){
        println("FRUTA: ${i.nome}      PREÇO: ${i.preco}")
    }

}