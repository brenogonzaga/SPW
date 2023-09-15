class Estoque {
    private val itens: MutableList<ItemProduto> = mutableListOf()

    fun entraItem(item: ItemProduto) = itens.add(item)

    fun saiItem(item: ItemProduto) = itens.remove(item)

    fun getItens(): List<ItemProduto> = itens.toList()

    fun getItensPorProduto(produto: Produto) = itens.filter { it.produto == produto }

    fun getItensPorMarca(marca: String) =
            itens.filter { it.produto.marca.nome.equals(marca, ignoreCase = true) }

    fun getItensPorGenero(genero: String) =
            itens.filter { it.produto.genero.nome.equals(genero, ignoreCase = true) }

    fun qtdItens() = itens.size

    fun contarItensValidos() = itens.count { it.valido() }

    fun contarItensVencidos() = itens.count { !it.valido() }

    fun mostraItens() {
        for (item in itens) {
            println(
                    "${item.codigo}, ${item.produto.nome}, 1, R$ ${item.produto.preco}, ${item.dataValidade}, ${item.valido()}"
            )
        }
    }

    fun mostraItens(itens: List<ItemProduto>) {
        for (item in itens) {
            println(
                    "${item.codigo}, ${item.produto.nome}, 1, R$ ${item.produto.preco}, ${item.dataValidade}, ${item.valido()}"
            )
        }
    }
}
