package com.example.startactivityforresulttest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val button: Button = findViewById(R.id.button2)
        val textEdit: EditText = findViewById(R.id.editTextTextMessage)

        button.setOnClickListener {
            val intent = Intent()
            /*первыйпараметр ключ(имя) для того
             чтобы другое активити знало по какому ключу получить данные,
             второй - значение которое я хочу передать*/
            intent.putExtra("name", textEdit.text.toString())

            setResult(
                RESULT_OK,
                intent
            )//статус RESULT_OK, указываем, что надо вернуть объект intent в качестве результата
            finish()
        }
    }
}