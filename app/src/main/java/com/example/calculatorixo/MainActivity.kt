package com.example.calculatorix

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatorix.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Block of button numbers
        binding.One.setOnClickListener { setTextFields("1") }
        binding.Two.setOnClickListener { setTextFields("2") }
        binding.Three.setOnClickListener { setTextFields("3") }
        binding.Four.setOnClickListener { setTextFields("4") }
        binding.Five.setOnClickListener { setTextFields("5") }
        binding.Six.setOnClickListener { setTextFields("6") }
        binding.Seven.setOnClickListener { setTextFields("7") }
        binding.Eight.setOnClickListener { setTextFields("8") }
        binding.Nine.setOnClickListener { setTextFields("9") }
        binding.Zero.setOnClickListener { setTextFields("0") }

        // Block of operations
        binding.Add.setOnClickListener { setTextFields("+") }
        binding.minus.setOnClickListener { setTextFields("-") }
        binding.Multiply.setOnClickListener { setTextFields("*") } // Change to '*'
        binding.Separate.setOnClickListener { setTextFields("/") }
        binding.AC.setOnClickListener {
            binding.EqualText.text = ""
        }
        binding.rightcover.setOnClickListener{ setTextFields(")")}
        binding.leftcover.setOnClickListener{setTextFields("(")}
        binding.Dotbtn.setOnClickListener{setTextFields(".")}
        binding.EqualButton.setOnClickListener {
            try {
                val complete = ExpressionBuilder(binding.EqualText.text.toString()).build()
                val result = complete.evaluate()
                val biggerResult = result.toLong()
                if (result == biggerResult.toDouble()) {
                    binding.EqualText.text = biggerResult.toString()
                } else {
                    binding.EqualText.text = result.toString()
                }
            } catch (error: Exception) {
                Log.d("ACTIVITY", "ERROR:STR:40")
            }
        }
    }

    private fun setTextFields(str: String) {
        val currentText = binding.EqualText.text.toString()
        binding.EqualText.text = currentText + str
    }
}
