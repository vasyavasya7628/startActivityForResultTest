package com.example.startactivityforresulttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        val buttonSendPhone: Button = findViewById(R.id.buttonSendPhone)
        val editTextPhone: EditText = findViewById(R.id.editTextPhone)

        buttonSendPhone.setOnClickListener {
            val intent = Intent()
            /*первыйпараметр ключ(имя) для того
             чтобы другое активити знало по какому ключу получить данные,
             второй - значение которое я хочу передать*/
            intent.putExtra("phone", editTextPhone.text.toString())

            setResult(
                RESULT_OK,
                intent
            )//статус RESULT_OK, указываем, что надо вернуть объект intent в качестве результата
            finish()
        }
    }
}