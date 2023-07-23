const val ABBR_KELVIN = "k"
const val SINGULAR_KELVIN = "kelvin"
const val PLURAL_KELVIN = "kelvins"
const val DEGREE_FAHRENHEIT = "degree Fahrenheit"
const val DEGREES_FAHRENHEIT = "degrees Fahrenheit"
const val FAHRENHEIT_ = "fahrenheit"
const val ABBR_DEGREE_FAHRENHEIT = "df"
const val ABBR_FAHRENHEIT = "f"
const val DEGREE_CELSIUS = "degree Celsius"
const val DEGREES_CELCIUS = "degrees Celsius"
const val CELSIUS_ = "celsius"
const val ABBR_DEGREE_CELSIUS = "dc"
const val ABBR_CELSIUS = "c"

enum class TempUnit(val namesList: List<String>) {
    KELVIN(listOf(SINGULAR_KELVIN, PLURAL_KELVIN, ABBR_KELVIN)),
    FAHRENHEIT(listOf(DEGREE_FAHRENHEIT, DEGREES_FAHRENHEIT, ABBR_FAHRENHEIT, ABBR_DEGREE_FAHRENHEIT, FAHRENHEIT_)),
    CELSIUS(listOf(DEGREE_CELSIUS, DEGREES_CELCIUS, ABBR_CELSIUS, ABBR_DEGREE_CELSIUS, CELSIUS_)),
    NOT_TEMP(listOf("???"));

    fun getPluralOrSingular(number: Number): String {
        return if (number == 1.0) {
            namesList[0]
        } else {
            namesList[1]
        }
    }

    companion object {
        fun getTemperatureUnit(userInput: String): TempUnit {
            val userInputLowerCase = userInput.lowercase()
            for (unit in entries) {
                for (name in unit.namesList) {
                    if (userInputLowerCase == name) {
                        return unit
                    }
                }
            }
            return NOT_TEMP
        }

        fun getConversion(unitAmount: Double, unit1: TempUnit, unit2: TempUnit): Double {
            if (unit1 == KELVIN) {
                if (unit2 == FAHRENHEIT) {
                    return getFahrenheitFromKelvin(unitAmount)
                } else if (unit2 == CELSIUS) {
                    return getCelsiusFromKelvin(unitAmount)
                }
            } else if (unit1 == FAHRENHEIT) {
                if (unit2 == KELVIN) {
                    return getKelvinFromFarenheit(unitAmount)
                } else if (unit2 == CELSIUS) {
                    return getCelsiusFromFahrenheit(unitAmount)
                }
            } else if (unit1 == CELSIUS) {
                if (unit2 == FAHRENHEIT) {
                    return getFahrenheitFromCelsius(unitAmount)
                } else if (unit2 == KELVIN) {
                    return getKelvinFromCelsius(unitAmount)
                }
            }
            return unitAmount
        }

        private fun getCelsiusFromKelvin(kelvin: Double): Double = kelvin - 273.15
        private fun getFahrenheitFromKelvin(kelvin: Double): Double = kelvin * (9.0/5.0) - 459.67
        private fun getKelvinFromFarenheit(fahrenheit: Double): Double = (fahrenheit + 459.67) * (5.0/9.0)
        private fun getCelsiusFromFahrenheit(fahrenheit: Double): Double = (fahrenheit - 32) * (5.0/9.0)
        private fun getKelvinFromCelsius(celsius: Double) = celsius + 273.15
        private fun getFahrenheitFromCelsius(celsius: Double) = celsius * (9.0/5.0) + 32

        fun printConversion(unitAmount: Double, unit1: TempUnit, unit2: TempUnit) {
            val conversion = getConversion(unitAmount, unit1, unit2)
            println(
                "$unitAmount ${unit1.getPluralOrSingular(unitAmount)} is $conversion ${unit2.getPluralOrSingular(conversion)}"
            )
        }
    }
}