package com.example.startactivityforresulttest

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
            /*1 параметр контекст this - MainActivity
            *2 параметр ResultActivity прописан в манифесте система, просматривая манифест, запустит активность*/
            val intentResultActivity = Intent(this, ResultActivity::class.java) //intent это объект обмена сообщениями, который можно использовать для запроса действия от другой активити.
            startActivityForResult(intentResultActivity, 1) //Отличие от обычного startActivity в том, что MainActivity становится «родителем» для ResultActivity
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

