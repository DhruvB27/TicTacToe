package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class  GameActivity : AppCompatActivity() {

    lateinit var name1:String
    lateinit var name2:String
    lateinit var status:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var name1: String? = intent.getStringExtra("name1")
        var name2: String? = intent.getStringExtra("name2")
        var status: TextView = findViewById(R.id.statusBr)
        status.setText(name1 +" Turn - Tap To Play")
    }
    var gameActive: Boolean = true

    var activePlyr:Int = 0
    // 0=x and 1=O

    var gameState = arrayOf<Int>(2,2,2,2,2,2,2,2,2)
    // State Meanings
    // 0 = X
    // 1 = O
    // 2 mean empty state


    var winPosi = arrayOf( arrayOf(0,1,2) , arrayOf(3,4,5) , arrayOf(6,7,8),
        arrayOf(0,3,6), arrayOf(1,4,7), arrayOf(2,5,8),
        arrayOf(0,4,8), arrayOf(2,4,6))

    fun  playrTap(view: View)
    {

        var name1: String? = intent.getStringExtra("name1")
        var name2: String? = intent.getStringExtra("name2")
        var status: TextView = findViewById(R.id.statusBr)
        var img: ImageView? = view as? ImageView
        var TappedImg = (img?.getTag() as String).toInt()
        if(gameState[TappedImg] == 2)
        {
            gameState[TappedImg]   = activePlyr
            if(activePlyr==1)
            {
                img.setImageResource(R.drawable.o)
                activePlyr = 0
                status.setText(name1 + " Turn - Tap to Play")
            }else
            {
                img.setImageResource(R.drawable.x)
                activePlyr = 1
                status.setText( name2 + " Turn - Tap to Play")
            }
        }
        else
        {
            Toast.makeText(this@GameActivity, "Choose Other Box", Toast.LENGTH_SHORT).show()
        }

        val intent = Intent(this@GameActivity, FinalActivity::class.java)

        for (winPosition in winPosi) {

            var emptysqr: Boolean = false
            for(sqrstate in gameState )
            {
                if(sqrstate == 2)
                {
                    emptysqr = true
                    break
                }
            }

            if(!emptysqr && gameActive)
            {
                gameActive==false
                intent.putExtra("tie",3)
                startActivity(intent)
            }


            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                gameState[winPosition[1]] == gameState[winPosition[2]] &&
                gameState[winPosition[0]] != 2)
            {
                if(gameState[winPosition[0]] ==0 )
                {
                    intent.putExtra("winner",name1)
                    startActivity(intent)
                }
                else if(gameState[winPosition[0]]==1)
                {
                    intent.putExtra("winner",name2)
                    startActivity(intent)
                }
            }
        }
    }
}