package com.ssalphax.kotlinproject.animation

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import com.ssalphax.kotlinproject.R

import kotlinx.android.synthetic.main.activity_animation.*
import kotlinx.android.synthetic.main.content_animation.*

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


        btnZoom.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.zoom)
            txtAnimate.startAnimation(animation)
        }

        btnClock.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.clockwise)
            txtAnimate.startAnimation(animation)
        }

        btnFade.setOnClickListener {
            val animation =AnimationUtils.loadAnimation(this, R.anim.fade)
            txtAnimate.startAnimation(animation)
        }

        btnBlinnk.setOnClickListener {
            val  animation = AnimationUtils.loadAnimation(this, R.anim.blink)
            txtAnimate.startAnimation(animation)
        }

        btnMove.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.move)
            txtAnimate.startAnimation(animation)
        }

        btnSlide.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.slide)
            txtAnimate.startAnimation(animation)
        }




    }

}
