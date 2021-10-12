package com.example.retrofitrecyclerviewk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMyData()
    }

    private fun getMyData() {

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<DataModels>?> {
            override fun onResponse(
                call: Call<List<DataModels>?>,
                response: Response<List<DataModels>?>
            ) {
                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()

                for(myData in responseBody)
                {
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")

                }
                val textId = findViewById<TextView>(R.id.textId)
                textId.text = myStringBuilder

            }

            override fun onFailure(call: Call<List<DataModels>?>, t: Throwable) {
               Log.d("Error",""+t.message)
            }
        })
    }
}