class Tiempo (private var hora : Int, private var minuto: Int = 0, private var segundo: Int = 0) {
    init {
        comprobar(hora, minuto, segundo)
    }
    constructor(hora: Int) : this(hora, 0, 0)
    constructor(hora: Int, minuto: Int) : this(hora, minuto, 0) {}

    fun comprobar(hora : Int, minuto: Int, segundo : Int) {
        var totalSegundos = hora *3600 + minuto * 60 + segundo
        require(totalSegundos in 0..86399){ "El tiempo no debe ser mayor a 23:59:59"}
        this.hora = totalSegundos / 3600
        totalSegundos %= 3600
        this.minuto = totalSegundos / 60
        this.segundo = totalSegundos % 60
    }

    fun incrementar(t:Tiempo) : Boolean {
        var totalSegundos2 = hora *3600 + minuto * 60 + segundo
        var totalSegundosT = t.hora * 3600 + t.minuto * 60 + t.segundo
        var resultadoT = totalSegundos2 + totalSegundosT

        if (resultadoT > 86399) return false

        val horaT = resultadoT / 3600
        resultadoT %= 3600
        val minutoT = resultadoT / 60
        val segundoT= resultadoT % 60
        comprobar(horaT, minutoT, segundoT)
        return true
    }

    fun decrementar(t:Tiempo) : Boolean {
        var totalSegundos2 = hora *3600 + minuto * 60 + segundo
        var totalSegundosT = t.hora * 3600 + t.minuto * 60 + t.segundo
        var resultadoT = totalSegundos2 - totalSegundosT

        if (resultadoT < 0) return false
        val horaT = resultadoT / 3600
        resultadoT %= 3600
        val minutoT = resultadoT / 60
        val segundoT= resultadoT % 60
        comprobar(horaT, minutoT, segundoT)
        return true
    }

    fun comparar(t:Tiempo) : Int {
        var totalSegundos2 = hora *3600 + minuto * 60 + segundo
        var totalSegundosT = t.hora * 3600 + t.minuto * 60 + t.segundo

        if(totalSegundos2 < totalSegundosT) return -1
        if(totalSegundos2 > totalSegundosT) return 1
        return 0
    }

    fun copiar(): Tiempo{
        return Tiempo(hora, minuto, segundo)
    }

    fun copiar(t:Tiempo) : Tiempo {
        this.hora = t.hora
        this.minuto = t.minuto
        this.segundo = t.segundo
        return this
    }

    fun sumar(t:Tiempo) : Tiempo? {
        var totalSegundos2 = hora *3600 + minuto * 60 + segundo
        var totalSegundosT = t.hora * 3600 + t.minuto * 60 + t.segundo
        var resultadoT = totalSegundos2 + totalSegundosT
        if (resultadoT > 86399) return null

        val horaT = resultadoT / 3600
        resultadoT %= 3600
        val minutoT = resultadoT / 60
        val segundoT= resultadoT % 60

        return Tiempo(horaT, minutoT, segundoT)

    }

    fun restar(t:Tiempo) : Tiempo? {
        var totalSegundos2 = hora *3600 + minuto * 60 + segundo
        var totalSegundosT = t.hora * 3600 + t.minuto * 60 + t.segundo
        var resultadoT = totalSegundos2 - totalSegundosT
        if (resultadoT <0) return null

        val horaT = resultadoT / 3600
        resultadoT %= 3600
        val minutoT = resultadoT / 60
        val segundoT= resultadoT % 60

        return Tiempo(horaT, minutoT, segundoT)
    }

    fun esMayorQue(t:Tiempo) : Boolean {
        var totalSegundos2 = hora *3600 + minuto * 60 + segundo
        var totalSegundosT = t.hora * 3600 + t.minuto * 60 + t.segundo

        return totalSegundos2 > totalSegundosT
    }

    fun esMenorQue(t:Tiempo) : Boolean {
        var totalSegundos2 = hora *3600 + minuto * 60 + segundo
        var totalSegundosT = t.hora * 3600 + t.minuto * 60 + t.segundo

        return totalSegundos2 < totalSegundosT
    }

    override fun toString(): String {
        return "%02dh %02dm %02ds".format(hora, minuto, segundo)
    }
}