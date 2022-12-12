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

    private val EMAIL_KEY = "e"
    private val PASSWORD_KEY = "p"
    private val BUNDLE_KEY = "b"
    private val USER_LIST_KEY = "u"
    private val NOT_EMPTY_USER_LIST_KEY = "empty"


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.i("AppLogger","onCreateAct2")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        val toMainActIntent = Intent(this, MainActivity::class.java)


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

                        var emailIsUnique:Boolean = true

                        val listStatus: String? = intent.getStringExtra(NOT_EMPTY_USER_LIST_KEY)
                        if(listStatus == "true")
                        {
                            val args: Bundle? = intent.getBundleExtra(BUNDLE_KEY)
                            val userList: ArrayList<User> = args?.getSerializable(USER_LIST_KEY) as ArrayList<User>
                            userList.forEach {
                                if(it._userEmail == strEmail) {
                                    emailIsUnique = false
                                    Toast.makeText(this,"EMAIL IS NOT UNIQUE!",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                        }

                        if(emailIsUnique)
                        {
                            toMainActIntent.putExtra(EMAIL_KEY, strEmail)
                            toMainActIntent.putExtra(PASSWORD_KEY, strPass)
                        }
                        startActivity(toMainActIntent)
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

            startActivity(toMainActIntent)
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