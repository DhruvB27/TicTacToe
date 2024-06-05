package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalActivity : AppCompatActivity() {

    lateinit var resetbt1: Button
    lateinit var exitbt2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        var winner = intent.getStringExtra("winner")
        var tie = intent.getIntExtra("tie",-1)
        var heading: TextView = findViewById(R.id.heading)
        if (tie != 3) {
            heading.setText(winner + " Won")
        } else {
            heading.setText("Its a Tie")
        }

        resetbt1 = findViewById(R.id.playbt)
        exitbt2 = findViewById(R.id.exitbt)

        resetbt1.setOnClickListener{
            val intent = Intent(this@FinalActivity,NameActivity::class.java)
            startActivity(intent)
        }

        exitbt2.setOnClickListener{
            finishAffinity()
        }

    }



}