package ComprasTest

import Exercicio.Compra
import Exercicio.Frutas
import Exercicio.Laranja
import Exercicio.Maca
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.coroutines.cancellation.CancellationException
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ComprasTest {

    val compra = Compra()
    val carrinho = mutableListOf<Frutas>()

    @Test
    fun `verificar se a fruta esta sendo adicionada corretamente`(){
        val novaLaranja = Laranja("Laranja", 0.25)
        carrinho.add(novaLaranja)

        assertTrue(carrinho.contains(novaLaranja))
    }

    @Test
    fun `verificar se a fruta foi removida corretamente`(){
        val novaLaranja = Laranja("Laranja", 0.25)
        carrinho.remove(novaLaranja)

        assertFalse(carrinho.contains(novaLaranja))
    }
    @Test
    fun deveRetornarValorTotal(){
        carrinho.add(Laranja("Laranja",0.25))
        carrinho.add(Maca("Maçã",0.60))
        carrinho.add(Maca("Maçã",0.60))
        carrinho.add(Maca("Maçã",0.60))

        val valorRetornado = compra.Calcular(carrinho)

        assertEquals(2.05,valorRetornado)
    }
    @Test
    fun deveCairEMExcessao(){
        val novaLista = mutableListOf<Frutas>()
        assertThrows<IllegalArgumentException> { compra.Calcular(novaLista) }
    }


    @Test
    fun deveCairNaOpcaoInvalida(){
        assertThrows<IllegalArgumentException>{ compra.comprarComOfertas(0, carrinho)}
    }

    @Test
    fun `verificar se o a lista esta sendo alterada ao escolher uma oferta`(){
        compra.comprarComOfertas(2, carrinho)
        assertTrue(carrinho.size == 3)
    }

    @Test
    fun deveEstarAdicionandoLaranjas(){
        carrinho.add(Laranja("Laranja",0.25))
        compra.comprarComOfertas(2,carrinho)
        assertTrue(carrinho.size == 4)
    }

    @Test
    fun deveEstarAdicionandoMacas(){
        carrinho.add(Maca("Maçã",0.60))
        compra.comprarComOfertas(1,carrinho)
        assertTrue(carrinho.size == 3)
    }

    //ETAPA 3
    @Test
    fun `verificar se a notificacao esta funcionando corretamente e retorna true`(){
        val novaLaranja = Laranja("Laranja", 0.25)
        carrinho.add(novaLaranja)
        val resultadoEsperado = compra.notificarCliente(carrinho)
        assertEquals(true, resultadoEsperado )
    }
    @Test
    fun `verificar se a notificacao de aviso caso a lista esteja vazia esta funcionando corretamente e retorna false`(){
        val resultadoEsperado = compra.notificarCliente(carrinho)
        assertFalse(resultadoEsperado )
    }

    @Test
    fun `deve retornar true ao passar im codigo e uma quantidade valida`(){
        var respostaErrada = compra.comprarComEstoque(2, 6, carrinho)
        assertTrue(respostaErrada)
    }
    @Test
    fun verificaSeComprarComEstoqueRetornaFalseQuandoAQuantidadeForFalse(){
        var listaDeCompra = mutableListOf<Frutas>()
        val retornoEsperado = compra.comprarComEstoque(2,11,listaDeCompra)
        assertFalse(retornoEsperado)
    }
    @Test
    fun verificaSeComprarComEstoqueRetornaExcecaoQuandoOCodigoForInvalido(){
        var listaDeCompra = mutableListOf<Frutas>()
        assertThrows<IllegalArgumentException> { compra.comprarComEstoque(0,2,listaDeCompra) }
    }
}