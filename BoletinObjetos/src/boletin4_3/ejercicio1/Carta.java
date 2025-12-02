package boletin4_3.ejercicio1;

import utils.MiEntradaSalida;

import java.util.Objects;

public class Carta {
    private String palo;
    private int numero;

    public Carta(String palo, int numero) {
        setPalo(palo);
        setNumero(numero);
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    private void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return numero +" de "+palo;
    }
}
