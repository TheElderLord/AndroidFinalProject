package com.example.finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    //creating fields for use data
    private lateinit var username:TextView
    private lateinit var password:TextView
    private lateinit var submit:Button
    private lateinit var goReg:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username=findViewById(R.id.username)
        password=findViewById(R.id.password)
        submit = findViewById(R.id.regsubmit)
        submit.setOnClickListener{
           getUsers()

        }
        //if he wants to register clicks it and goes to
        goReg.setOnClickListener {
            val i = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(i)
        }


    }
    //checks user exists in database or not
    private fun getUsers() {
        // Work on background thread
        lifecycleScope.launch(Dispatchers.IO) {
            val persons = (applicationContext as RoomApp).repository.getAll()
            // Work on main thread
            val usname = username.text
            val pass = password.text
            persons.forEach { e ->
                if (e.uname==usname && e.pass==pass){
                    Toast.makeText(applicationContext,"User found",Toast.LENGTH_SHORT).show()
                    val i = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(i)
                }
            }

        }
    }
}