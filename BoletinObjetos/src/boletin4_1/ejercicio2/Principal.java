package boletin4_1.ejercicio2;

import exceptions.CuentaException;
import utils.MiEntradaSalida;

public class Principal {
    public static void main(String[] args) {
        System.out.printf("Bienvenido a BermudoBank.%n");
        Cuenta cuenta = null;

        while (cuenta==null){
            double saldoInical = MiEntradaSalida.leerDecimal("Introduce el saldo inicial: \n");
            try {
                cuenta = new Cuenta(saldoInical);
            } catch (CuentaException e) {
                System.out.println(e.getMessage());
            }
        }
        boolean operaciones = true;
        while (operaciones) {
            String comando = MiEntradaSalida.leerLinea("¿Desea ingresar, retirar, consultar o no hacer nada?: \n");
            switch (comando.toLowerCase()) {
                case "ingresar":
                   ingresar(cuenta);
                    break;
                case "retirar":
                    int dineroARetirar = MiEntradaSalida.leerEntero("¿Cuanto desea retirar?\n");
                    try {
                        cuenta.reintegro(dineroARetirar);
                    } catch (CuentaException e) {
                        System.out.println("Error al retirar dinero: " + e.getMessage());
                    }
                    break;
                case "nada":
                    System.out.println("Hasta luego, muchas gracias. Asi ha quedado su saldo:");
                    System.out.println(cuenta.getSaldo() + "€");
                    operaciones = false;
                    break;
                case "consultar":
                    cuenta.consulta();
                    break;
                default:
                    System.out.println("Comando no valido.");
            }
        }
    }
    public static void ingresar(Cuenta cuenta) {
        int dineroAIngresar = MiEntradaSalida.leerEntero("¿Cuanto desea ingresar?\n");
        try {
            cuenta.ingreso(dineroAIngresar);
        } catch (CuentaException e) {
            System.out.println("Error al ingresar dinero: " + e.getMessage());
        }
    }
}

