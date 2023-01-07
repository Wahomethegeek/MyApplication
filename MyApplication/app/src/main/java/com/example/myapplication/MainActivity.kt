package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.VisibleActivityCallback
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {  // onCreate function is called when a function is created
        super.onCreate(savedInstanceState) // a bundle containing activities
        setContentView(R.layout.activity_main)
           val greetingTextView = findViewById<TextView>(R.id.tvHello)
           val inputField = findViewById<EditText>(R.id.etName)
           val buttonSubmit = findViewById<Button>(R.id.btnSubmit)
           val offersButton = findViewById<Button>(R.id.btnOffers)
           var enteredName = ""
           buttonSubmit.setOnClickListener {
               enteredName = inputField.text.toString()

               if (enteredName == ""){
                   offersButton.visibility = INVISIBLE
                   greetingTextView.text = ""
                   Toast.makeText( //arguments
                       this@MainActivity, // tied to the life cycle of the activity
                       "Please enter your name!",
                       Toast.LENGTH_SHORT).show()

               }else {
                   val message =
                       "Welcome $enteredName" //when using a variable inside a string use the $
                   greetingTextView.text = message
                   inputField.text.clear()
                   offersButton.visibility = VISIBLE
               }
           }

             offersButton.setOnClickListener {
                 val intent =Intent(this,SecondActivity::class.java)
                 intent.putExtra("USER",enteredName)
                 startActivity(intent)
             }

    }
}