import kotlin.random.Random

class SPW {
    private val estoque: Estoque = Estoque()
    private val carrinho: MutableList<Carrinho> = mutableListOf()

    init {
        iniciaSupermercado()
    }

    private fun iniciaSupermercado() {
        val marcas = listOf(Marca("Marca1"), Marca("Marca2"), Marca("Marca3"))
        val generos = listOf(Leite("Leite"), Presunto("Presunto"), Achocolatado("Achocolatado"))

        val codigoInicial = 1
        val currentDate = Data.dataHoje()

        for (i in 1..10) {
            val codigo = codigoInicial + i
            val preco = 2.5 * i

            val produtos =
                    generos.map { genero ->
                        Produto(codigo, "${genero.nome} Produto $i", preco, marcas[i % 3], genero)
                    }

            val itens =
                    produtos.map { produto ->
                        // Gere uma data aleatória entre 1 semana antes e 1 depois da data atual
                        val dataAleatoria = gerarDataAleatoria(currentDate)
                        ItemProduto(codigo, dataAleatoria, produto)
                    }

            produtos.forEach { produto ->
                estoque.entraItem(itens.find { it.produto == produto }!!)
            }
        }
    }

    private fun gerarDataAleatoria(dataAtual: Data): Data {
        val random = Random.Default
        val diasAleatorios = random.nextInt(-7, 8) // Entre -7 e 7 dias
        return dataAtual.adicionarDias(diasAleatorios)
    }

    fun getEstoque(): Estoque {
        return estoque
    }

    fun getCarrinho(qtd: Int): List<Carrinho> {
        repeat(qtd) { carrinho.add(Carrinho()) }
        return carrinho
    }
}
