package com.example.inputandoutput

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Get button using ID
        val clickMeButton = findViewById<Button>(R.id.clickButton)

        //add code to button
        clickMeButton?.setOnClickListener {
            Toast.makeText(this@MainActivity,
                "Clicked Button", Toast.LENGTH_LONG).show()
        }


        setContentView(R.layout.activity_main)

        //get the text view using ID
        val welcomeTextView =
            findViewById<TextView>(R.id.displayText)
        val nameEditText = findViewById<TextView>(R.id.nameText)

        // add code to the button that happens when its clicked
        clickMeButton.setOnClickListener {
            welcomeTextView.text = "Welcome, ${nameEditText}.text}!"

        // get switch that turns on zulu greeting
        val zuluSwitch = findViewById<Switch>(R.id.zuluswitch)

        //add code to the switch
        clickMeButton.setOnClickListener {
            var greeting: String
            var zulu :Boolean = zuluSwitch.isChecked
            var age =18
            if (zulu) {
                greeting = "Sawubona,${nameEditText.text}!"
            } else {
                if((nameEditText.text.toString()=="Sam"||
                    nameEditText.text.toString()=="Samantha")
                    && age>18) {
                    greeting = "Yo,${nameEditText.text}!"
                }  else{
                    greeting ="Greetings,${nameEditText.text}"

                }
            }

            welcomeTextView.text =greeting

            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.zuluSwitch)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}