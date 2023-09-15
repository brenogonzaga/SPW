class AFQuestao03(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()
        val itens = estoque.getItens()
        val menorPrecoPorGenero = mutableMapOf<String, ItemProduto>()

        for (item in itens) {
            val produto = item.produto
            val genero = produto.genero.nome

            menorPrecoPorGenero[genero] = menorPrecoPorGenero.getOrPut(genero) { item }
            if (produto.preco < menorPrecoPorGenero[genero]!!.produto.preco) {
                menorPrecoPorGenero[genero] = item
            }
        }

        for ((genero, menorProduto) in menorPrecoPorGenero) {
            println("Gênero: $genero")
            println("Produto: ${menorProduto.produto.nome}")
            println("R$: ${menorProduto.produto.preco}\n")
        }
    }
}

fun main() {
    AFQuestao03(SPW()).solucao()
}
