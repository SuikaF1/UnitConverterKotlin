import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a number and a measure of length: ")
    val inputNumber = scanner.nextDouble()
    val inputUnit = scanner.next()

    when {
        isLengthUnit(LengthUnit.METER,inputUnit) -> {
            printConversion(inputNumber, LengthUnit.METER, inputNumber)
        }
        isLengthUnit(LengthUnit.KILOMETER,inputUnit) -> {
            printConversion(inputNumber, LengthUnit.KILOMETER, (inputNumber * 1000))
        }
        isLengthUnit(LengthUnit.CENTIMETER,inputUnit) -> {
            printConversion(inputNumber, LengthUnit.CENTIMETER, (inputNumber * .01))
        }
        isLengthUnit(LengthUnit.MILLIMETER,inputUnit) -> {
            printConversion(inputNumber, LengthUnit.MILLIMETER, (inputNumber * .001))
        }
        isLengthUnit(LengthUnit.MILE,inputUnit) -> {
            printConversion(inputNumber, LengthUnit.MILE, (inputNumber * 1609.35))
        }
        isLengthUnit(LengthUnit.YARD,inputUnit) -> {
            printConversion(inputNumber, LengthUnit.YARD, (inputNumber * 0.9144))
        }
        isLengthUnit(LengthUnit.FOOT,inputUnit) -> {
            printConversion(inputNumber, LengthUnit.FOOT, (inputNumber * 0.3048))
        }
        isLengthUnit(LengthUnit.INCH,inputUnit) -> {
            printConversion(inputNumber, LengthUnit.INCH, (inputNumber * 0.0254))
        }
        else -> {
            println("Wrong input. Unknown unit $inputUnit")
        }
    }

}

fun isLengthUnit(lengthUnit: LengthUnit, userInput: String): Boolean {
    return lengthUnit.abbreviated == userInput.lowercase() ||
            lengthUnit.singular == userInput.lowercase() ||
            lengthUnit.plural == userInput.lowercase()
}
fun printConversion(length: Double, lengthUnit: LengthUnit, lengthToMeters: Double) {
    println("$length ${lengthUnit.getPluralOrSingular(length)} is $lengthToMeters ${LengthUnit.METER.getPluralOrSingular(lengthToMeters)}")
}