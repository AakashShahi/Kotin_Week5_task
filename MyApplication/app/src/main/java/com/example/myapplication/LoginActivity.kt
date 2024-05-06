package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginAppBinding

class LoginActivity : AppCompatActivity() {
    lateinit var pageBinding: ActivityLoginAppBinding
    lateinit var sharedPreferences: SharedPreferences

    var username: String? = null
    var password: String? = null
    var rememberMe: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        pageBinding = ActivityLoginAppBinding.inflate(layoutInflater)
        val view = pageBinding.root
        setContentView(view)

        // Registration
        pageBinding.btnRegister.setOnClickListener {
            sharedPreferences = this.getSharedPreferences("UserDetail", MODE_PRIVATE)
            username = pageBinding.editUsername.text.toString()
            password = pageBinding.editPassword.text.toString()
            rememberMe = pageBinding.rememberBox.isChecked

            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.putBoolean("remember", rememberMe!!)

            editor.apply()
            Toast.makeText(applicationContext, "Successfully Registered", Toast.LENGTH_LONG)
                .show()
        }

        // Login
        pageBinding.btnLogin.setOnClickListener {
            sharedPreferences = this.getSharedPreferences(
                "UserDetail",
                MODE_PRIVATE
            ) // Use the same SharedPreferences key used for registration
            val savedUsername = sharedPreferences.getString("username", "No value")
            val savedPassword = sharedPreferences.getString("password", "No value")

            val checkUser = pageBinding.editUsername.text.toString()
            val checkPass = pageBinding.editPassword.text.toString()

            if (checkUser == savedUsername && checkPass == savedPassword) {
                // Start the next activity
                val intent = Intent(this, MessageActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    applicationContext,
                    "Invalid username or password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    override fun onPause() {
        sharedPreferences = this.getSharedPreferences("UserDetail", MODE_PRIVATE)

        username = pageBinding.editUsername.text.toString()
        password=pageBinding.editPassword.text.toString()
        rememberMe=pageBinding.rememberBox.isChecked


        var editor=sharedPreferences.edit()
        editor.putString("username",username)
        editor.putString("password",password)
        editor.putBoolean("remember",rememberMe!!)

        editor.apply()
        Toast.makeText(applicationContext,"data saved",Toast.LENGTH_LONG).show()
        super.onPause()
    }

    override fun onResume() {
        sharedPreferences = this.getSharedPreferences("UserDetail", MODE_PRIVATE)
        username=sharedPreferences.getString("username","No value")
        password=sharedPreferences.getString("password","No value")
        rememberMe=sharedPreferences.getBoolean("remember",false)
        super.onResume()
        if(rememberMe==true) {
            pageBinding.editUsername.setText(username)
            pageBinding.editPassword.setText(password)
        }
    }

}
