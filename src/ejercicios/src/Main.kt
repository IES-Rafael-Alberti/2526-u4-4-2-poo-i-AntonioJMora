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

}