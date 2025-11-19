package ejercicio3;

import exceptions.MaquinaCafeException;
import utils.MiEntradaSalida;

public class Pricipal {


    public static void main(String[] args) {
        Maquina maquinaCafe = new Maquina();
        boolean funcionando = true;
        double saldo;
        System.out.print("Bienvenido a Bermudo´s & coffe.\n");
        System.out.print("""
                =====================
                Este es nuestro menú:
                Café solo = 1€
                Leche = 0,8€
                Café con leche = 1,5€
                =====================
                \n""");
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
                    saldo = MiEntradaSalida.leerDecimal("Introduce el saldo correspondiente: ");

                    try {
                        System.out.println("Aqui tienes tu cambio de "+maquinaCafe.servirCafe(tipo, saldo)+"€");

                    } catch (MaquinaCafeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "rellenar depositos":
                    int cafe = MiEntradaSalida.leerEntero("Cantidad de dosis de cafe a rellenar: ");
                    int leche = MiEntradaSalida.leerEntero("Cantidad de dosis de leche a rellenar: ");
                    int vasos = MiEntradaSalida.leerEntero("Cantidad de vasos a rellenar: ");
                    try {
                        maquinaCafe.rellenarDepositos(cafe, leche, vasos);
                    } catch (MaquinaCafeException e) {
                        System.out.println(e.getMessage());
                    }
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
