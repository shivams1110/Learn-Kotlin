package com.ssalphax.kotlinproject.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.ssalphax.kotlinproject.R
import com.ssalphax.kotlinproject.adapter.RecyclerAdapter
import com.ssalphax.kotlinproject.model.Contact
import com.ssalphax.kotlinproject.model.ContactResponse
import com.ssalphax.kotlinproject.rest.ApiClient
import com.ssalphax.kotlinproject.rest.ApiInterface

import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.content_recycler_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewActivity : AppCompatActivity() {

//    val items: List<Contact>?= null
    var adapter: RecyclerAdapter?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setSupportActionBar(toolbar)

//        val adapter: RecyclerAdapter = RecyclerAdapter()
//        recyclerView

        val linearLayout: LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayout



        fetchContacts()

    }

    private fun fetchContacts() {

        val apiService: ApiInterface = ApiClient.create().create(ApiInterface::class.java)

        val call : Call<ContactResponse> = apiService.getContacts()

        call.enqueue(object : Callback<ContactResponse>{
            override fun onFailure(call: Call<ContactResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ContactResponse>?, response: Response<ContactResponse>?) {

                val items: List<Contact> ?= response?.body()?.contacts

                recyclerView.adapter = items?.let { RecyclerAdapter(it, this@RecyclerViewActivity) }

            }

        })


    }

}
