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
            barajaEspañola.repartir(4,7);
            System.out.println("¡Hecho!");
        } catch (BarajaException e) {
            System.out.println(e.getMessage());
        }
        try {
            barajaEspañola.repartir(4,7);
            System.out.println("¡Hecho!");
        }catch (BarajaException e){
            System.out.println(e.getMessage());
        }


    }
}
