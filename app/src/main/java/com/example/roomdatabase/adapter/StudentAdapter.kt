package com.example.roomdatabase.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roomdatabase.EditActivity
import com.example.roomdatabase.R
import com.example.roomdatabase.model.Student
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter(
    val lstStudent:ArrayList<Student>,
    val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {



    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view)
    {

        val tvName: TextView
        val tvAge: TextView
        lateinit var ivdel: ImageView
        lateinit var ivedit: ImageView

        init {
            tvName=view.findViewById(R.id.tvName)
            tvAge=view.findViewById(R.id.tvAge)
            ivdel=view.findViewById(R.id.ivdelete)
            ivedit=view.findViewById(R.id.ivedit)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.studentview,parent,false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lstStudent.size

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student=lstStudent[position]
        holder.tvName.text=student.stdFirstName
        holder.tvAge.text=student.stdAge.toString()

        holder.ivdel.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                val builder=AlertDialog.Builder(context)
                builder.setTitle("My Alert Hai")
                builder.setMessage("Sachi delete grni ho")
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                builder.setPositiveButton("Yes"){dialogInterface,which->
                    Toast.makeText(context,"clicked yes",Toast.LENGTH_LONG).show()
                }
                builder.setNeutralButton("Cancel"){dialogInterface,which->
                    Toast.makeText(context,"clicked cancel\noperation cancel",Toast.LENGTH_LONG).show()
                }
                builder.setNegativeButton("No"){dialogInterface,which->
                    Toast.makeText(context,"clicked No",Toast.LENGTH_LONG).show()
                }
                val alertDialog:AlertDialog=builder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        holder.ivedit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            val intent=Intent(context,EditActivity::class.java)
                context.startActivity(intent)

            }
        })



    }
}