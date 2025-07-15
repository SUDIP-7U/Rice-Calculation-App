package com.example.ricecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlin.getValue

class MainActivity : AppCompatActivity() {

    private val riceViewModel: RiceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val peopleEdit = findViewById<EditText>(R.id.peopleEditText)
        val gramsEdit = findViewById<EditText>(R.id.gramsPerPersonEditText)
        val mealsEdit = findViewById<EditText>(R.id.mealsPerDayEditText)
        val daysEdit = findViewById<EditText>(R.id.daysEditText)
        val priceEdit = findViewById<EditText>(R.id.pricePerKgEditText)
        val resultView = findViewById<TextView>(R.id.resultTextView)
        val calcButton = findViewById<Button>(R.id.calculateButton)

        calcButton.setOnClickListener {
            val people = peopleEdit.text.toString().toIntOrNull() ?: 0
            val grams = gramsEdit.text.toString().toIntOrNull() ?: 0
            val meals = mealsEdit.text.toString().toIntOrNull() ?: 0
            val days = daysEdit.text.toString().toIntOrNull() ?: 0
            val price = priceEdit.text.toString().toDoubleOrNull() ?: 0.0

            val result = riceViewModel.calculateRice(people, grams, meals, days, price)

            resultView.text = """
                Total Uncooked Rice: %.2f kg
                Total Cost: ৳%.2f
                Cooked Rice Output: %.2f kg
                Rice per Day: %.2f kg
            """.trimIndent().format(
                result.totalRiceKg,
                result.totalCost,
                result.cookedRiceKg,
                result.ricePerDay
            )
        }
    }
}