class AP2Questao5(val supermercado: SPW) {

    fun solucao() {
        val estoque = supermercado.getEstoque()
        val carrinho = supermercado.getCarrinho(1)[0]
        val itensCodigoImpar = estoque.getItens().filter { it.codigo % 2 != 0 }
        val qtdTotal = itensCodigoImpar.size

        println("Itens no carrinho:")
        carrinho.mostraItens()

        val precoTotalCarrinho = carrinho.totalAPagar()
        println("Preço total do carrinho: R$$precoTotalCarrinho\n")

        println("Itens restantes no estoque:")
        estoque.mostraItens()

        println("Total de itens no Estoque: $qtdTotal")
    }
}

fun main() {
    AP2Questao5(SPW()).solucao()
}
