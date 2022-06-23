package com.example.chateauduvin.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chateauduvin.R
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONObject
import java.io.IOException


class MyOrdersDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders_details)

        val buttonComplete = findViewById<Button>(R.id.order_complete)
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

    fun clickToComplete(view: View) {
        val id : String = intent.getStringExtra("Id").toString()
        val token_label : String = intent.getStringExtra("Token").toString()

        val json : String = Gson().toJson("")
        val mediaType = "application/json".toMediaTypeOrNull()
        val body = RequestBody.create(mediaType, json)

        val client = OkHttpClient()
        val url : String =  "http://deti-tqs-14.ua.pt:8080/api/rider/order/complete/" + id
        val request = Request.Builder()
            .url(url)
            .put(body)
            .header("Authorization", "Bearer " + token_label)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace();
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("Success", response.toString())
                // Log.d("Success", response.body?.string() ?: "")


            }
            // you code to handle response

        });
    }

    fun clickToDelivering(view: View) {
        val id : String = intent.getStringExtra("Id").toString()
        val token_label : String = intent.getStringExtra("Token").toString()

        val json : String = Gson().toJson("")
        val mediaType = "application/json".toMediaTypeOrNull()
        val body = RequestBody.create(mediaType, json)

        val client = OkHttpClient()
        val url : String =  "http://deti-tqs-14.ua.pt:8080/api/rider/order/delivering/" + id
        val request = Request.Builder()
            .url(url)
            .put(body)
            .header("Authorization", "Bearer " + token_label)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace();
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("Success", response.toString())
                // Log.d("Success", response.body?.string() ?: "")


            }
            // you code to handle response

        });
    }
}

