package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var startbt : Button
    lateinit var exitbt : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startbt = findViewById(R.id.startbt)
        exitbt = findViewById(R.id.exitbt)

        startbt.setOnClickListener{

            val intent = Intent( this@MainActivity, NameActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@MainActivity, "Starting Game", Toast.LENGTH_SHORT).show()
        }
        exitbt.setOnClickListener{
            finish()
        }
    }
}
