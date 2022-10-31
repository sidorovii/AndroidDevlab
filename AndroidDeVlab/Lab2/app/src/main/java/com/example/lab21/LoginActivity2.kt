package com.example.lab21

import android.annotation.SuppressLint
import android.content.Intent
//import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login2.*

class LoginActivity2 : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        val intent = Intent(this, MainActivity::class.java)

        regButton.setOnClickListener()
        {
            val strEmail:String?
            val strPass :String?

                if (EmailText.text.toString() != "")
                {
                    if (PasswordText.text.toString() != "")
                    {
                        strEmail  = EmailText.text.toString()
                        strPass = PasswordText.text.toString()


                        intent.putExtra("e", strEmail)
                        intent.putExtra("p",strPass)

                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(this,"Invalid password", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(this,"Invalid E-mail", Toast.LENGTH_SHORT).show()
                }

        }

        backButton.setOnClickListener()
        {

            startActivity(intent)
        }

    }
}