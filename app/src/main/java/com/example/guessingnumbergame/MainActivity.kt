package com.example.guessingnumbergame

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import android.R.attr.x
import android.content.Intent


class MainActivity : AppCompatActivity() {
    var secretNum: Int = (1..1001).random()
    var counter: Int = 0
    var loseOrWin: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickBtn = findViewById<Button>(R.id.btn)
        val showNumber = findViewById<TextView>(R.id.showNumber)
        val enteredNumFromUser = findViewById<TextInputLayout>(R.id.numberInput)
        val showHint = findViewById<TextView>(R.id.showHint)

        clickBtn.setOnClickListener {
            val enteredNum = enteredNumFromUser.editText?.text?.toString()
            val intNum =
                if (enteredNum.isNullOrEmpty()) 0
                else Integer.parseInt(enteredNum)
            val newScreenIntent = Intent(this, EndGameActivity::class.java)
            showNumber.text = "($secretNum)"
            counter++

            if (intNum == 0) {
                showHint.text = "Enter your number"
            } else if (intNum == secretNum) {
                showHint.text = "YOU ARE RIGHT!"
                newScreenIntent.putExtra("secretNumber", secretNum)
                newScreenIntent.putExtra("loseOrWin", loseOrWin)
                startActivity(newScreenIntent)
            } else if (counter >= 12){
                showHint.text = "YOU LOST!"
                newScreenIntent.putExtra("secretNumber", secretNum)
                newScreenIntent.putExtra("loseOrWin", !loseOrWin)
                startActivity(newScreenIntent)
            } else if (intNum < secretNum){
                showHint.text = "No:) My number is bigger! ${12-counter} attempts left"
            } else if (intNum > secretNum){
                showHint.text = "No:) My number is smaller! ${12-counter} attempts left"
            }

        }

    }
}