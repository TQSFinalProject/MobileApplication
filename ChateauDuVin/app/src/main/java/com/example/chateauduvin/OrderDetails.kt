package com.example.chateauduvin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        var origin : String = intent.getStringExtra("From").toString()
        val buttonDecline = findViewById<Button>(R.id.order_decline)
        val buttonAccept = findViewById<Button>(R.id.order_accept)
        var show : Boolean = true

        Log.d("hey", origin)

        if (origin == "new_oders") {
            Log.d("hey", "entrei")
            show = false
        }

        if (show) {
            buttonDecline.visibility = View.INVISIBLE
            buttonAccept.visibility = View.INVISIBLE
        }
    }


    fun clickToCall(view: View) {
        val editText : TextView = findViewById(R.id.phone_client)
        val message = editText.text.toString()
        var finalText = "tel:".plus(message)
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(finalText)
        startActivity(intent)
    }

    fun clickToMap (view: View) {
        //Uri format:  lat/lng = 0,0 ?= "street, city, country"
        val gmmIntentUri =
            Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain View, California")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    fun clickToBack(view : View) {
        val intent = Intent(this, NewOrders::class.java)
        startActivity(intent)
    }



}