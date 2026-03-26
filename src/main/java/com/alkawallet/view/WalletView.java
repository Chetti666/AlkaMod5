package com.alkawallet.view;

import java.util.Scanner;

public class WalletView {
    private Scanner scanner = new Scanner(System.in);

    public void showMenu(double balance) {
        System.out.println("\n==============================");
        System.out.println("       ALKAWALLET - MENU      ");
        System.out.println("==============================");
        System.out.printf(" Saldo Disponible: $%.2f%n", balance);
        System.out.println("------------------------------");
        System.out.println(" 1. Realizar Depósito");
        System.out.println(" 2. Realizar Retiro");
        System.out.println(" 3. Ver Saldo");
        System.out.println(" 4. Salir");
        System.out.println("------------------------------");
        System.out.print(" Seleccione una opción: ");
    }

    public double getAmount(String action) {
        System.out.print(" Ingrese el monto a " + action + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.print(" Por favor, ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public void showMessage(String message) {
        System.out.println("\n >>> " + message);
    }

    public void waitForEnter() {
        System.out.println("\n Presione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {}
    }
}
