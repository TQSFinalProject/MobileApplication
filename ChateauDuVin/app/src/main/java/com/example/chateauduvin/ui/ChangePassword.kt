package com.example.chateauduvin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.chateauduvin.R

class ChangePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
    }

    fun clickToBack(view : View) {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }

    fun clickToSave(view : View) {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }
}