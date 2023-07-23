class Conversion {
    private var inputOneValue: Double = 0.0
    private lateinit var inputOneUnit: UserInput
    private lateinit var inputTwoUnit: UserInput
    fun convert(): Boolean {
        print("Enter what you want to convert (or exit): ")
        val input = readln()
        val inputList = mutableListOf<String>()
        if (input == "exit") {
            return true
        } else {
            inputList.addAll(inputParser(input))
        }
        if (inputList[0] == "Parse error") {
            println(inputList[0])
            return false
        }
        inputOneUnit = UserInput(inputList[1])
        inputTwoUnit = UserInput(inputList[3])
        inputOneValue = inputList[0].toDouble()

        if (inputOneUnit.isLength && inputTwoUnit.isLength) {
            if (inputOneValue < 0) {
                println("Length shouldn't be negative")
            } else {
                LengthUnit.printConversion(inputOneValue, inputOneUnit.lengthUnit, inputTwoUnit.lengthUnit)
            }
        } else if (inputOneUnit.isWeight && inputTwoUnit.isWeight) {
            if (inputOneValue < 0) {
                println("Weight shouldn't be negative")
            } else {
                WeightUnit.printWeightConversion(inputOneValue, inputOneUnit.weightUnit, inputTwoUnit.weightUnit)
            }
        } else if (inputOneUnit.isTemp && inputTwoUnit.isTemp) {
            TempUnit.printConversion(inputOneValue, inputOneUnit.tempUnit, inputTwoUnit.tempUnit)
        } else {
            println("conversion from ${inputOneUnit.lengthOrWeightUnit} to ${inputTwoUnit.lengthOrWeightUnit} is impossible")
        }
        inputList.clear()
        return false
    }

    fun inputParser(userInput: String): List<String> {
        val inputSplit = userInput.split(" ").toMutableList()
        val degreeRemoval = inputSplit.filter { it.lowercase() != "degree" && it.lowercase() != "degrees" }
        return if (degreeRemoval.size == 4 &&
            degreeRemoval[0].toDoubleOrNull() != null &&
            (UserInput(degreeRemoval[1]).isUnit || UserInput(degreeRemoval[3]).isUnit)
        ) {
            degreeRemoval
        } else {
            listOf("Parse error")
        }
    }
}