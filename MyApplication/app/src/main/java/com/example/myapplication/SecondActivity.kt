package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    lateinit var  button: Button
    lateinit var textName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        textName=findViewById(R.id.textViewName)

        var name  = intent.getStringExtra("name")
        var address  = intent.getStringExtra("address")

        textName.text = "your name is $name and your address is $address"


    }
}