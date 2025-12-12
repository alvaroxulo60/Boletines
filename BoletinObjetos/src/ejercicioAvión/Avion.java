package ejercicioAvión;

import exceptions.AvionException;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Avion {
    public static final int NUM_REVISIONES = 5;

    private String marca;
    private String modelo;
    private double consumo;
    private DepositoCombustible combustible;
    private Revision[] revisiones;


    public Avion(String marca, String modelo, double consumo, DepositoCombustible combustible)throws AvionException {
        this.marca = marca;
        this.modelo = modelo;
        setConsumo(consumo);
        this.combustible = combustible;
        revisiones = new Revision[NUM_REVISIONES];
    }

    public void setConsumo(double consumo) throws AvionException {
        if (consumo <= 0 ) {throw new AvionException("El consumo no puede ser negativo o 0");
        }
        this.consumo = consumo;
    }


    public boolean estaListo() {
        try {
            Revision ultimaRevsion = getUltimaRevsion();
            return ultimaRevsion.isEstado() && !ultimaRevsion.getFecha().plus(ultimaRevsion.getPeriodoValidez()).isBefore(LocalDate.now());
        } catch (AvionException e) {
            return false;
        }
    }


    private Revision getUltimaRevsion() throws AvionException {
        for (int i = revisiones.length-1; i >=0; i--) {
            if (revisiones[i]!=null){
                return revisiones[i];
            }
        }
        throw new AvionException("No hay revisiones");
    }

    @Override
    public String toString() {
        return "Avion{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", consumo=" + consumo +
                ", combustible=" + combustible +
                ", ¿Listo para viajar? " + estaListo() +
                '}';
    }
}
