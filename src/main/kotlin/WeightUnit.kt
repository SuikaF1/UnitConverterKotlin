const val ABBR_GRAM = "g"
const val SINGULAR_GRAM = "gram"
const val PLURAL_GRAM = "grams"
const val GRAM_TO_GRAM = 1.0
const val ABBR_KILOGRAM = "kg"
const val SINGULAR_KILOGRAM = "kilogram"
const val PLURAL_KILOGRAM = "kilograms"
const val KILOGRAM_TO_GRAMS = 1000.0
const val ABBR_MILLIGRAM = "mg"
const val SINGULAR_MILLIGRAM = "milligrams"
const val PLURAL_MILLIGRAM = "milligrams"
const val MILLIGRAM_TO_GRAMS = 0.001
const val ABBR_POUND = "lb"
const val SINGULAR_POUND = "pound"
const val PLURAL_POUND = "pounds"
const val POUND_TO_GRAMS = 453.592
const val ABBR_OUNCE = "oz"
const val SINGULAR_OUNCE = "ounce"
const val PLURAL_OUNCE = "ounces"
const val OUNCE_TO_GRAMS = 28.3495
const val NOT_WEIGHT_STRING = "NOT WEIGHT"
const val NOT_WEIGHT_VALUE = -1.0

enum class WeightUnit(
    val abbreviated: String,
    val singular: String,
    val plural: String,
    val unitToGrams: Double = GRAM_TO_GRAM
) {
    GRAM(ABBR_GRAM, SINGULAR_GRAM, PLURAL_GRAM),
    KILOGRAM(ABBR_KILOGRAM, SINGULAR_KILOGRAM, PLURAL_KILOGRAM, KILOGRAM_TO_GRAMS),
    MILLIGRAM(ABBR_MILLIGRAM, SINGULAR_MILLIGRAM, PLURAL_MILLIGRAM, MILLIGRAM_TO_GRAMS),
    POUND(ABBR_POUND, SINGULAR_POUND, PLURAL_POUND, POUND_TO_GRAMS),
    OUNCE(ABBR_OUNCE, SINGULAR_OUNCE, PLURAL_OUNCE, OUNCE_TO_GRAMS),
    NOT_WEIGHT(NOT_WEIGHT_STRING, NOT_WEIGHT_STRING, NOT_WEIGHT_STRING, NOT_WEIGHT_VALUE);

    fun getPluralOrSingular(number: Double): String {
        return if (number == 1.0) {
            singular
        } else {
            plural
        }
    }

    companion object {
        fun getWeightUnit(userInput: String): WeightUnit {
            val userInputLowerCase = userInput.lowercase()
            for(unit in entries) {
                if(unit.abbreviated == userInputLowerCase ||
                    unit.singular == userInputLowerCase ||
                    unit.plural == userInputLowerCase) {
                    return unit
                }
            }
            return NOT_WEIGHT
        }

        fun getWeightUnitConversion(weight: Double, weightUnit: WeightUnit, weightUnitTwo: WeightUnit): Double =
            (weight * weightUnit.unitToGrams) / weightUnitTwo.unitToGrams
    }
}