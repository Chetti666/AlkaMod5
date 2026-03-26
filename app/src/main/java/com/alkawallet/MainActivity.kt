package com.alkawallet

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alkawallet.model.Wallet

class MainActivity : AppCompatActivity() {

    private lateinit var wallet: Wallet
    private lateinit var tvBalance: TextView
    private lateinit var etAmount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializamos el modelo con un saldo inicial de 1000.0
        wallet = Wallet(1000.0)

        // Enlazamos las vistas
        tvBalance = findViewById(R.id.tvBalance)
        etAmount = findViewById(R.id.etAmount)
        val btnDeposit: Button = findViewById(R.id.btnDeposit)
        val btnWithdraw: Button = findViewById(R.id.btnWithdraw)

        // Actualizamos la vista inicial
        updateBalanceDisplay()

        // Configuramos los listeners
        btnDeposit.setOnClickListener {
            handleAction("deposit")
        }

        btnWithdraw.setOnClickListener {
            handleAction("withdraw")
        }
    }

    private fun handleAction(action: String) {
        val amountStr = etAmount.text.toString()
        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show()
            return
        }

        val amount = amountStr.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            Toast.makeText(this, "Monto inválido", Toast.LENGTH_SHORT).show()
            return
        }

        when (action) {
            "deposit" -> {
                wallet.deposit(amount)
                Toast.makeText(this, "Depósito exitoso", Toast.LENGTH_SHORT).show()
            }
            "withdraw" -> {
                if (wallet.withdraw(amount)) {
                    Toast.makeText(this, "Retiro exitoso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Fondos insuficientes", Toast.LENGTH_SHORT).show()
                }
            }
        }

        updateBalanceDisplay()
        etAmount.text.clear()
    }

    private fun updateBalanceDisplay() {
        tvBalance.text = "$ %.2f".format(wallet.balance)
    }
}
