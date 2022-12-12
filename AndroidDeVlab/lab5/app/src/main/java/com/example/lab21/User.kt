package com.example.lab21

import android.os.Parcelable
import java.io.Serializable
import java.util.Objects

class User(email:String, password:String): Serializable
{
    val _userEmail:String = email
    val _userPassword:String = password

    val EMAIL_KEY = "e"
    val PASSWORD_KEY = "p"

    fun userMap():HashMap<String,String>
    {
        val userMap:HashMap<String,String> = HashMap()
        userMap.put(EMAIL_KEY,_userEmail)
        userMap.put(PASSWORD_KEY,_userPassword)

        return userMap
    }
}