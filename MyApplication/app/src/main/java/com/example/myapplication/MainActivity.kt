package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val NAME_PATTERN = Pattern.compile("[a-zA-Z]{10,16}")

        val PHONE_PATTERN = Pattern.compile("^(?=5)(?=.*[0-9])(?=\\S+$).{9,9}$")

        val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        val PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$")


        val loginbtn = findViewById<Button>(R.id.loginbtn)
        val name = findViewById<EditText>(R.id.name)
        val phone = findViewById<EditText>(R.id.phone)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)


        loginbtn.setOnClickListener(){

            val Name: String = name.text.toString()
            val Phone: String = phone.text.toString()
            val Email: String = email.text.toString()
            val Passqord: String = password.text.toString()

            if(!NAME_PATTERN.matcher(Name).matches())
                Toast.makeText(this,"Name should be 10-16 characters Ex:mahammadjabiulla ",Toast.LENGTH_SHORT).show()

            else if(!PHONE_PATTERN.matcher(Phone).matches())
                Toast.makeText(this,"Phone number start with 5 and 9 digits Ex:589632147",Toast.LENGTH_SHORT).show()

            else if (!EMAIL_ADDRESS_PATTERN.matcher(Email).matches())
                Toast.makeText(this,"Please Enter valid Email ",Toast.LENGTH_SHORT).show()

            else if(!PASSWORD_PATTERN.matcher(Passqord).matches())
                Toast.makeText(this,"Password should be '8-16 characters' Ex:aA@123456", Toast.LENGTH_SHORT).show()
            else
            {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("email", Email)
                startActivity(intent)
            }
        }
    }
}