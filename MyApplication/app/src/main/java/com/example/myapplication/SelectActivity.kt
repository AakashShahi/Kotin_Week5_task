package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SelectActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var textName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_select)

        button= findViewById(R.id.navButton)
        textName= findViewById(R.id.editTextName)

        button.setOnClickListener {
            var intent= Intent(this@SelectActivity,SecondActivity::class.java)
            startActivity(intent)
            intent.putExtra("name",textName.text)
            finish()
        }

    }
}