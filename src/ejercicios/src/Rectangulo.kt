class Rectangulo(val base : Double, val altura : Double) {
    val area = base * altura
    val perimetro = 2 * (base + altura)
    override fun toString(): String {
        return "Área = $area, Perímetro= $perimetro"
    }
}