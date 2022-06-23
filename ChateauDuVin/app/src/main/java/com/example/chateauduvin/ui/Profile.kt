package com.example.chateauduvin.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chateauduvin.R
import com.example.chateauduvin.data.Rider
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class Profile : AppCompatActivity() {

    private val url = "http://deti-tqs-14.ua.pt:8080"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val last_name: TextView = findViewById(R.id.profile_last_name)
        val first_name: TextView = findViewById(R.id.profile_first_name)
        val username: TextView = findViewById(R.id.profile_username)
        val phone_number: TextView = findViewById(R.id.profile_phone_number)

        val token_label : String = intent.getStringExtra("Token").toString()
        val username_label : String = intent.getStringExtra("Username").toString()

        val url_riders = "$url/myprofile"

       val client = OkHttpClient()

       val request = Request.Builder()
            .url(url_riders)
            .get()
           .header("Authorization", "Bearer " + token_label)
            .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace();
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d("SuccessProfile", response.toString())
                    // Log.d("SuccessProfile", response.body?.string() ?: "")
                    val jsonObject = JSONObject(response.body?.string() ?: "")

                    last_name.setText( jsonObject.getString("lastName"))
                    first_name.setText( jsonObject.getString("firstName"))
                    phone_number.setText( jsonObject.getString("phone"))
                    username.setText( username_label)

                }
                // you code to handle response

            });

        }



    fun clickToChangePassword(view : View) {
        val intent = Intent(this, ChangePassword::class.java)
        startActivity(intent)
    }

    fun goNewOrders(view : View) {
        val token_label : String = intent.getStringExtra("Token").toString()
        val username_label : String = intent.getStringExtra("Username").toString()
        val intent = Intent(this, NewOrders::class.java)
        intent.putExtra("Token", token_label)
        intent.putExtra("Username", username_label)
        startActivity(intent)
    }

    fun goMyOrders(view : View) {
        val token_label : String = intent.getStringExtra("Token").toString()
        val username_label : String = intent.getStringExtra("Username").toString()
        val intent = Intent(this, MyOrders::class.java)
        intent.putExtra("Token", token_label)
        intent.putExtra("Username", username_label)
        startActivity(intent)
    }
    fun goProfileSettings(view : View) {
        val token_label : String = intent.getStringExtra("Token").toString()
        val username_label : String = intent.getStringExtra("Username").toString()
        val intent = Intent(this, Profile::class.java)
        intent.putExtra("Token", token_label)
        intent.putExtra("Username", username_label)
        startActivity(intent)
    }
}