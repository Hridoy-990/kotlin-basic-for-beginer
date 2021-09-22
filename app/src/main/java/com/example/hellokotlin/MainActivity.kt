package com.example.hellokotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*


class MainActivity : AppCompatActivity() {

    private lateinit var tv:TextView
    private lateinit var tv2:ImageView
    private lateinit var editText:EditText
    private lateinit var string: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.sbutton)
        val btn2 = findViewById<Button>(R.id.sbutton2)
        tv = findViewById(R.id.tv)
        tv2 = findViewById(R.id.dice1)
        editText = findViewById(R.id.editText)
        btn2.setOnClickListener{rollDice()}
        btn1.setOnClickListener{
            TextStore(it)
        }

    }
    private fun TextStore(view: View){
        string = editText.text.toString()
        tv.text = string
        /*editText.visibility= View.GONE
        view.visibility = View.GONE
        tv.visibility =  View.VISIBLE */
        // Hide the keyboard.
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
    private fun rollDice() {
        val randomInt =(1..6).random()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        tv2.setImageResource(drawableResource)
    }
}