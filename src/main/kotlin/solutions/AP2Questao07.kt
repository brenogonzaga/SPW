class AP2Questao7(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()

        println("Digite o nome da marca:")
        val marca = readlnOrNull()

        if (marca != null) {
            val itensMarca = estoque.getItensPorMarca(marca)

            println("Itens válidos da marca $marca:")
            val itensValidosMarca = itensMarca.filter { it.valido() }
            itensValidosMarca.forEach { item ->
                val produto = item.produto
                println("${produto.codigo}, ${produto.nome}, Preço: ${produto.preco}")
            }

            val totalItensMarca = itensValidosMarca.size
            println("Total de Itens da marca $marca: $totalItensMarca")
        } else {
            println("Nome da marca não inválido.")
        }
    }
}

fun main() {
    AP2Questao7(SPW()).solucao()
}
