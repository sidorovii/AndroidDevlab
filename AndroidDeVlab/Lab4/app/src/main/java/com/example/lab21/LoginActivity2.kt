package com.example.lab21

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
//import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
//import android.view.View
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_login2.*





class LoginActivity2 : AppCompatActivity()
{
    private val PREF_NAME = "LoginActivityPref"
    private val EMAIL_KEY:String = "e"
    private val PASSWORD_KEY:String = "p"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        Log.i("AppLogger","onCreateAct2")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
    }

    private fun deleteSharedPrefs()
    {
        val sharedPreferences = getSharedPreferences(PREF_NAME,
            Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(EMAIL_KEY).apply()
        sharedPreferences.edit().remove(PASSWORD_KEY).apply()
        Toast.makeText(this,"SharedPrefs delete",Toast.LENGTH_SHORT).show()
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

        getPrefData()

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


                    intent.putExtra(EMAIL_KEY, strEmail)
                    intent.putExtra(PASSWORD_KEY,strPass)

                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this,"Invalid password", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            else
            {
                Toast.makeText(this,"Invalid E-mail", Toast.LENGTH_SHORT)
                    .show()
            }
            EmailText.text.clear()
            PasswordText.text.clear()
        }

        backButton.setOnClickListener()
        {
            startActivity(intent)
        }
    }
    private fun getPrefData()
    {
        val sharedPreferences = getSharedPreferences(PREF_NAME,
            Context.MODE_PRIVATE)

        val strSharedPreferencesEmail = sharedPreferences.
            getString(EMAIL_KEY,"")

        val strSharedPreferencesPassword = sharedPreferences.
        getString(PASSWORD_KEY,"")

        EmailText.setText(strSharedPreferencesEmail)
        PasswordText.setText(strSharedPreferencesPassword)

        Toast.makeText(this,"Data Restored!",Toast.LENGTH_SHORT).show()
    }

    override fun onPause()
    {
        Log.i("AppLogger", "onPauseAct2")
        super.onPause()

        savePrefData()
    }
    private fun savePrefData()
    {
        val insertEmail = EmailText.text.toString()
        val insertPassword = PasswordText.text.toString()

        val sharedPreferences = getSharedPreferences(PREF_NAME,
            Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(EMAIL_KEY,insertEmail)
        editor.putString(PASSWORD_KEY,insertPassword)
        editor.apply()

        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT)
            .show()
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