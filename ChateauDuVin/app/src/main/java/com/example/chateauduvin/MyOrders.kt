package com.example.chateauduvin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MyOrders : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)
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

        //TODO: desativar os butões de aceitar e recusar neste caso
        val intent = Intent(this, OrderDetails::class.java)
        intent.putExtra("From", "my_orders")
        startActivity(intent)
    }
}