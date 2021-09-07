package com.example.startactivityforresulttest

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var buttonStartActivity: Button
    private lateinit var textGetData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStartActivity = findViewById(R.id.buttonStartActivity)
        textGetData = findViewById(R.id.textGetData)

        buttonStartActivity.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return
        }else{
            data?.let {
                val name: String = data.getStringExtra("name").toString()
                textGetData.text = "Your name is $name"
            }
        }
    }
}

