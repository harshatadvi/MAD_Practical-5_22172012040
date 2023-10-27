package com.example.mad_practical_5_22172012040

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import java.net.URL
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val browsebutton:Button = findViewById(R.id.button)
        val call:Button = findViewById(R.id.button3)
        val callog:Button = findViewById(R.id.button5)
        val gallery:Button = findViewById(R.id.button6)
        val camera:Button = findViewById(R.id.button7)
        val alarm:Button = findViewById(R.id.button8)
        val editTextBrowser:EditText = findViewById(R.id.btext)
        val editTextCall:EditText = findViewById(R.id.ctext)
        browsebutton.setOnClickListener {
            openbrowse(editTextBrowser.text.toString())
        }
        call.setOnClickListener {
            call(editTextCall.text.toString())
        }
        callog.setOnClickListener {
            call_log()
        }
        gallery.setOnClickListener {
            gallery()
        }
        camera.setOnClickListener {
            camera()
        }
        alarm.setOnClickListener {
            alarm()
        }
    }
    fun openbrowse(s:String)
    {
        Intent(Intent.ACTION_VIEW, Uri.parse(s)).also {
            startActivity(it)
        }
    }
    fun call(n:String)
    {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$n")).also
        {
            var it = null
            startActivity(it)
        }
    }
    fun call_log()
    {
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also()
        {
            var it = null
            startActivity(it)
        }
    }
    fun gallery()
    {
        Intent(Intent.ACTION_VIEW).setType("image/*").also {
            startActivity(it)
        }
    }
    fun camera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
            startActivity(it)
        }
    }
    fun alarm()
    {
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also {
            startActivity(it)
        }
    }

}