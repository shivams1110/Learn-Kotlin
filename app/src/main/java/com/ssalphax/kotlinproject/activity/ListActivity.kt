package com.ssalphax.kotlinproject.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.ssalphax.kotlinproject.R

import kotlinx.android.synthetic.main.activity_next_actitvity.*
import kotlinx.android.synthetic.main.content_next_actitvity.*

class ListActivity : AppCompatActivity() {

    val values = arrayOf("hello","world","Explain","Me","Very","Well","with","good","Example")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_actitvity)
        setSupportActionBar(toolbar)

        var value: String = this.intent.getStringExtra("value")

        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, values)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            Toast.makeText(this, values[i],Toast.LENGTH_SHORT).show()

        }


    }

}
