package ejerciciosStrings;

import utils.MiEntradaSalida;

public class Ejercicio3 {
    public static void main(String[] args) {
        String palabra = MiEntradaSalida.leerLinea("Texto: ");
        StringBuilder aux = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            aux.append(palabra.charAt(i));
        }
        if (palabra.contentEquals(aux)){
            System.out.println("si");
        }
        else {
            System.out.println("no");
        }
    }
}
