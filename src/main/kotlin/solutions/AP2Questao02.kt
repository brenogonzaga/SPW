class AP2Questao02(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()
        val itens = estoque.getItens()
        val itensAgrupados = itens.groupBy { it.produto.genero }

        println("codigo, nome, genero, marca, preco, validade, valido?")
        itensAgrupados.forEach { (genero, itensGenero) ->
            val totalItensGenero = itensGenero.size

            println("== Gênero: $genero ==")
            val itensFormatados =
                    itensGenero.joinToString("\n") { item ->
                        val produto = item.produto
                        val validadeString = item.dataValidade.toString()
                        val valido = if (item.valido()) "Sim" else "Não"
                        "${produto.codigo}, ${produto.nome}, $genero, ${produto.marca.nome}, ${produto.preco}, $validadeString, $valido"
                    }

            println(itensFormatados)
            println("Total de Itens ($genero): $totalItensGenero\n")
        }
    }
}

fun main() {
    AP2Questao02(SPW()).solucao()
}
