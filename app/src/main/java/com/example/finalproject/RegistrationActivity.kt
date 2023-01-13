package com.example.finalproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.finalproject.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Random

class RegistrationActivity : AppCompatActivity() {
    private lateinit var nameText: TextView
    private val random: Int
        get() = Random().nextInt(9999)
    private lateinit var username: TextView
    private lateinit var password: TextView
    private lateinit var submit: Button
    private lateinit var golog:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        nameText = findViewById(R.id.name)
        username=findViewById(R.id.username)
        password=findViewById(R.id.password)
        submit = findViewById(R.id.logsubmit)
        golog=findViewById(R.id.goLog)
        golog.setOnClickListener {
            val i = Intent(this@RegistrationActivity, LoginActivity::class.java)
            startActivity(i)
        }
        submit.setOnClickListener{
            val id = random.toString()
            val username = username.text.toString()
            val name = nameText.text.toString()
            val pass = password.text.toString()
            val user=User(id=id,uname=username, pass = pass,name=name)
            insertUser(user)
            Toast.makeText(applicationContext,"User added",Toast.LENGTH_SHORT).show()
            val i = Intent(this@RegistrationActivity, LoginActivity::class.java)
            startActivity(i)
        }
    }

    private fun insertUser(user: User) {
        lifecycleScope.launch(Dispatchers.IO){
            (applicationContext as RoomApp).repository.insertUser(user=user)
        }
    }
}