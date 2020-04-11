package ru.skillbranch.defintensive.models

import java.util.*

class User (
    val id:String?,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline:Boolean = false
){
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id=id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id: String) : this(id, "Kseniia", "karp $id")

    init {
        println("Hi, I am $firstName $lastName")
    }
    fun printMe():Unit{
        println("""
        id:$id,
        firstName:$firstName,
        lastName:$lastName,
        avatar:$avatar,
        rating:$rating,
        respect:$respect,
        lastVisit: $lastVisit,
        isOnline:$isOnline    
        """)
    }
    companion object Factory {
        private var lastId: Int = -1
        fun makeUser (fullName:String?) : User{
            lastId++

            val parts : List<String>? = fullName?.split(" ")

            val firstName = if  (parts?.getOrNull(0)=="") null  else parts?.getOrNull(0)
            val lastName = if (parts?.getOrNull(1)=="") null else parts?.getOrNull(1)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }

    data class Builder(
        var id:String? = null,
        var firstName:String?  = null,
        var lastName:String? = null,
        var avatar:String? = null,
        var rating:Int = 0,
        var respect:Int = 0,
        var lastVisit: Date? = Date(),
        var isOnline:Boolean = false
    ){
        fun id(id:String)= apply { this.id = id }
        fun firstName(firstName:String)= apply { this.firstName = firstName }
        fun lastName(lastName:String)= apply { this.lastName = lastName }
        fun avatar(avatar:String)= apply { this.avatar = avatar }
        fun rating(rating:Int)= apply { this.rating = rating }
        fun respect(respect:Int)= apply { this.respect = respect }
        fun lastVisit(lastVisit:Date)= apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline:Boolean)= apply { this.isOnline = isOnline }
        fun build() = User(id,firstName,lastName, avatar, rating, respect, lastVisit, isOnline)
    }


}