package com.ssalphax.kotlinproject.model

import com.google.gson.annotations.SerializedName

data class Contact(@SerializedName("id")
                   val _id: String?= null,

                   @SerializedName("name")
                   val _name: String? = null,

                   @SerializedName("email")
                   val _email: String? = null,

                   @SerializedName("address")
                   val _address: String? = null,
                   @SerializedName("gender")
                   val _gender: String? = null){

    val id get() = _id
    val name get() = _name
    val email get() = _email
    val address get() = _address
    val gender get() = _gender

}