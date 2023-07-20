class Conversion {
    private val inputList = mutableListOf<String>()
    private var inputOneValue: Double = 0.0
    private lateinit var inputOneUnit: UserInput
    private lateinit var inputTwoUnit: UserInput
    fun convert(): Boolean {
        print("Enter what you want to convert (or exit): ")
        val input = readln()
        if(input == "exit") {
            return true
        } else {
            inputList.addAll(input.split(" ").toMutableList())
        }
        inputOneUnit = UserInput(inputList[1])
        inputTwoUnit = UserInput(inputList[3])
        inputOneValue = inputList[0].toDouble()

        if(inputOneUnit.isLength && inputTwoUnit.isLength) {
            printLengthConversion(inputOneValue, inputOneUnit.lengthUnit, inputTwoUnit.lengthUnit)
        } else if (inputOneUnit.isWeight && inputTwoUnit.isWeight) {
            printWeightConversion(inputOneValue, inputOneUnit.weightUnit, inputTwoUnit.weightUnit)
        } else {
            println("conversion from ${inputOneUnit.lengthOrWeightUnit} to ${inputTwoUnit.lengthOrWeightUnit} is impossible")
        }
        inputList.clear()
        return false
    }

    fun printLengthConversion(length: Double, lengthUnit: LengthUnit, lengthUnitTwo: LengthUnit) {
        val conversion = LengthUnit.getLengthUnitConversion(length, lengthUnit, lengthUnitTwo)
        println(
            "$length ${lengthUnit.getPluralOrSingular(length)} is $conversion ${lengthUnitTwo.getPluralOrSingular(conversion)}"
        )
    }

    fun printWeightConversion(weight: Double, weightUnit: WeightUnit, weightUnitTwo: WeightUnit) {
        val conversion = WeightUnit.getWeightUnitConversion(weight, weightUnit, weightUnitTwo)
        println(
            "$weight ${weightUnit.getPluralOrSingular(weight)} is $conversion ${weightUnitTwo.getPluralOrSingular(conversion)}"
        )
    }
}