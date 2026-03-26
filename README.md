# AlkaWallet - Billetera Digital

Este proyecto es una simulación básica de una billetera digital denominada **AlkaWallet**, desarrollada en Java SE siguiendo el patrón de diseño **MVC (Modelo-Vista-Controlador)**. Permite a los usuarios gestionar sus fondos mediante depósitos, retiros y consulta de saldo a través de una interfaz de consola.

## Requerimientos
*   **Java JDK 8** o superior.
*   **Apache Maven** (opcional, para construcción desde terminal).
*   Un IDE de Java (IntelliJ IDEA, Eclipse, VS Code).

## Estructura del Proyecto (MVC)
*   **Modelo (`com.alkawallet.model.Wallet`)**: Contiene la lógica del saldo y las operaciones matemáticas.
*   **Vista (`com.alkawallet.view.WalletView`)**: Maneja toda la interacción con el usuario (entrada y salida por consola).
*   **Controlador (`com.alkawallet.controller.WalletController`)**: Orquesta la comunicación entre el Modelo y la Vista.
*   **Main (`com.alkawallet.Main`)**: Punto de entrada de la aplicación.

## Instrucciones de Ejecución

### Opción 1: Desde el IDE (Recomendado)
1.  Abre el proyecto en tu IDE preferido.
2.  Navega hasta la carpeta `src/main/java/com/alkawallet/`.
3.  Haz clic derecho sobre el archivo **`Main.java`**.
4.  Selecciona **Run 'Main.main()'**.
5.  Interactúa con la aplicación a través de la pestaña **Terminal** o **Console** del IDE.

### Opción 2: Desde la Terminal (Maven)
Si tienes Maven instalado, puedes compilar y ejecutar el proyecto con los siguientes comandos:

1.  Compilar el proyecto:
    ```bash
    mvn clean package
    ```
2.  Ejecutar el archivo JAR generado:
    ```bash
    java -jar target/AlkaWallet-1.0-SNAPSHOT.jar
    ```

## Funcionalidades
*   **Consulta de Saldo**: Visualiza el saldo disponible en tiempo real.
*   **Depósitos**: Incrementa el saldo de la billetera.
*   **Retiros**: Descuenta fondos validando que existan montos suficientes.
*   **Validaciones**: El sistema impide ingresos de texto en campos numéricos y retiros superiores al saldo disponible.
