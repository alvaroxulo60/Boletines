package boletin4_2.Ejercicio3;

import boletin4_2.ejercicio2.DiscoDuro;
import boletin4_2.ejercicio2.Microprocesador;
import boletin4_2.ejercicio2.PlacaBase;
import boletin4_2.ejercicio2.TarjetaGrafica;
import exceptions.VideojuegosException;

public class Ordenador {
    DiscoDuro discoDuro;
    Microprocesador microprocesador;
    PlacaBase placaBase;
    TarjetaGrafica tarjetaGrafica;


    public Ordenador(DiscoDuro discoDuro, Microprocesador microprocesador, PlacaBase placaBase, TarjetaGrafica tarjetaGrafica) {
        this.discoDuro = discoDuro;
        this.microprocesador = microprocesador;
        this.placaBase = placaBase;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public void compatibilidad(Videojuego videojuego1) throws VideojuegosException {
        if (microprocesador.getNumNucleos()<videojuego1.getNUCLEOS_PROCESADOR()){
            throw new VideojuegosException("Error: La CPU no tiene los suficientes nucleos.");
        }
        if (microprocesador.getVelBase()<videojuego1.getVELOCIDAD_MINIMA_CPU()){
            throw new VideojuegosException("Error: La cpu no tiene suficiente velocidad.");
        }
        if (discoDuro.getCapacidad()<)
    }
}
