package com.alkawallet.controller;

import com.alkawallet.model.Wallet;
import com.alkawallet.view.WalletView;
import java.util.Scanner;

public class WalletController {
    private Wallet model;
    private WalletView view;
    private Scanner scanner;

    public WalletController(Wallet model, WalletView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option = 0;
        do {
            view.showMenu(model.getBalance());
            try {
                option = Integer.parseInt(scanner.nextLine());
                processOption(option);
            } catch (NumberFormatException e) {
                view.showMessage("Opción inválida. Por favor, ingrese un número.");
            }
        } while (option != 4);
    }

    private void processOption(int option) {
        switch (option) {
            case 1:
                double depositAmount = view.getAmount("depositar");
                if (depositAmount > 0) {
                    model.deposit(depositAmount);
                    view.showMessage("Depósito exitoso.");
                } else {
                    view.showMessage("Monto inválido.");
                }
                break;
            case 2:
                double withdrawAmount = view.getAmount("retirar");
                if (model.withdraw(withdrawAmount)) {
                    view.showMessage("Retiro exitoso.");
                } else {
                    view.showMessage("Fondos insuficientes o monto inválido.");
                }
                break;
            case 3:
                view.showMessage("Su saldo actual es: $" + String.format("%.2f", model.getBalance()));
                break;
            case 4:
                view.showMessage("Gracias por usar AlkaWallet. ¡Adiós!");
                break;
            default:
                view.showMessage("Opción no válida.");
        }
        if (option != 4) {
            view.waitForEnter();
        }
    }
}
