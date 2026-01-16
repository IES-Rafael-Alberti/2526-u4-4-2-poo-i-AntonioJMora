class Tiempo (val hora : Int, val minuto: Int = 0, val segundo : Int = 0) {
    init {
        if(hora !in 0..23) throw IllegalArgumentException("La hora debe estar entre 0 y 23")

    }
    override fun toString(): String {
        return "$hora h $minuto m $segundo s"
    }
}