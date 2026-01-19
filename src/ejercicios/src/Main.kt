fun main() {

    // Rectángulo
    val rectangulo1 = Rectangulo(10.2,15.0)
    val rectangulo2 = Rectangulo(12.3,10.4)
    val rectangulo3 = Rectangulo(8.1,3.6)
    println(rectangulo1.toString())
    println(rectangulo2.toString())
    println(rectangulo3.toString())

    println()
    println("****************************")
    println()

    //Persona
    val persona1 = Persona(87.4, 1.78)
    val persona2 = Persona(88.5, 1.90, "Juan")
    val persona3 = Persona(55.27, 1.59, "Rosa")

    println("Introduzca el nombre de la persona")
    persona1.nombre = readln()
    println("Nombre: ${persona1.nombre}, Peso = ${persona1.peso}, Altura = ${persona1.altura}")

    println("Peso = ${persona3.peso}, Altura = ${persona3.altura}, IMC = ${persona3.imc}")
    persona3.altura = 1.80
    println("Peso = ${persona3.peso}, Altura = ${persona3.altura}, IMC = ${persona3.imc}")

    persona2.altura = persona3.altura
    println(persona2.toString())
    println(persona3.toString())
    println("Las personas ${if (persona2 == persona3) "si" else "no"} son iguales")
    println("Las personas ${if (persona1.equals(persona2)) "si" else "no"} son iguales")

    println()
    println("****************************")
    println()

    //Ejercicio 4.3
    val persona4 = Persona(88.5, 1.9, "Ivan")
    val persona5 = Persona(49.5, 1.65, "Paca")

    val listaPersonas = listOf(persona1, persona2, persona3, persona4, persona5)

    for (persona in listaPersonas) {
        println(persona.saludar())
        println(persona.obtenerDesc())
        println()
    }

    println()
    println("****************************")
    println()

    // Ejercicio 4.4 Coche
    //Coche con marca y modelo nulos
    try {
        val coche1 = Coche(null, null, 76, 4, "1232ert", "Blanco")
        println(coche1)
    }catch (e: Exception){
        println(e.message)
    }
    //Coche con numero de caballos inferior a 70
    try {
        val coche2 = Coche("Kia", "Sportage", 40, 4, "1232ert", "Negro")
        println(coche2)
    }catch (e: Exception){
        println(e.message)
    }
    //Coche con número de puertas con valor inferior o superior
    try {
        val coche3 = Coche("Ford", "Focus", 300, 2, "1232ert", "Gris")
        println(coche3)
    }catch (e: Exception){
        println(e.message)
    }
    //Coche con matricula con valor no compatible
    try {
        val coche4 = Coche("Kia", "Sportage",500,4,"122","Azul")
        println(coche4)
    }catch (e: Exception){
        println(e.message)
    }
    //Color nulo
    try {
        val coche5 = Coche("Kia", "Sportage",500,4,"1232ert", null)
        println(coche5)
    }catch (e: Exception){
        println(e.message)
    }

    println()
    println("****************************")
    println()

    //Ejercicio 4.5 Tiempo
    println("Introduce la hora actual (23:59:59): ")
    val horaActual = readln()
    val parteHora = horaActual.split(":")
    var h : Int = 0
    var m : Int = 0
    var s : Int = 0
    try {
        h = parteHora[0].toInt()
    }catch (e: Exception){
        h = 0
    }
    try {
        m = parteHora[1].toInt()
    }catch (e: Exception){
        m = 0
    }
    try {
        s = parteHora[2].toInt()
    }catch (e: Exception){
        s = 0
    }

    val tiempo = Tiempo(h, m, s)
    println(tiempo.toString())

    println("Introduce el tiempo a añadir:")
    val horaAñadir = readln()
    val parteAñadida = horaAñadir.split(":")
    var hAñadida : Int = 0
    var mAñadida : Int = 0
    var sAñadida : Int = 0
    try {
        hAñadida = parteAñadida[0].toInt()
    }catch (e: Exception){
        hAñadida = 0
    }
    try {
        mAñadida = parteAñadida[1].toInt()
    }catch (e: Exception){
        mAñadida = 0
    }
    try {
        sAñadida = parteAñadida[2].toInt()
    }catch (e: Exception){
        sAñadida = 0
    }

    val tiempoAñadido = Tiempo(hAñadida,mAñadida,sAñadida)

    if(tiempo.incrementar(tiempoAñadido)){
        println("Tiempo despues de incrementar : $tiempo")
    }else{
        println("No se puede incrementar, pasa de 23:59:59")
    }

    if(tiempo.decrementar(tiempoAñadido)){
        println("Tiempo despues de decrementar : $tiempo")
    }else{
        println("No se puede incrementar, baja de 00:00:00")
    }

    val comparar = tiempo.comparar(tiempoAñadido)
    val comparacion = when (comparar) {
        -1 -> "menor que"
        0 -> "igual a"
        1 -> "mayor que"
        else -> ""
    }

    println("El tiempo inicial es $comparacion el tiempo añadido")

    val copia = tiempo.copiar()
    println("Copia del tiempo inicial: $copia")

    tiempo.copiar(tiempoAñadido)
    println("Tiempo después de copiar t: $tiempo")

    val suma = tiempo.sumar(tiempoAñadido)
    if (suma != null) {
        println("Resultado de la suma: $suma")
    } else {
        println("Error: la suma supera 23:59:59")
    }

    val resta = tiempo.restar(tiempoAñadido)
    if (resta != null) {
        println("Resultado de la resta: $resta")
    } else {
        println("Error: la resta baja de 00:00:00")
    }

    if (tiempo.esMayorQue(tiempoAñadido)) {
        println("El tiempo inicial es mayor que el tiempo añadido")
    } else {
        println("El tiempo inicial NO es mayor que el tiempo añadido")
    }

    if (tiempo.esMenorQue(tiempoAñadido)) {
        println("El tiempo inicial es menor que el tiempo añadido")
    } else {
        println("El tiempo inicial NO es menor que el tiempo añadido")
    }
}