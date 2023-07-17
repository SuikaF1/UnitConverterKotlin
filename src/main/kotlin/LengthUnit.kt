const val ABBR_METER = "m"
const val SINGULAR_METER = "meter"
const val PLURAL_METER = "meters"
const val ABBR_KILOMETER = "km"
const val SINGULAR_KILOMETER = "kilometer"
const val PLURAL_KILOMETER = "kilometers"
const val ABBR_CENTIMETERS = "cm"
const val SINGULAR_CENTIMETER = "centimeter"
const val PLURAL_CENTIMETER = "centimeters"
const val ABBR_MILLIMETERS = "mm"
const val SINGULAR_MILLIMETERS = "millimeter"
const val PLURAL_MILLIMETERS = "millimeters"
const val ABBR_MILE = "mi"
const val SINGULAR_MILE = "mile"
const val PLURAL_MILE = "miles"
const val ABBR_YARD = "yd"
const val SINGULAR_YARD = "yard"
const val PLURAL_YARD = "yards"
const val ABBR_FEET = "ft"
const val SINGULAR_FEET = "foot"
const val PLURAL_FEET = "feet"
const val ABBR_INCH = "in"
const val SINGULAR_INCH = "inch"
const val PLURAL_INCH = "inches"

enum class LengthUnit(val abbreviated: String, val singular: String, val plural: String) {
    METER(ABBR_METER, SINGULAR_METER, PLURAL_METER),
    KILOMETER(ABBR_KILOMETER, SINGULAR_KILOMETER, PLURAL_KILOMETER),
    CENTIMETER(ABBR_CENTIMETERS, SINGULAR_CENTIMETER, PLURAL_CENTIMETER),
    MILLIMETER(ABBR_MILLIMETERS, SINGULAR_MILLIMETERS, PLURAL_MILLIMETERS),
    MILE(ABBR_MILE, SINGULAR_MILE, PLURAL_MILE),
    YARD(ABBR_YARD, SINGULAR_YARD, PLURAL_YARD),
    FOOT(ABBR_FEET, SINGULAR_FEET, PLURAL_FEET),
    INCH(ABBR_INCH, SINGULAR_INCH, PLURAL_INCH);

    fun getPluralOrSingular(number: Double): String {
        return if (number == 1.0) {
            singular
        } else {
            plural
        }
    }
}