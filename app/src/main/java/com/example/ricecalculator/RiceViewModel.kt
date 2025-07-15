package com.example.ricecalculator

import androidx.lifecycle.ViewModel

class RiceViewModel : ViewModel() {

    fun calculateRice(
        people: Int,
        gramsPerPerson: Int,
        mealsPerDay: Int,
        days: Int,
        pricePerKg: Double
    ): RiceResult {
        val totalGrams = people * gramsPerPerson * mealsPerDay * days
        val totalKg = totalGrams / 1000.0
        val cost = totalKg * pricePerKg
        val cookedRice = totalKg * 2.5

        return RiceResult(
            totalRiceKg = totalKg,
            totalCost = cost,
            ricePerDay = totalKg / days,
            cookedRiceKg = cookedRice
        )
    }
}