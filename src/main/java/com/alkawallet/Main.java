package com.alkawallet;

import com.alkawallet.model.Wallet;
import com.alkawallet.view.WalletView;
import com.alkawallet.controller.WalletController;

public class Main {
    public static void main(String[] args) {
        // Inicializamos los componentes del MVC
        // Creamos una billetera con un saldo inicial de $1000.00
        Wallet myWallet = new Wallet(1000.0);
        
        // Creamos la vista para la interacción por consola
        WalletView myView = new WalletView();
        
        // Creamos el controlador que orquestará la lógica
        WalletController controller = new WalletController(myWallet, myView);

        // Iniciamos la aplicación
        controller.start();
    }
}
