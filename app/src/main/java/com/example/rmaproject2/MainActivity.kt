package com.example.rmaproject2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class MainActivity : AppCompatActivity() {

//    val sharedPreferences: SharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE)
    override fun onCreate(savedInstanceState: Bundle?) {



        val splashScreen: SplashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            false
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}