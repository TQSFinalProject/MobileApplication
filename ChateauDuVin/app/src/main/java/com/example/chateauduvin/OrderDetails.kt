package com.example.chateauduvin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class OrderDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)
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