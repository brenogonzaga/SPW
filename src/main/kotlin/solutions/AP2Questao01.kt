class AP2Questao1(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()
        val totalItens = estoque.qtdItens()

        println("codigo, Nome, Genero, Marca, Preco, Validade, Valido?")
        estoque.mostraItens()
        println("\nTotal de Itens: $totalItens")
    }
}

fun main() {
    AP2Questao1(SPW()).solucao()
}
