package Ejercicio2;

import utils.MiEntradaSalida;

public class Principal {
    public static void main(String[] args) {
        System.out.printf("Bienvenido a BermudoBank.%n");
        Cuenta cuenta = new Cuenta();
        boolean operaciones = true;
        while (operaciones){
            System.out.printf("Ahora mismo tiene %s€ en su cuenta \n", cuenta.getSaldo());
            String comando = MiEntradaSalida.leerLinea("¿Desea ingeresar, retirar o no hacer nada?: \n");
            switch (comando.toLowerCase()){
                case "ingresar":
                    int dineroAIngresar = MiEntradaSalida.leerEnteroPositivo("¿Cuanto desea ingresar?\n",true);
                    cuenta.ingreso(dineroAIngresar);
                    break;
                case "retirar":

                    int dineroARetirar = MiEntradaSalida.leerEnteroPositivo("¿Cuanto desea retirar?",true);
                    if (cuenta.getSaldo()<dineroARetirar){
                        System.out.print("No tienes suficiente dinero en la cuenta. ");
                        break;
                    }
                    cuenta.reintegro(dineroARetirar);
                    break;
                case "nada":
                    System.out.println("Hasta luego, muchas gracias. Asi ha quedado su saldo:");
                    System.out.println(cuenta.getSaldo()+"€");
                    operaciones=false;
                    break;
                default:
                    System.out.println("Comando no valido.");
            }
        }
    }
}
