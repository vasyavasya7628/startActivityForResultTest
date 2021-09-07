package com.example.startactivityforresulttest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val REQUEST_CODE_MESSAGE_ACTIVITY = 1
const val REQUEST_CODE_PHOTO_ACTIVITY = 1

class MainActivity : AppCompatActivity() {
    private lateinit var buttonStartActivityResult: Button
    private lateinit var buttonStartActivityPhoto: Button
    private lateinit var textGetData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStartActivityResult = findViewById(R.id.buttonStartActivityResult)
        buttonStartActivityPhoto = findViewById(R.id.buttonStartActivityPhoto)
        textGetData = findViewById(R.id.textGetData)

        buttonStartActivityPhoto.setOnClickListener {
            val intentResultActivity = Intent(this, PhoneActivity::class.java)
            startActivityForResult(intentResultActivity, REQUEST_CODE_PHOTO_ACTIVITY)
        }
        buttonStartActivityResult.setOnClickListener {
            val intentResultActivity = Intent(
                this,
                MessageActivity::class.java
            )
            startActivityForResult(
                intentResultActivity,
                REQUEST_CODE_MESSAGE_ACTIVITY
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            data == null -> {
                return
            }
            requestCode == REQUEST_CODE_MESSAGE_ACTIVITY -> {
                data.let {
                    val name: String = data.getStringExtra("name").toString()
                    textGetData.text = "Your name is $name"
                }
            }
            requestCode == REQUEST_CODE_PHOTO_ACTIVITY -> {
                val phone: String = data.getStringExtra("phone").toString()
                textGetData.text = "Your phone is $phone"
            }
        }
    }
}

