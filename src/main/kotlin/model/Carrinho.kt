class Carrinho {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun adicionaItem(item: ItemProduto) {
        itens.add(item)
    }

    fun removerItem(item: ItemProduto) {
        itens.remove(item)
    }

    fun getItens(): List<ItemProduto> {
        return itens.toList()
    }

    fun totalAPagar(): Double {
        return itens.sumOf { it.produto.preco }
    }

    fun mostraItens() {
        itens.forEach { item ->
            println("${item.produto.codigo}, ${item.produto.nome}, 1, R$ ${item.produto.preco}")
        }
    }

    fun qtdItens(): Int {
        return itens.size
    }
}
