class ItemProduto(val codigo: Int, val dataValidade: Data, val produto: Produto) {
    fun valido(): Boolean = !dataValidade.depois(Data.dataHoje())
}
