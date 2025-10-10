import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = MiEntradaSalida.generaAleatorioEntre(-10, 10, true);

        }
        int negativos = 0;
        for (int numero : numeros) {
            if (numero < 0) {
                negativos++;
            }
        }
        System.out.println("En la lista " + Arrays.toString(numeros) + " hay " + negativos + " numeros negativos");
    }
}
