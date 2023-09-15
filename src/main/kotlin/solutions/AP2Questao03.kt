class AP2Questao03(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()
        val itensValidos = estoque.getItens().filter { it.valido() }
        val itensAgrupados = itensValidos.groupBy { Pair(it.produto.genero, it.produto.marca) }

        println("codigo, nome, genero, marca, preco, validade, valido?")
        itensAgrupados.forEach { (chave, itensGrupo) ->
            val (genero, marca) = chave
            val totalItensGrupo = itensGrupo.size

            println("== Gênero: ${genero.nome}, Marca: ${marca.nome} ==")
            val itensFormatados =
                    itensGrupo.joinToString("\n") { item ->
                        val produto = item.produto
                        val validadeString = item.dataValidade.toString()
                        val valido = if (item.valido()) "Sim" else "Não"
                        "${produto.codigo}, ${produto.nome}, ${genero.nome}, ${marca.nome}, ${produto.preco}, $validadeString, $valido"
                    }

            println(itensFormatados)
            println("Total de Itens (${genero.nome} - ${marca.nome}): $totalItensGrupo\n")
        }
        println("Total de Itens Mostrados: ${itensValidos.size}")
    }
}

fun main() {
    AP2Questao03(SPW()).solucao()
}
