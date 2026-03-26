# AlkaWallet - Billetera Digital (Android)

Este proyecto es la versión móvil de la billetera digital **AlkaWallet**, desarrollada para la plataforma **Android** utilizando el lenguaje **Kotlin** y siguiendo el patrón de diseño **MVC (Modelo-Vista-Controlador)**.

## Requerimientos
*   **Android Studio** (versión reciente recomendada).
*   **JDK 11** o superior.
*   Un dispositivo físico Android o un Emulador (AVD).

## Estructura del Proyecto (MVC)
*   **Modelo (`com.alkawallet.model.Wallet`)**: Clase en Kotlin que gestiona el estado del saldo y las reglas de negocio para depósitos y retiros.
*   **Vista (`res/layout/activity_main.xml`)**: Interfaz de usuario declarativa en XML que define la disposición de los elementos visuales (botones, textos y campos de entrada).
*   **Controlador (`com.alkawallet.MainActivity`)**: Actividad que actúa como puente, capturando eventos de la interfaz, interactuando con el modelo y actualizando la UI con los resultados.

## Funcionalidades
*   **Visualización de Saldo**: El saldo se actualiza automáticamente en la pantalla principal con formato de moneda.
*   **Depósitos**: Permite ingresar montos para aumentar el saldo disponible.
*   **Retiros**: Permite descontar montos del saldo.
*   **Validaciones**: 
    *   Evita el procesamiento de campos vacíos o montos inválidos.
    *   Verifica que existan fondos suficientes antes de permitir un retiro.
    *   Proporciona retroalimentación inmediata al usuario mediante **Toasts** (notificaciones emergentes).

## Instrucciones de Ejecución
1.  Descarga o clona este repositorio.
2.  Abre **Android Studio** y selecciona **"Open"**.
3.  Busca la carpeta del proyecto y presiona **OK**.
4.  Espera a que **Gradle** sincronice las dependencias del proyecto.
5.  Conecta tu dispositivo Android o inicia un emulador.
6.  Haz clic en el botón **Run** (ícono de "Play" verde) en la barra superior.

## Tecnologías Utilizadas
*   **Lenguaje**: Kotlin.
*   **Android SDK**: Componentes de UI nativos y AppCompat.
*   **Layout**: LinearLayout para una estructura limpia y funcional.
