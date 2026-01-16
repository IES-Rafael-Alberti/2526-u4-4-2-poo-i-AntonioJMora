import java.util.Locale
import java.util.Locale.getDefault

class Coche(marca: String?, modelo: String?,
            val numCaballo : Int?, val numPuertas: Int?, val matricula : String?,
            var color :String?) {
    init {
        if(marca.isNullOrBlank()) throw Exception("Marca no puede ser null")
        if(modelo.isNullOrBlank()) throw Exception("Modelo no puede ser null")
        if(numCaballo == null) throw Exception("Numero de caballos no puede ser null")
        if(numCaballo !in 70..700 ) throw Exception("Numero de caballos debe estar entre 70 y 700")
        if(numPuertas == null) throw Exception("Numero de puertas no puede ser null")
        if (numPuertas !in 3..5) throw Exception("Numero de puertas debe estar entre 3 y 5")
        if(matricula == null) throw Exception("Matricula no puede ser null")
        if(matricula.length != 7) throw Exception("La longitud de la matrícula debe ser 7")
        if(color == null) throw Exception("Color no puede ser null")
    }
    val marca: String = marca!!
        get() = field.replaceFirstChar {it.uppercase()}

    val modelo: String = modelo!!
        get() = field.replaceFirstChar {it.uppercase()}

    override fun toString(): String {
        return "Coche(marca=$marca, modelo=$modelo, caballos=$numCaballo, puertas=$numPuertas, matricula=$matricula, color=$color)"
    }
}