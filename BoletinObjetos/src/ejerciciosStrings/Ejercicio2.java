package ejerciciosStrings;

import utils.MiEntradaSalida;

public class Ejercicio2 {
    public static void main(String[] args) {
        String palabra = MiEntradaSalida.leerLinea("lolllolol: ");
        int mayusculas = 0;
        int minusculas = 0;

        for (int i = 0; i < palabra.length(); i++) {
            if (Character.isLowerCase(palabra.charAt(i))) {
                minusculas++;
            } else {
                mayusculas++;
            }
        }

        System.out.println(mayusculas);
        System.out.println(minusculas);
    }
}
