class Persona(var peso : Double, var altura : Double) {
    val imc : Double
        get() = peso / (altura * altura)
    var nombre : String? = null
        set(value){
            if(!value.isNullOrBlank()){
                field = value
            }
        }

    constructor(peso: Double, altura: Double, nombre: String) : this(peso, altura){
        this.nombre = nombre
    }


    override fun toString(): String {
        return "Nombre: $nombre, Peso: $peso, Altura: $altura, IMC: $imc"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Persona){
            return false
        }
        return (nombre == other.nombre && altura == other.altura && peso == other.peso)

    }

    fun saludar(): String{
        return "Hola $nombre"
    }
    fun alturaEncimaMedia(): Boolean{
        if(altura >= 1.75){
            return true
        }
        return false
    }
    fun pesoEncimaMedia(): Boolean{
        if (peso >= 70){
            return true
        }
        return false
    }
    fun obtenerDescImc(): String{
        if (imc < 18.5){
            return "Peso insuficiente"
        }else if (imc > 18.5 && imc <= 24.9){
            return "Peso saludable"
        }else if (imc in 25.0..29.9){
            return "Sobrepeso"
        }else if (imc >= 30){
            return "Obesidad"
        }
        return ""
    }
    fun obtenerDesc(): String{
        return "$nombre con una altura de $altura ${if (alturaEncimaMedia()) "(Por encima de la media)" else "(Por debajo de la media)"} y un peso de $peso ${if (pesoEncimaMedia()) "(Por encima de la media)" else "(Por debajo de la media)"} tiene un IMC de $imc (${obtenerDescImc()})"
    }
}