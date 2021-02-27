package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnadd:Button
    private lateinit var btnview:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnadd=findViewById(R.id.btnaddstudent)
        btnview=findViewById(R.id.btnviewstudent)


        btnadd.setOnClickListener(this)
        btnview  .setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnaddstudent->{
                val intent= Intent(this,AddStudentActivity::class.java)
                startActivity(intent)
            }


            R.id.btnviewstudent->{
                val intent= Intent(this,ViewStudentActivity::class.java)
                startActivity(intent)
            }

        }
    }
}