package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin:Button
    private lateinit var tvsign: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin=findViewById(R.id.btnLogin)
        tvsign=findViewById(R.id.tvSignup)

        btnLogin.setOnClickListener{
            val intent=Intent(this,DashboardActivity::class.java)
            startActivity(intent)
        }
        tvsign.setOnClickListener{
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}