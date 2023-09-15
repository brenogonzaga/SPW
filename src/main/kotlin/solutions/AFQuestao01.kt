class AFQuestao01(val supermercado: SPW) {
    fun solucao() {
        val estoque = supermercado.getEstoque()

        print("Entre o nome de um gênero: ")
        val genero = readlnOrNull() ?: return
        val itens = estoque.getItensPorGenero(genero)

        if (!itens.isEmpty()) {
            println("codigo, nome, genero, marca, preco, validade, valido?")
            estoque.mostraItens(itens)
        } else {
            println("Nenhum item encontrado com o gênero $genero")
        }
    }
}

fun main() {
    AFQuestao01(SPW()).solucao()
}
