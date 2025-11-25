package boletin4_2.Ejercicio3;

import boletin4_2.ejercicio2.DiscoDuro;
import boletin4_2.ejercicio2.Microprocesador;
import boletin4_2.ejercicio2.PlacaBase;
import boletin4_2.ejercicio2.TarjetaGrafica;
import exceptions.VideojuegosException;

public class Ordenador {
     private DiscoDuro discoDuro;
     private Microprocesador microprocesador;
     private PlacaBase placaBase;
     private TarjetaGrafica tarjetaGrafica;


    public Ordenador(DiscoDuro discoDuro, Microprocesador microprocesador, PlacaBase placaBase, TarjetaGrafica tarjetaGrafica) {
        this.discoDuro = discoDuro;
        this.microprocesador = microprocesador;
        this.placaBase = placaBase;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public void compatibilidad(Videojuego videojuego) throws VideojuegosException {
        if (microprocesador.getNumNucleos()<videojuego.getNUCLEOS_PROCESADOR()){
            throw new VideojuegosException("Error: La CPU no tiene los suficientes núcleos.");
        }
        if (microprocesador.getVelBase()<videojuego.getVELOCIDAD_MINIMA_CPU()){
            throw new VideojuegosException("Error: La cpu no tiene suficiente velocidad.");
        }
        if (discoDuro.getCapacidad()<videojuego.getCAPACIDAD_MINIMA_DISCO()){
            throw new VideojuegosException("Error: El disco duro no tiene suficiente espacio");
        }
        if (tarjetaGrafica.getNumNucleos()<videojuego.getMINIMOS_NUCLEOS_GPU()){
            throw new VideojuegosException("Error: La GPU no tiene suficientes núcleos.");
        }
        if (tarjetaGrafica.getCapacidad()<videojuego.getMINIMA_MEMORIA_GPU()){
            throw new VideojuegosException("Error: La GPU no tiene suficiciente memoria.");
        }
    }
}
