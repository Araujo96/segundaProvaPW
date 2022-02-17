package com.example.filmesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.filmesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //binding = DataBindingUtil.inflate(infl)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}