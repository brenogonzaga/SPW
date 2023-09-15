class AP2Questao4(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()
        val qtdValidos = estoque.contarItensValidos()
        val qtdVencidos = estoque.contarItensVencidos()
        val totalItens = estoque.qtdItens()

        println("Quantidade de itens válidos: $qtdValidos")
        println("Quantidade de itens vencidos: $qtdVencidos")
        println("Total de itens: $totalItens")
        println("Soma de itens válidos e vencidos: ${qtdValidos + qtdVencidos}")

        if (totalItens == (qtdValidos + qtdVencidos)) {
            println("A soma de itens válidos e vencidos é igual ao total de itens no estoque.")
        } else {
            println("A soma de itens válidos e vencidos não é igual ao total de itens no estoque.")
        }
    }
}

fun main() {
    AP2Questao4(SPW()).solucao()
}
