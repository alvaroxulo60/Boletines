package boletin4_3.ejercicio1;

import exceptions.BarajaException;

public class Juego {

    public static void main(String[] args) {
        Baraja barajaEspañola = new Baraja();
        barajaEspañola.mostrarBaraja();
        System.out.println();
        barajaEspañola.barajar();
        System.out.println();
        barajaEspañola.mostrarBaraja();
        System.out.println();
        System.out.println("En la baraja quedan " + barajaEspañola.cartasRestantes());

        try {
            barajaEspañola.repartir(4, 7);
            System.out.println("¡Hecho!");
        } catch (BarajaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("En la baraja quedan " + barajaEspañola.cartasRestantes());
        System.out.println();
        try {
            barajaEspañola.repartir(4, 7);
            System.out.println("¡Hecho!");
        } catch (BarajaException e) {
            System.out.println(e.getMessage());
        }


    }
}
