package com.example.chateauduvin.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chateauduvin.R
import com.example.chateauduvin.data.Login
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val url = "http://deti-tqs-14.ua.pt:8080"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickToSignUp(view : View) {

        val intent = Intent(this, Register::class.java)
        startActivity(intent)
    }

    fun clickToSignIn(view : View) {
        val username: EditText = findViewById(R.id.login_username)
        val password : EditText = findViewById(R.id.login_password)
        val token_label : EditText = findViewById(R.id.token)

        val url_riders = "$url/authentication"

        if (username.text.toString() != "" && password.text.toString() != "") {
            val loginRequest : Login = Login(username.text.toString(), password.text.toString())
            val json : String = Gson().toJson(loginRequest)

            Log.d("Mensagem: ", json)

            val client = OkHttpClient()

            val mediaType = "application/json".toMediaTypeOrNull()
            val body = RequestBody.create(mediaType, json)
            val request = Request.Builder()
                .url(url_riders)
                .post(body)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace();
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d("Success", response.toString())
                    // Log.d("Success", response.body?.string() ?: "")

                    val jsonObject = JSONObject(response.body?.string() ?: "")
                    Log.d("Success", jsonObject.getString("token"))
                    val value = jsonObject.getString("token")
                    token_label.setText(value)
                }
                // you code to handle response

            });

            // Log.d("Token", token)
            Thread.sleep(3_000)
            val token_label_2 : EditText = findViewById(R.id.token)
            Log.d("Token", token_label_2.text.toString())
            val intent = Intent(this, Profile::class.java)
            intent.putExtra("Token", token_label_2.text.toString())
            intent.putExtra("Username", username.text.toString())
            startActivity(intent)
        }

        Log.d("email_debug", username.text.toString())
        Log.d("password_debug", password.text.toString())
    }
}