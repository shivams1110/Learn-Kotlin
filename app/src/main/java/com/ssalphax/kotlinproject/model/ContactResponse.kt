package com.ssalphax.kotlinproject.model

import com.google.gson.annotations.SerializedName

data class ContactResponse(@SerializedName("contacts")
                           private val contact: List<Contact>?= null) {

    val contacts get() = contact
}