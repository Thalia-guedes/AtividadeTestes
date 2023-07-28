package Exercicio


class Compra {

    fun Calcular(carrinho: MutableList<Frutas>): Double {
        var total = 0.0

        println("Frutas compradas ")
        for (i in carrinho) {
            total += i.preco
        }
        return total
    }

    fun comprarComOfertas(opc: Int, carrinho: MutableList<Frutas>): MutableList<Frutas> {

        when (opc) {
            1 -> {
                carrinho.add(Maca("Maçã", 0.60))
                carrinho.add(Maca("Maçã", 0.0))

            }

            2 -> {
                carrinho.add(Laranja("Laranja", 0.25))
                carrinho.add(Laranja("Laranja", 0.25))
                carrinho.add(Laranja("Laranja", 0.0))
            }

            else -> {

                throw IllegalArgumentException()
            }
        }
        println("-------Segue a Lista do seu Pedido:------- ")
        for (i in carrinho) {
            println("${i.nome} | R$ ${i.preco}")
        }
        return carrinho

    }

    fun notificarCliente(carrinho: MutableList<Frutas>): Boolean {
        return if (carrinho.isNotEmpty()) {

            println("Seu pedido esta sendo preparado")
            Thread.sleep(3000)
            println("Seu pedido saiu para entrega! \n Tempo estimado de 30 minutos")
            Thread.sleep(5000)
            println("Seu pedido foi entregue!")
            Thread.sleep(3000)
            true
        } else {
            println("Poxa não há produtos em seu carrinho, compre algo e volte aqui para tentarmos novamente ;)")
            false
        }

    }

    fun comprarComEstoque(codigo:Int,qtd:Int,listaDeCompra:MutableList<Frutas>):Boolean{
        if (codigo==1){
            when{
                qtd in 1..5 -> {
                    for (i in 1..qtd){
                        listaDeCompra.add(Maca("Maça",0.60))
                    }
                    println("Compra efetuada com sucesso!")
                    return true
                }
                else -> {
                    println("A quantidade solicitada não está disponível para esse produto")
                }
            }
        }
        else if(codigo==2){
            when{
                qtd in 1..10 -> {
                    for (i in 1..qtd){
                        listaDeCompra.add(Laranja("Laranja",0.25))
                    }
                    println("Compra efetuada com sucesso!")
                    return true
                }
                else -> {
                    println("A quantidade solicitada não está disponível para esse produto")
                }
            }
        }
        else{
            throw IllegalArgumentException("Opção de produto inválida")
        }
        return false
    }
}