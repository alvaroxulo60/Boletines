package boletin4_3.ejercicio1;

import utils.MiEntradaSalida;

import java.util.Objects;

public class Carta {
    private String palo;
    private int numero;

    public Carta() {
        setPalo(paloDeCarta());
        setNumero(numeroDeCarta());
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    private String paloDeCarta(){
        String[] palos={"oro","bastos","espadas","copas"};
        return palos[MiEntradaSalida.generaAleatorio(palos.length)];
    }

    private int numeroDeCarta(){
        return MiEntradaSalida.generaAleatorioEntre(1,12,true);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Carta carta = (Carta) o;
        return numero == carta.numero && Objects.equals(palo, carta.palo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(palo);
        result = 31 * result + numero;
        return result;
    }
}
