package com.example.myandroidapk
import android.app.Activity
import android.graphics.Color.argb
import android.os.Bundle
import android.view.View
import androidx.core.graphics.alpha
import androidx.core.view.isVisible
import androidx.core.view.marginBottom
import androidx.core.view.marginStart
import kotlinx.android.synthetic.main.hello_activity_xml.*

class HelloActivity: Activity()
{
    override fun onCreate(savedInstanceState:Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_activity_xml)
    }

    fun button1Clicked(view: View)
    {
        val strPushed = "Pushed!"

        if (button1.text != strPushed)
        {
            button1.text = strPushed
        }
        val strCounter = textViewCounter1.text.toString()

        var intCounter =  strCounter.toInt()
        intCounter++

        textViewCounter1.text = intCounter.toString()


        button1.x = (0..950).random().toFloat()
        button1.y = (0..2000).random().toFloat()

        button1.isVisible = false
        button2.isVisible = true
    }

    fun button2Clicked(view: View)
    {
        val strCounter = textViewCounter2.text.toString()

        var intCounter =  strCounter.toInt()
        intCounter++
        textViewCounter2.text = intCounter.toString()


        button2.x = (0..950).random().toFloat()
        button2.y = (0..2000).random().toFloat()

        button2.isVisible = false
        button1.isVisible = true

    }

    fun buttonClrClicked(view: View)
    {
        val zero: String = "0"
        textViewCounter1.text = zero;
        textViewCounter2.text = zero;

        button2.isVisible = true
        button1.isVisible = true

        button1.x = 450F
        button1.y = 1670F
        button2.x = 450F
        button2.y = 1870F

    }
}
