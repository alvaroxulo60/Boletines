/**
 * Version 1.0
 */

import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero mostrando el mensaje pasado como parámetro
     *
     * @param mensaje El mensaje a mostrar
     * @return el entero leído por teclado
     */
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    public static int leerEnteroPositivo(String mensaje, boolean seAceptaCero) {
        int a;
        do {
            System.out.println(mensaje);
            a = sc.nextInt();
            if (a < 0 || a == 0 && !seAceptaCero) {
                System.out.println("Numero no válido.");
            }

        } while (a < 0 || a == 0 && !seAceptaCero);
        return a;
    }
}
