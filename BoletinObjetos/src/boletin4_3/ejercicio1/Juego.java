package boletin4_3.ejercicio1;

import exceptions.BarajaException;

import java.util.Arrays;

public class Juego {

    public static void main(String[] args) {
        Baraja barajaEspañola = new Baraja();
        barajaEspañola.mostrarBaraja();
        System.out.println();
        barajaEspañola.barajar();
        System.out.println();
        barajaEspañola.mostrarBaraja();
        System.out.println();

        try {
            System.out.println(Arrays.toString(barajaEspañola.repartir(4,7)));

        } catch (BarajaException e) {
            System.out.println(e.getMessage());
        }


    }
}
