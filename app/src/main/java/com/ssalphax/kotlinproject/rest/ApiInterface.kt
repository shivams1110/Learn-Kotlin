package com.ssalphax.kotlinproject.rest

import com.ssalphax.kotlinproject.model.ContactResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("contacts")
    fun getContacts() : Call<ContactResponse>

}