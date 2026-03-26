package com.alkawallet.model

class Wallet(initialBalance: Double = 0.0) {
    var balance: Double = initialBalance
        private set

    fun deposit(amount: Double): Boolean {
        return if (amount > 0) {
            balance += amount
            true
        } else {
            false
        }
    }

    fun withdraw(amount: Double): Boolean {
        return if (amount > 0 && balance >= amount) {
            balance -= amount
            true
        } else {
            false
        }
    }
}
