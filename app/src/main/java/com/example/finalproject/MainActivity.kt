package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.finalproject.database.DB
import com.example.finalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        switchFrag(HomeFragment())
        //switching fragments
        binding.botnav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homePage->{switchFrag(HomeFragment())
                    println("Home page")
                }
                R.id.profilePage->switchFrag(ProfileFragment())
                else->{
                    println("Problems with fragment switching")
                    Toast.makeText(applicationContext,"Something's wrong",Toast.LENGTH_SHORT).show()
                }
            }
            true
        }




    }
    //function to switch
    private fun switchFrag(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrans = fragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fr_layout,fragment)
        fragmentTrans.commit()
    }
}