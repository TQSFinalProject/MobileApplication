package com.example.chateauduvin.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.chateauduvin.R

class NewOrders : AppCompatActivity() {


    private val url = "http://localhost:8080/api/orders"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_orders)



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

    fun checkDetails(view: View) {
        val intent = Intent(this, OrderDetails::class.java)
        intent.putExtra("From", "new_orders")
        startActivity(intent)
    }
}