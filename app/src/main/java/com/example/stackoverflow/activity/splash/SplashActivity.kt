package com.example.stackoverflow.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.stackoverflow.MainActivity
import com.example.stackoverflow.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }, 3000)
    }
}
