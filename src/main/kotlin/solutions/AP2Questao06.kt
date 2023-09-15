import kotlin.random.Random

class AP2Questao6(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()
        val carrinho = supermercado.getCarrinho(1)[0]
        val totalItensEstoque = estoque.qtdItens()
        val itensEstoque = estoque.getItens().toMutableList()

        val random = Random.Default
        val quantidadeItensAleatoria = random.nextInt(0, itensEstoque.size + 1)

        val itensAleatorios = itensEstoque.shuffled().take(quantidadeItensAleatoria)

        for (itemAleatorio in itensAleatorios) {
            carrinho.adicionaItem(itemAleatorio)
            itensEstoque.remove(itemAleatorio)
        }

        println("Itens no carrinho:")
        carrinho.mostraItens()
        println("Quantidade total de itens no carrinho: ${carrinho.qtdItens()}\n")

        println("Itens restantes no estoque:")
        estoque.mostraItens()

        println("Total de Itens no Estoque: $totalItensEstoque")
    }
}

fun main() {
    AP2Questao6(SPW()).solucao()
}
