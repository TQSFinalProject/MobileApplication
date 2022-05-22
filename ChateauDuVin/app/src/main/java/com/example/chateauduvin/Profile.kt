package com.example.chateauduvin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    fun clickToChangePassword(view : View) {
        val intent = Intent(this, ChangePassword::class.java)
        startActivity(intent)
    }

    fun goNewOrders(view : View) {
        val intent = Intent(this, NewOrders::class.java)
        startActivity(intent)
    }

    fun goMyOrders(view : View) {
        val intent = Intent(this, MyOrders::class.java)
        startActivity(intent)
    }
    fun goProfileSettings(view : View) {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }
}