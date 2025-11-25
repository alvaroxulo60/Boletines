package boletin4_2.Ejercicio3;

import boletin4_2.ejercicio2.*;
import exceptions.MiEntradaSalidaException;
import exceptions.MontarPCException;
import exceptions.VideojuegosException;
import utils.MiEntradaSalida;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        DiscoDuro discoDuro = null;
        Microprocesador microprocesador = null;
        PlacaBase placaBase = null;
        TarjetaGrafica tarjetaGrafica = null;
        Videojuego videojuego1 = new Videojuego("Valorant", "Riot Games", LocalDate.of(2020,6,12),6,2.4f,4,7,4);
        Videojuego videojuego2 = new Videojuego("Minecraft","Mojang",LocalDate.of(2009,5,17),4,1.2f,3,4,2);
        Videojuego[] videojuegos = {videojuego1,videojuego2};

        System.out.println("¡Bienvenido vamos a montar tu ordenador y a comprobar con que videojuegos son disponibles!\n");
        System.out.println("Vamos a empezar con la Placa Base.");
        placaBase = MontarPC.crearPlacaBase();
        System.out.println("¡Muy bien! Ahora vamos con el Microprocesador. \n");
        microprocesador = MontarPC.crearMicroProcesador();
        System.out.println("¡Genial! Vamos ahora con la tarjeta gráfica. \n");
        tarjetaGrafica = MontarPC.crearTarjetaGrafica();
        System.out.println("¡Perfecto! Vamos con lo ultimo, el disco duro. \n");
        discoDuro = MontarPC.crearDiscoDuro();
        System.out.println("Vamos a hacer las comprobaciones necesarias. Espera un momento porfavor. \n");
        MontarPC.comprobar();
        try {
            placaBase.setMicroprocesador(microprocesador);
            System.out.println("\nTu ordenador esta listo. Asi ha quedado:");
            placaBase.componentes();
            System.out.println();
            microprocesador.componentes();
            System.out.println();
            tarjetaGrafica.componentes();
            System.out.println();
            discoDuro.componentes();
            System.out.println();

        } catch (MontarPCException e) {
            System.out.println(e.getMessage());
        }
        Ordenador ordenador = new Ordenador(discoDuro,microprocesador,placaBase,tarjetaGrafica);
        System.out.println("Juegos disponibles: ");
        for (int i = 0; i < videojuegos.length; i++) {
            System.out.println(i+1+videojuegos[i].getName()+"\n");
        }
        int opcion = 0;
        boolean hayOpcion = false;
        while (!hayOpcion) {
            try {
                opcion = MiEntradaSalida.leerEnteroRango("Elige el juego que quieras comprobar si es compatible: ", 1, videojuegos.length) - 1;
                hayOpcion=true;
            } catch (MiEntradaSalidaException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            ordenador.compatibilidad(videojuegos[opcion]);
            System.out.println("El videojuego es compatible");
        } catch (VideojuegosException e) {
            System.out.println(e.getMessage());
        }



    }
}
