import java.util.Calendar

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {

    override fun toString(): String {
        return String.format("%02d/%02d/%04d", dia, mes, ano)
    }

    fun setData(novoDia: Int, novoMes: Int, novoAno: Int) {
        dia = novoDia
        mes = novoMes
        ano = novoAno
    }

    fun antes(data: Data): Boolean {
        return this.toCalendar().before(data.toCalendar())
    }

    fun depois(data: Data): Boolean {
        return this.toCalendar().after(data.toCalendar())
    }

    fun igual(data: Data): Boolean {
        return this.toCalendar() == data.toCalendar()
    }

    fun adicionarDias(dias: Int): Data {
        val calendar = Calendar.getInstance()
        calendar.set(ano, mes - 1, dia) // O mês é base 0 (janeiro é 0)
        calendar.add(Calendar.DAY_OF_MONTH, dias)

        val novoDia = calendar.get(Calendar.DAY_OF_MONTH)
        val novoMes = calendar.get(Calendar.MONTH) + 1 // Adicione 1 para ajustar o mês (base 0)
        val novoAno = calendar.get(Calendar.YEAR)

        return Data(novoDia, novoMes, novoAno)
    }

    companion object {
        fun dataHoje(): Data {
            val currentDate = Calendar.getInstance()
            return Data(
                    currentDate.get(Calendar.DAY_OF_MONTH),
                    currentDate.get(Calendar.MONTH) + 1,
                    currentDate.get(Calendar.YEAR)
            )
        }
    }

    private fun toCalendar(): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(ano, mes - 1, dia)
        return calendar
    }
}
