package com.example.chateauduvin.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chateauduvin.R
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class NewOrders : AppCompatActivity() {
    private val url = "http://deti-tqs-14.ua.pt:8080"

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)

        val token_label : String = intent.getStringExtra("Token").toString()
        val username_label : String = intent.getStringExtra("Username").toString()


        val temp : EditText = findViewById(R.id.temp)

        val url_riders = "$url/api/rider/orders"

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

                val list: MutableList<String> = ArrayList()

                Log.d("SuccessMyOrders", response.toString())
                // Log.d("Token", token_label)
                val jsonArray = JSONArray(response.body?.string() ?: "")
                for (i in 0 until jsonArray.length()) {
                    val jsonObj = jsonArray.getJSONObject(i).getJSONObject("order")
                    //Log.d("aaa__", jsonArray.getJSONObject(i).toString())
                    list.add(jsonObj.getString("id").toString())
                    //Log.d("aaa__", jsonObj.getString("id").toString())
                }
                Log.d("list", list.toString())
                temp.setText(list.toString())
            }
            // you code to handle response
        });

        Thread.sleep(2_000)
        val temp_2 : EditText = findViewById(R.id.temp)
        val linearLayout : LinearLayout = findViewById(R.id.linear)
        // setContentView(linearLayout)
        for (i in temp_2.text.toString().indices) {
            if (temp_2.text.toString()[i].toString() != "," && temp_2.text.toString()[i].toString() != "[" && temp_2.text.toString()[i].toString() != "]" && temp_2.text.toString()[i].toString() != " ") {
                Log.d(
                    "list char", temp_2.text.toString()[i].toString()
                )
                val tv_dynamic = TextView(this)
                tv_dynamic.textSize = 14f
                tv_dynamic.text = "Order " + temp_2.text.toString()[i].toString()
                tv_dynamic.setBackgroundColor(Color.WHITE)
                tv_dynamic.setPadding(20, 10, 20, 10)
                tv_dynamic.setTextColor(Color.BLACK);
                tv_dynamic.setClickable(true);
                val space_dynamic = Space(this)
                space_dynamic.minimumHeight = 20
                tv_dynamic.setOnClickListener(View.OnClickListener {
                    // do you work here
                    checkDetails(temp_2.text.toString()[i].toString())
                })


                linearLayout.addView(tv_dynamic);
                linearLayout.addView(space_dynamic);
            }
        }
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

    fun checkDetails(id : String) {
        val token_label : String = intent.getStringExtra("Token").toString()
        val username_label : String = intent.getStringExtra("Username").toString()
        val intent = Intent(this, OrderDetails::class.java)
        intent.putExtra("Token", token_label)
        intent.putExtra("Username", username_label)
        intent.putExtra("Id", id)
        startActivity(intent)
    }
}