package com.example.startactivityforresulttest

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent




class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val button: Button = findViewById(R.id.button2)
        val textEdit: EditText = findViewById(R.id.editTextTextPersonName2)

        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", textEdit.text.toString())//передать данные простейших типов в другую активити
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}