package com.ssalphax.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssalphax.kotlinproject.R
import com.ssalphax.kotlinproject.model.Contact
import kotlinx.android.synthetic.main.layout_recycler.view.*

class RecyclerAdapter (val items: List<Contact>, val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {


        holder.name?.text = items[position].name
        holder.email?.text = items[position].email
        holder.address?.text = items[position].address

    }


    class ViewHolder (view: View): RecyclerView.ViewHolder(view){

        val name = view.txtName
        val email = view.txtemail
        val address = view.txtaddress
    }

}