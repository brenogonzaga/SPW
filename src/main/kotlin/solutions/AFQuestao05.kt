class AFQuestao05(val supermercado: SPW) {

    fun solucao() {
        val estoque = supermercado.getEstoque()
        val carrinho = supermercado.getCarrinho(1)[0]
        val itensEstoque = estoque.getItens().toMutableList()

        println("Lista de itens no estoque - antes de adicionar")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        estoque.mostraItens()

        println("\nLista de itens no carrinho - antes de adicionar")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        carrinho.mostraItens()

        for (i in 1..10) {
            val itemAleatorio = itensEstoque.random()
            carrinho.adicionaItem(itemAleatorio)
            itensEstoque.remove(itemAleatorio)
        }

        println("\nLista de itens no estoque - depois de adicionar")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        estoque.mostraItens()

        println("\nLista de itens no carrinho - depois de adicionar")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        carrinho.mostraItens()

        for (i in 1..10) {
            val itemAleatorio = carrinho.getItens().random()
            carrinho.removerItem(itemAleatorio)
            itensEstoque.add(itemAleatorio)
        }

        println("\nLista de itens no estoque - depois de remover")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        estoque.mostraItens()

        println("\nLista de itens no carrinho - depois de remover")
        println("codigo, nome, genero, marca, preco, validade, valido?")
        carrinho.mostraItens()
    }
}

fun main() {
    AFQuestao05(SPW()).solucao()
}
