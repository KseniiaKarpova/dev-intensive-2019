package ru.skillbranch.defintensive.extensions
import  java.util.*
import  java.text.SimpleDateFormat

const val SECOND = 1000L
const val MINUTE = 60L * SECOND
const val HOUR = 60L * MINUTE
const val DAY = 24L * HOUR
fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dataFormat = SimpleDateFormat(pattern, Locale("ru"))

    return dataFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits):Date{
    var time = this.time
    time+= when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this

}
fun Date.humanizeDiff(date:Date=Date()): String? {

    var t:Long = date.time - this.time
    val isPast:Boolean = if(t<0) false else true
    var str:String?

    if(isPast) {
        str = when (t) {
            0 * SECOND, 1 * SECOND -> "только что"
            in 2..45 * SECOND -> "несколько секунд назад"
            in 45..75 * SECOND -> "минуту назад"
            in 76 * SECOND..45 * MINUTE -> "${TimeUnits.MINUTE.plural((t/MINUTE).toInt())} назад"
            in 45 * MINUTE..75 * MINUTE -> "час назад"
            in 75 * MINUTE..22 * HOUR -> "${TimeUnits.HOUR.plural((t / HOUR).toInt())} назад"
            in 22 * HOUR..26 * HOUR -> "день назад"
            in 26 * HOUR..360 * DAY -> "${TimeUnits.DAY.plural((t / DAY).toInt())} назад"
            else -> "более года назад"
        }
    }else{
        str = when(t){
            -1* SECOND -> "сейчас"
            in -45* SECOND.. -2 * SECOND -> "через несколько секунд"
            in -75* SECOND..-45 * SECOND -> "через минуту"
            in -45* MINUTE.. -75* SECOND ->"через ${TimeUnits.MINUTE.plural(-(t / MINUTE).toInt())}"
            in -75* MINUTE.. -45* MINUTE -> "через час"
            in -22* HOUR .. -75* MINUTE -> "через ${TimeUnits.HOUR.plural(-(t / HOUR).toInt())}"
            in -26* HOUR  .. -22* HOUR -> "через день"
            in -360* DAY ..-26 * HOUR -> "через ${TimeUnits.DAY.plural(-(t / DAY).toInt())}"
            else -> "более чем через год"
        }
    }


    return str
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(i:Int):String?{
        return when(this){
            TimeUnits.MINUTE -> when{
                i in 5..20 -> "$i минут"
                i%10 in 2..4 -> "$i минуты"
                i%10 == 1 -> "$i минуту"
                else -> "$i минут"
            }
            TimeUnits.HOUR -> when{
                i in 5..20 -> "$i часов"
                i%10 in 2..4 -> "$i часа"
                i%10 == 1 -> "$i час"
                else -> "$i часов"
            }
            TimeUnits.DAY -> when{
                i in 5..20 -> "$i дней"
                i%10 in 2..4 -> "$i дня"
                i%10 == 1 -> "$i день"
                else -> "$i дней"
            }
            else -> when{
                i in 5..20 -> "$i секунд"
                i%10 in 2..4 -> "$i секунды"
                i%10 == 1 -> "$i секунду"
                else -> "$i секунд"
            }
        }
    }
}