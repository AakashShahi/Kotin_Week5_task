package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewActivity : AppCompatActivity() {
    lateinit var textview: TextView
    lateinit var btn1: Button
    lateinit var btn2:Button

    var counter=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new)

        textview=findViewById(R.id.textView)
        btn1=findViewById(R.id.button)
        btn2=findViewById(R.id.button2)
        
        btn1.setOnClickListener{

        }
    }
}