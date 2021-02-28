package com.muhammedazman.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton:Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // onCreated will run first time
        rollDice()
    }

    private fun rollDice() {
        // created Dice class
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // textview assign new value
        val textView:TextView = findViewById(R.id.textView)
        textView.text = diceRoll.toString()

        // imageview changed dice(1..6)
        val imageView:ImageView = findViewById(R.id.imageView)
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imageView.setImageResource(drawableResource)
    }
}

class Dice(val numDices: Int){
    fun roll():Int{
        return (1..numDices).random()
    }
}