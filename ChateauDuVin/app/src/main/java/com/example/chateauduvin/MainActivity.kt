package com.example.chateauduvin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickToSignUp(view : View) {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)
    }

    fun clickToSignIn(view : View) {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }
}