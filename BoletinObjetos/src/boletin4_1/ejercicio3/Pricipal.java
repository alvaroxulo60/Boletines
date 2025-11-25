package boletin4_1.ejercicio3;

import exceptions.MaquinaCafeException;
import utils.MiEntradaSalida;

public class Pricipal {


    public static void main(String[] args) {
        Maquina maquinaCafe = new Maquina(50,50,80,10);
        boolean funcionando = true;
        double saldo;
        System.out.print("Bienvenido a Bermudo´s & coffe.\n");
        System.out.print("=====================\n");
        System.out.println("Cafe = "+maquinaCafe.PRECIOCAFE);
        System.out.println("Leche = "+maquinaCafe.PRECIOCAFE);
        System.out.println("Cafe con leche = "+maquinaCafe.PRECIOCAFECONLECHE);
        System.out.print("""
                ===================
                ¿Qué quieres hacer?
                Tomar
                Rellenar depositos
                Vaciar monedero
                Consultar máquina
                Apagar
                ===================
                \n""");
        while (funcionando) {
            String comando = MiEntradaSalida.leerLinea("¿Que desea hacer?\n");
            switch (comando.toLowerCase()) {
                case "tomar":
                    String tipo = MiEntradaSalida.leerLinea("¿Que deseas tomar?\n");
                    saldo = MiEntradaSalida.leerDouble("Introduce el saldo correspondiente: ");

                    try {
                        System.out.println("Aqui tienes tu cambio de " + maquinaCafe.servirCafe(tipo, saldo) + "€\n");

                    } catch (MaquinaCafeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "rellenar depositos":
                    maquinaCafe.rellenarDepositos();
                    break;
                case "vaciar monedero":
                    maquinaCafe.vaciarMonedero();
                    System.out.println("Monedero vaciado!\n");
                    break;
                case "consultar maquina":
                    maquinaCafe.consultarMaquina();
                    break;
                case "apagar":
                    funcionando = false;
                    System.out.print("Gracias por venir a Bermudo´s & coffe");
                    break;
            }
        }
    }
}
