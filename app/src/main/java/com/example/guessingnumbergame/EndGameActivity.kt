package com.example.guessingnumbergame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val endGameMsgView = findViewById<TextView>(R.id.endGameMsg)
        val secretNumberView = findViewById<TextView>(R.id.num)
        val secretNum = intent.getIntExtra("secretNumber", 0)
        val loseOrWin = intent.getBooleanExtra("loseOrWin", true)

        secretNumberView.text = "$secretNum"
        if(loseOrWin){
            endGameMsgView.text = "You won! The number is:"
            secretNumberView.setTextColor(Color.parseColor("#00FF37"))
        }else{
            endGameMsgView.text = "You lost after 12 attempts. The number is:"
            secretNumberView.setTextColor(Color.parseColor("#FF0000"))
        }
    }
}