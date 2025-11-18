package Ejercicio3;

import utils.MiEntradaSalida;

public class Pricipal {


public static void main(String[] args) {
    Maquina maquinaCafe = new Maquina();
    System.out.print("Bienvenido a Bermudo´s & coffe.\n");
    System.out.print("""
            Este es nuestro menú:
            Café solo = 1€
            Leche = 0,8€
            Café con leche = 1,5€
            """);
    String comando = MiEntradaSalida.leerLinea("¿Que desea tomar?");
    double saldo = MiEntradaSalida.leerDecimal("Introduce el saldo correspondiente");
    if (comando.startsWith("apagar")){
        System.out.print("Gracias por venir a Bermudo´s & coffe");
    }else {
        maquinaCafe.servirCafe(comando,saldo);
    }
    }
}
