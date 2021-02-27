package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.adapter.StudentAdapter
import com.example.roomdatabase.model.Student

class ViewStudentActivity : AppCompatActivity() {
    private var lstStudent=ArrayList<Student>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        recyclerView=findViewById(R.id.recyclerView)

        loadStudent()
        val adapter= StudentAdapter(lstStudent,this)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter





    }
    private fun loadStudent(){
        lstStudent.add(Student(1,"Mansur","Thapa",20,"Male","Bhaktapur"))
        lstStudent.add(Student(2,"Ravi","Paudel",20,"Male","Bardiya"))

    }


}