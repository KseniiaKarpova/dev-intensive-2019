package ru.skillbranch.defintensive.utils

object Utils {

    fun parseFullName(fullName:String?): Pair<String?, String?> {
        val parts : List<String>? = fullName?.split(" ")

        val firstName = if  (parts?.getOrNull(0)=="") null  else parts?.getOrNull(0)
        val lastName = if (parts?.getOrNull(1)=="") null else parts?.getOrNull(1)

        return Pair(firstName, lastName)
    }

    fun toInitials(firstName:String?, lastName:String?):String?{
        var FL:String? = firstName?.getOrNull(0)?.toString() ?: " "
        FL += lastName?.getOrNull(0)?.toString() ?: " "
        FL = when (FL) {
            "" -> null
            " " -> null
            "  " -> null
            else -> FL!!.toUpperCase()
        }

        return FL
    }

    fun transliteration(payload:String?,  divider:String = " "):String?{
        var str:String? = ""
        val parts : List<String>? = payload?.split(" ")
        var s:String =parts?.getOrNull(0).toString()+ divider+ parts?.getOrNull(1).toString()
        s.forEach {
            str+=when(it){
                'а' ->"a"
                'б'-> "b"
                'в'-> "v"
                'г'-> "g"
                'д'-> "d"
                'е'-> "e"
                'ё'-> "e"
                'ж'-> "zh"
                'з'-> "z"
                'и'-> "i"
                'й'-> "i"
                'к'-> "k"
                'л'-> "l"
                'м'-> "m"
                'н'-> "n"
                'о'-> "o"
                'п'-> "p"
                'р'-> "r"
                'с'-> "s"
                'т'-> "t"
                'у'-> "u"
                'ф'-> "f"
                'х'-> "h"
                'ц'-> "c"
                'ч'-> "ch"
                'ш'-> "sh"
                'щ'-> "sh"
                'ъ'-> ""
                'ы'-> "i"
                'ь'-> ""
                'э'-> "e"
                'ю'-> "yu"
                'я'-> "ya"
                'А' ->"A"
                'Б'-> "B"
                'В'-> "V"
                'Г'-> "G"
                'Д'-> "D"
                'Е'-> "E"
                'ё'.toUpperCase()-> "E"
                'Ж'-> "Zh"
                'З'-> "Z"
                'И'-> "I"
                'Й'-> "I"
                'К'-> "K"
                'Л'-> "L"
                'М'-> "M"
                'Н'-> "N"
                'О'-> "O"
                'П'-> "P"
                'Р'-> "R"
                'С'-> "S"
                'Т'-> "T"
                'У'-> "U"
                'Ф'-> "F"
                'Х'-> "H"
                'Ц'-> "C"
                'Ч'-> "Ch"
                'Ш'-> "Sh"
                'Щ'-> "Sh"
                'Ъ'-> ""
                'Ы'-> "I"
                'Ь'-> ""
                'Э'-> "E"
                'Ю'-> "Yu"
                'Я'-> "Ya"
                else -> it
            }

        }
        return str

    }
}