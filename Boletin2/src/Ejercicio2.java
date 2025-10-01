import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int exponente;
        int base;
        int resultado = 1;
        base = MiEntradaSalida.leerEnteroPositivo("Introduce un numero base: ", true);
        exponente = MiEntradaSalida.leerEnteroPositivo("Introduce un exponente", true);
        for (int i = 1; i <= exponente; i++) {
            resultado *= base;
        }
        System.out.printf("El resultado de %d elevado a %d es %d", base, exponente, resultado);
    }
}
