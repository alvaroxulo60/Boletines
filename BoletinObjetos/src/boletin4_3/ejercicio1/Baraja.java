package boletin4_3.ejercicio1;

import java.util.Arrays;

public class Baraja {
    private Carta[] baraja = new Carta[40];

    public Baraja() {
        crearBaraja();
    }

    public Carta[] getBaraja() {
        return baraja;
    }

    public void setBaraja(Carta[] baraja) {
        this.baraja = baraja;
    }

    public void crearBaraja() {
        String[] palo = {"oros", "bastos", "copas", "espadas"};
        int posicionBaraja = 0;
        for (int i = 0; i < palo.length; i++) {
            for (int j = 1; j <= 12; j++) {
                if (j == 8 || j == 9) {
                    continue;
                }
                baraja[posicionBaraja] = new Carta(palo[i], j);
                posicionBaraja++;
            }
        }
    }

    public void mostrarBaraja() {
        System.out.println(toString());
    }

    public void barajar(){

    }

    @Override
    public String toString() {
        return "Baraja{" +
                "baraja=" + Arrays.toString(baraja) +
                '}';
    }
}
