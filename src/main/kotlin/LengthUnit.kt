const val ABBR_METER = "m"
const val SINGULAR_METER = "meter"
const val PLURAL_METER = "meters"
const val METER_TO_METER = 1.0
const val ABBR_KILOMETER = "km"
const val SINGULAR_KILOMETER = "kilometer"
const val PLURAL_KILOMETER = "kilometers"
const val KILOMETER_TO_METERS = 1000.0
const val ABBR_CENTIMETERS = "cm"
const val SINGULAR_CENTIMETER = "centimeter"
const val PLURAL_CENTIMETER = "centimeters"
const val CENTIMETER_TO_METERS = .01
const val ABBR_MILLIMETERS = "mm"
const val SINGULAR_MILLIMETERS = "millimeter"
const val PLURAL_MILLIMETERS = "millimeters"
const val MILLIMETER_TO_METERS = .001
const val ABBR_MILE = "mi"
const val SINGULAR_MILE = "mile"
const val PLURAL_MILE = "miles"
const val MILE_TO_METERS = 1609.35
const val ABBR_YARD = "yd"
const val SINGULAR_YARD = "yard"
const val PLURAL_YARD = "yards"
const val YARD_TO_METERS = .9144
const val ABBR_FEET = "ft"
const val SINGULAR_FEET = "foot"
const val PLURAL_FEET = "feet"
const val FOOT_TO_METERS = .3048
const val ABBR_INCH = "in"
const val SINGULAR_INCH = "inch"
const val PLURAL_INCH = "inches"
const val INCH_TO_METERS = .0254
const val NOT_LENGTH_STRING = "NOT LENGTH"
const val NOT_LENGTH_VALUE = -1.0

enum class LengthUnit(
    val abbreviated: String,
    val singular: String,
    val plural: String,
    val unitToMeters: Double = METER_TO_METER
) {
    METER(ABBR_METER, SINGULAR_METER, PLURAL_METER),
    KILOMETER(ABBR_KILOMETER, SINGULAR_KILOMETER, PLURAL_KILOMETER, KILOMETER_TO_METERS),
    CENTIMETER(ABBR_CENTIMETERS, SINGULAR_CENTIMETER, PLURAL_CENTIMETER, CENTIMETER_TO_METERS),
    MILLIMETER(ABBR_MILLIMETERS, SINGULAR_MILLIMETERS, PLURAL_MILLIMETERS, MILLIMETER_TO_METERS),
    MILE(ABBR_MILE, SINGULAR_MILE, PLURAL_MILE, MILE_TO_METERS),
    YARD(ABBR_YARD, SINGULAR_YARD, PLURAL_YARD, YARD_TO_METERS),
    FOOT(ABBR_FEET, SINGULAR_FEET, PLURAL_FEET, FOOT_TO_METERS),
    INCH(ABBR_INCH, SINGULAR_INCH, PLURAL_INCH, INCH_TO_METERS),
    NOT_LENGTH(NOT_LENGTH_STRING, NOT_LENGTH_STRING, NOT_LENGTH_STRING, NOT_LENGTH_VALUE);

    fun getPluralOrSingular(number: Double): String {
        return if (number == 1.0) {
            singular
        } else {
            plural
        }
    }


    companion object {
        fun getLengthUnit(userInput: String): LengthUnit {
            val userInputLowerCase = userInput.lowercase()
            for (unit in entries) if (unit.abbreviated == userInputLowerCase ||
                unit.singular == userInputLowerCase ||
                unit.plural == userInputLowerCase
            ) {
                return unit
            }
            return NOT_LENGTH
        }

        private fun getConversion(
            unitAmount: Double,
            unit1: LengthUnit,
            unit2: LengthUnit = METER
        ): Double =
            (unitAmount * unit1.unitToMeters) / unit2.unitToMeters

        fun printConversion(length: Double, lengthUnit: LengthUnit, lengthUnitTwo: LengthUnit) {
            val conversion = getConversion(length, lengthUnit, lengthUnitTwo)
            println(
                "$length ${lengthUnit.getPluralOrSingular(length)} is $conversion ${lengthUnitTwo.getPluralOrSingular(conversion)}"
            )
        }
    }
}