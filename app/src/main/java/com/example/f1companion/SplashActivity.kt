package com.example.f1companion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val moveToMain = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(moveToMain)
        finish()
    }
}