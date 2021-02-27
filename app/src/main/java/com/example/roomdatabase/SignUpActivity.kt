package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.roomdatabase.db.StudentDB
import com.example.roomdatabase.entity.User
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpActivity : AppCompatActivity() {
    private lateinit var btnSignup: Button
    private lateinit var etFname: TextInputEditText
    private lateinit var etLname: TextInputEditText
    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSignup = findViewById(R.id.btnSignup)
        etFname = findViewById(R.id.firstname)
        etLname = findViewById(R.id.lastname)
        etUsername = findViewById(R.id.username)
        etPassword = findViewById(R.id.password)
        etConfirmPassword = findViewById(R.id.cpassword)

        btnSignup.setOnClickListener {
            val fname = etFname.text.toString()
            val lname = etLname.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            if (password != confirmPassword) {
                etPassword.error = "Password does not match"
                etPassword.requestFocus()
                return@setOnClickListener
            } else {
                val user = User(fname, lname, username, password)
                CoroutineScope(Dispatchers.IO).launch {
                    StudentDB
                        .getInstance(this@SignUpActivity)
                        .getUserDAO()
                        .registerUser(user)
                    // Switch to Main thread
                    withContext(Main) {
                        Toast.makeText(this@SignUpActivity, "user registered", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
}