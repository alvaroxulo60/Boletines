/**
 * Version 1.1
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
            a = leerEntero(mensaje);
            if (a < 0 || a == 0 && !seAceptaCero) {
                System.out.println("Numero no válido.");
            }

        } while (a < 0 || a == 0 && !seAceptaCero);
        return a;
    }

    /**
     * Leer un decimal
     *
     * @param mensaje El mensaje a introducir
     * @return Lo introducido por el usuario
     */
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

    /**
     * Generar un número aleatorio determinado por un máximo
     *
     * @param max hasta que número se va a generar
     * @return número generado aleatoriamente
     */
    public static int generaAleatorio(int max) {
        return (int) (Math.random() * max + 1);
    }

    /**
     * Generar un número aleatorio entre un máximo y un mínimo
     *
     * @param min              Primer número del intervalo
     * @param max              Segundo número del intervalo
     * @param seAceptaElMaximo ¿El máximo entra en ese intervalo?
     * @return El número genrado aleatoriamente
     */
    public static int generaAleatorioEntre(int min, int max, boolean seAceptaElMaximo) {
        int random = 0, ventana;

        if (seAceptaElMaximo) {
            ventana = max - min + 1;
        } else {
            ventana = max - min;
        }
        return (int) (Math.random() * ventana) + min;
    }

    /**
     * Resolver ecuaciones de 2do grado
     *
     * @param a          índice que acompaña a la x al cuadrado
     * @param b          índice que acompaña a la x
     * @param c          termino independiente
     * @param resultados ¿Mostrar resultados?
     * @return número de resultados y los valores si se indica
     */
    public static int ecuacionSegundoGrado(double a, double b, double c, boolean resultados) {
        double raiz = (b * b) - 4 * a * c;
        if (raiz > 0) {
            double x1 = (-b + Math.sqrt(raiz)) / (2 * a);
            double x2 = (-b - Math.sqrt(raiz)) / (2 * a);
            if (resultados) {
                System.out.println("x1= " + x1 + " y x2= " + x2);
            }
            return 2;
        } else if (raiz == 0) {
            double x3 = -b / (2 * a);
            if (resultados) {
                System.out.println("x3= " + x3);
            }
            return 1;
        } else {
            if (resultados) {
                System.out.println("No tiene soluciones");
            }
            return 0;
        }
    }

    /**
     * Leer una cadena de texto
     *
     * @param mensaje Mensaje a mostrar
     * @return String leido
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.next();
    }

    /**
     * Leer entero en un rango
     *
     * @param mensaje mensaje a mostrar
     * @param min     valor mínimo incluido
     * @param max     valor máximo incluido
     * @return Numero leido por teclado
     */
    public static int leerEnteroRango(String mensaje, int min, int max) {
        if (min > max) {
            //Mostrar error
            System.out.println("El mínimo es mayor que el máximo");
            //TODO: Cambiar esto a ver las excepciones
            return -1;
        }
        int a;
        do {
            a = leerEntero(mensaje);
            if (a < min || a > max) {
                System.out.println("Número no válido, esta fuera del rango.");
            }
        } while (a < min || a > max);
        return a;
    }
}
