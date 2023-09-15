class AFQuestao02(val supermercado: SPW = SPW()) {
    fun solucao() {
        val estoque = supermercado.getEstoque()

        println("Entre data de validade no formato 01/09/2000")
        print("Dia: ")
        val dia = readln().toIntOrNull()
        print("Mês: ")
        val mes = readln().toIntOrNull()
        print("Ano: ")
        val ano = readln().toIntOrNull()

        if (dia != null && mes != null && ano != null) {
            val data = Data(dia, mes, ano)
            val itens = estoque.getItens().filter { it.dataValidade.antes(data) }

            if (!itens.isEmpty()) {
                println("Produtos com data de validade anterior a $data:")
                estoque.mostraItens(itens)
                println("Quantidade total: ${itens.size}")
            } else {
                println("Nenhum item encontrado com data de validade anterior a $data")

            }
        } else {
            println("Data de validade inválida.")
        }
    }
}

fun main() {
    AFQuestao02(SPW()).solucao()
}
