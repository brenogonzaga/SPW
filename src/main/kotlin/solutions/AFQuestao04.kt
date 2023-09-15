class AFQuestao04(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()
        val itens = estoque.getItens()
        val itensValidos = itens.filter { it.valido() }
        val itensVencidos = itens.size - itensValidos.size

        val somaDeTodosItens = calcularValorDosItens(itens)
        val somaDeItensValidos = calcularValorDosItens(itensValidos)

        println(
                "Total de itens ${itens.size}, total de itens válidos ${itensValidos.size}, total de itens vencidos $itensVencidos"
        )
        println("codigo, nome, genero, marca, preco, validade, valido?")
        estoque.mostraItens(itensValidos)

        println("Total de itens ${itensValidos.size}")
        println("Lucro total $somaDeItensValidos")
        println("Prejuízo total ${somaDeTodosItens - somaDeItensValidos}")
    }

    private fun calcularValorDosItens(itens: List<ItemProduto>): Double {
        return itens.sumOf { it.produto.preco }
    }
}

fun main() {
    AFQuestao04(SPW()).solucao()
}
