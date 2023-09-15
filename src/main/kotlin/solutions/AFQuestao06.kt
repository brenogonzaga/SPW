class AFQuestao06(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()
        val itens = estoque.getItens().toMutableList()
        val itensValidos = estoque.getItens().filter { it.valido() }
        val itensInvalidos = estoque.getItens().filter { !it.valido() }
        val carrinho = supermercado.getCarrinho(2)
        val carrinhoItensValidos = carrinho[0]
        val carrinhoItensInvalidos = carrinho[1]

        for (item in itensValidos) {
            carrinhoItensValidos.adicionaItem(item)
            itens.remove(item)
        }

        for (item in itensInvalidos) {
            carrinhoItensInvalidos.adicionaItem(item)
            itens.remove(item)
        }

        println("\nLista de itens no carrinho A - itens válidos")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        carrinhoItensValidos.mostraItens()

        println("\nLista de itens no carrinho B - itens inválidos")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        carrinhoItensInvalidos.mostraItens()

        println("\nLista de itens no estoque")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        estoque.mostraItens(itens)
    }
}

fun main() {
    AFQuestao06(SPW()).solucao()
}
