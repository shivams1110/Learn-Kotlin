package com.ssalphax.kotlinproject.activity

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.ssalphax.kotlinproject.R
import com.ssalphax.kotlinproject.animation.AnimationActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        edtName.setText("Satyam")
        val name = edtName.text

        btnSubmit.setOnClickListener {
//            Toast.makeText(this,"Hello"+name, Toast.LENGTH_SHORT).show()
            showAlert()

        }

        btnNotification.setOnClickListener {
            showNotification()
        }

        btnList.setOnClickListener {
            val intent = Intent(this@MainActivity, ListActivity::class.java)
            intent.putExtra("value","Shivam")
            startActivity(intent)
        }

        btnAnimation.setOnClickListener {

            val intent = Intent(this@MainActivity, AnimationActivity::class.java)
            startActivity(intent)

        }

        btnRecycler.setOnClickListener {
            val intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btnFragment.setOnClickListener {
            val intent = Intent(this@MainActivity, FragmentNavActivity::class.java)
            startActivity(intent)
        }



    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun showNotification() {


        val channelId = NotificationChannel("1","test",NotificationManager.IMPORTANCE_DEFAULT)

        Toast.makeText(this,"Hello Notification", Toast.LENGTH_SHORT).show()
        val intent = Intent(applicationContext, MainActivity::class.java)
//        intent.addFlags(Intent.Fla)
        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, 0)
        val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notificationBuilder = NotificationCompat.Builder(applicationContext)
                .setContentText("Test Dummy Notification")
                .setAutoCancel(true)
                .setSound(uri)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setChannelId("1")
                .setContentIntent(pendingIntent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channelId)
        notificationManager.notify(0, notificationBuilder.build())


    }

    private fun showAlert() {
        val builder  = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Test Alert Dialog")
        builder.setMessage("Alert Dialog Work Fine "+ edtName.text)

        builder.setPositiveButton("Yes"){dialogInterface, i ->
            Toast.makeText(this, "Yes work fine", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("No"){dialogInterface, i ->
            Toast.makeText(this, "Not fine", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }

        val dialog: AlertDialog = builder.create()

        dialog.show()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
