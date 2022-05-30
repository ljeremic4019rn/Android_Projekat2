package com.example.rmaproject2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen: SplashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {

            val sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE)
            val email = sharedPreferences.getString(LoginActivity.EMAIL, "")
            intent = if (email == "") {
                Intent(this, LoginActivity::class.java)
            } else {
                Intent(this, AppActivity::class.java)
            }
            startActivity(intent)
            finish()
            false
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}