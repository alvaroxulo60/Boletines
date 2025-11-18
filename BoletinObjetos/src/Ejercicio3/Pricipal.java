package Ejercicio3;

import utils.MiEntradaSalida;

public class Pricipal {


public static void main(String[] args) {
    Maquina maquinaCafe = new Maquina();
    boolean funcionando = true;
    System.out.print("Bienvenido a Bermudo´s & coffe.\n");
    System.out.print("""
            Este es nuestro menú:
            Café solo = 1€
            Leche = 0,8€
            Café con leche = 1,5€
            """);
    while (funcionando) {
        String comando = MiEntradaSalida.leerLinea("¿Que desea tomar o desea apagar la máquina?\n");
        if (comando.startsWith("apagar")) {
            funcionando=false;
            System.out.print("Gracias por venir a Bermudo´s & coffe");
        } else {
            double saldo = MiEntradaSalida.leerDecimal("Introduce el saldo correspondiente: ");
            maquinaCafe.servirCafe(comando, saldo);
        }
    }
    }
}
