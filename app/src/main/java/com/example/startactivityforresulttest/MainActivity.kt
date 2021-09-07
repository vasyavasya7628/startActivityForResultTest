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
            /*1 параметр контекст this - MainActivity
            *2 параметр ResultActivity прописан в манифесте система, просматривая манифест, запустит активность*/
            val intentResultActivity = Intent(
                this,
                MessageActivity::class.java
            ) //intent это объект обмена сообщениями, который можно использовать для запроса действия от другой активити.
            startActivityForResult(
                intentResultActivity,
                REQUEST_CODE_MESSAGE_ACTIVITY
            ) //Отличие от обычного startActivity в том, что MainActivity становится «родителем» для ResultActivity
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return
        } else {
            data?.let {
                val name: String = data.getStringExtra("name").toString()
                textGetData.text = "Your name is $name"
            }
        }
    }
}

