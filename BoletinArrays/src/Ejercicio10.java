import java.util.Arrays;

public class Ejercicio10 {
    public static void main() {
        int[] numeros = new int[10];
        int size = 0;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = MiEntradaSalida.generaAleatorio(numeros.length);
        }
        int[] numeros2 = new int[10];
        for (int i = 0; i < numeros2.length; i++) {
            numeros2[i] = MiEntradaSalida.generaAleatorio(numeros2.length);
        }
        System.out.println(Arrays.toString(unirArraysComunes(numeros, numeros2)));
    }

    public static int[] unirArraysComunes(int[] lista1, int[] lista2) {
        int size = 10;
        Arrays.sort(lista1);
        Arrays.sort(lista2);
        int[] comunes = new int[size];
        for (int i = 0; i < 10; i++) {
            if (lista1[i] == lista2[i]) {
                comunes[i] = lista1[i];
            }
        }
        return comunes;
    }
}
