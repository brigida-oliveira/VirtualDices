package com.diceapp.virtualdices

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Essa activity permite que o usuário lance dois dados e veja o resultado na tela.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_VirtualDices)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * Lança dados e mostra o resultado
     */
    @SuppressLint("SetTextI18n")
    private fun rollDice() {
        // Cria dois dados de seis lados
        var dice1 = Dice(6)
        var diceRoll1 = dice1.roll()

        var dice2 = Dice(6)
        var diceRoll2 = dice2.roll()


        var dice1ImageView : ImageView = findViewById(R.id.dado1)
        when(diceRoll1){
            1 -> dice1ImageView.setImageResource(R.drawable.ic_dice1)
            2 -> dice1ImageView.setImageResource(R.drawable.ic_dice2)
            3 -> dice1ImageView.setImageResource(R.drawable.ic_dice3)
            4 -> dice1ImageView.setImageResource(R.drawable.ic_dice4)
            5 -> dice1ImageView.setImageResource(R.drawable.ic_dice5)
            6 -> dice1ImageView.setImageResource(R.drawable.ic_dice6)
        }

        var dice2ImageView : ImageView = findViewById(R.id.dado2)
        when(diceRoll2){
            1 -> dice2ImageView.setImageResource(R.drawable.ic_dice1)
            2 -> dice2ImageView.setImageResource(R.drawable.ic_dice2)
            3 -> dice2ImageView.setImageResource(R.drawable.ic_dice3)
            4 -> dice2ImageView.setImageResource(R.drawable.ic_dice4)
            5 -> dice2ImageView.setImageResource(R.drawable.ic_dice5)
            6 -> dice2ImageView.setImageResource(R.drawable.ic_dice6)
        }
        // Atualiza a tela com o resultado dos dois dados
        val resultTextView : TextView = findViewById(R.id.textView)
        resultTextView.text = "Primeiro dado: $diceRoll1    Segundo dado: $diceRoll2"
        val resultTextView2 : TextView = findViewById(R.id.textView2)
        resultTextView2.text = "Resultado: ${diceRoll1 + diceRoll2}"
    }
}


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}