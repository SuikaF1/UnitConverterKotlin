class UserInput(unit: String) {
    val isLength: Boolean
    val isWeight: Boolean
    val lengthUnit: LengthUnit
    val weightUnit: WeightUnit
    val lengthOrWeightUnit: String
    init {
        lengthUnit = LengthUnit.getLengthUnit(unit)
        weightUnit = WeightUnit.getWeightUnit(unit)
        isLength = lengthUnit != LengthUnit.NOT_LENGTH
        isWeight = weightUnit != WeightUnit.NOT_WEIGHT
        lengthOrWeightUnit = lengthOrWeightUnitString()
    }

    private fun lengthOrWeightUnitString(): String {
        return if(isLength) {
            lengthUnit.plural
        } else if (isWeight) {
            weightUnit.plural
        } else {
            "???"
        }
    }
}