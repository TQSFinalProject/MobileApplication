package com.example.chateauduvin.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.chateauduvin.R

class Map : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
    }

    fun clickButton(view : View) {
        //Uri format:  lat/lng = 0,0 ?= "street, city, country"
        val gmmIntentUri =
            Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain View, California")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)

    }
}