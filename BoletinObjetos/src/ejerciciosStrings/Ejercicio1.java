package ejerciciosStrings;

import exceptions.MiEntradaSalidaException;
import utils.MiEntradaSalida;

public class Ejercicio1 {

    public static void main(String[] args) {
        String palabra = MiEntradaSalida.leerLinea("Introduce una palabra: ");
        char letra = 0;
        boolean esPalabra = false;
        int contador = 0;

        while (!esPalabra) {
            try {
                letra = MiEntradaSalida.leerChar("lalalala: ");
                esPalabra = true;
            } catch (MiEntradaSalidaException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i)==letra){
                contador++;
            }
        }
        System.out.println(contador);
    }
}
