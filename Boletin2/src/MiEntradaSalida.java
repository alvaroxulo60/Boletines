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

    /**
     * Número entero
     *
     * @param mensaje      El mensaje a mostrar
     * @param seAceptaCero Si el 0 esta incluido
     * @return El entero leido por teclado
     */
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

    public static double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        return sc.nextDouble();
    }

    /**
     * Minimo Común Divisor de 2 números
     *
     * @param a primer numero
     * @param b segundo numero
     * @return el mcd
     */
    public static int mcd(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }


    public static int generaAleatorio(int max) {
        return (int) (Math.random() * max + 1);
    }

    public static int generaAleatorioEntre(int min, int max, boolean seAceptaElMaximo) {
        int random = 0, ventana;

        if (seAceptaElMaximo) {
            ventana = max - min + 1;
        } else {
            ventana = max - min;
        }
        return (int) (Math.random() * ventana) + min;
    }

    public static int ecuacionSegundoGrado(double a, double b, double c, boolean resultados) {
        double raiz = (b * b) - 4 * a * c;
        if (raiz > 0) {
            double x1 = (-b + Math.sqrt(raiz)) / (2 * a);
            double x2 = (-b - Math.sqrt(raiz)) / (2 * a);
            if (resultados){
                System.out.println("x1= "+x1+ " y x2= "+x2);
            }
            return 2;
        }
        if (raiz == 0) {
            double x3 = -b / (2 * a);
            if (resultados) {
                System.out.println("x3=" + x3);
            }
            return 1;
        } else {
            if (resultados) {
                System.out.println("No tiene soluciones");
            }
            return 0;
        }
    }

}
