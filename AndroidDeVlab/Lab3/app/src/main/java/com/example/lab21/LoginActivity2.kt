package com.example.lab21

import android.annotation.SuppressLint
import android.content.Intent
//import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login2.*

class LoginActivity2 : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.i("AppLogger","onCreateAct2")

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

    override fun onStart()
    {
        Log.i("AppLogger", "onStartAct2")
        super.onStart()
    }

    override fun onResume()
    {
        Log.i("AppLogger", "onResumeAct2")
        super.onResume()
    }

    override fun onPause()
    {
        Log.i("AppLogger", "onPauseAct2")
        super.onPause()
    }

    override fun onStop()
    {
        Log.i("AppLogger", "onStopAct2")
        super.onStop()
    }

    override fun onDestroy()
    {
        Log.i("AppLogger", "onDestroyAct2")
        super.onDestroy()
    }
}