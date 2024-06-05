package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NameActivity : AppCompatActivity() {

    lateinit var nameet1 : EditText
    lateinit var nameet2 : EditText
    lateinit var bt1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        nameet1 = findViewById(R.id.nameet1)
        nameet2 = findViewById(R.id.nameet2)
        bt1 = findViewById(R.id.bt1)


        val intent = Intent(this@NameActivity,GameActivity::class.java)

        bt1.setOnClickListener {


            var name1:String = nameet1.text.toString()
            var name2:String = nameet2.text.toString()

            if(name1.isEmpty())
            {
                name1 = "Player 17"
            }
            if(name2.isEmpty())
            {
                name2 = "Player 26"
            }

            intent.putExtra("name1",name1)
            intent.putExtra("name2",name2)
            startActivity(intent)
        }

    }
}