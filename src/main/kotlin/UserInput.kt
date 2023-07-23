class UserInput(unit: String) {
    val isLength: Boolean
    val isWeight: Boolean
    val isTemp: Boolean
    val lengthUnit: LengthUnit
    val weightUnit: WeightUnit
    val tempUnit: TempUnit
    val lengthOrWeightUnit: String
    val isUnit: Boolean
    init {
        lengthUnit = LengthUnit.getLengthUnit(unit)
        weightUnit = WeightUnit.getWeightUnit(unit)
        tempUnit = TempUnit.getTemperatureUnit(unit)
        isLength = lengthUnit != LengthUnit.NOT_LENGTH
        isWeight = weightUnit != WeightUnit.NOT_WEIGHT
        isTemp = tempUnit != TempUnit.NOT_TEMP
        lengthOrWeightUnit = lengthOrWeightUnitString()
        isUnit = isLength || isWeight || isTemp
    }

    private fun lengthOrWeightUnitString(): String {
        return if(isLength) {
            lengthUnit.plural
        } else if (isWeight) {
            weightUnit.plural
        } else if (isTemp) {
            tempUnit.namesList[1]
        } else {
            "???"
        }
    }
}