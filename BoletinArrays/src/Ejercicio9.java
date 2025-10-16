import java.util.Arrays;

public class Ejercicio9 {
    public static void main(String[] args) {
        int[] numeros = new int[MiEntradaSalida.generaAleatorio(10)];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = MiEntradaSalida.generaAleatorio(numeros.length);
        }
        System.out.println("Primera lista: " + Arrays.toString(numeros));
        Arrays.sort(numeros);
        int nuevoTam = eliminarDuplicados(numeros, numeros.length);
        int[] nuevo = new int[nuevoTam];
        for (int i = 0; i < nuevoTam; i++) {
            nuevo[i] = numeros[i];
        }
        System.out.println("Aquí esta la lista sin duplicados y ordenada: "+Arrays.toString(nuevo));
    }


    public static int eliminarDuplicados(int[] lista, int n) {
        if (n == 1 || n == 0) return n;
        int x = 0;
        for (int i = 0; i < n - 1; i++) {
            if (lista[i] != lista[i + 1]) {
                lista[x++] = lista[i];
            }

        }
        lista[x++] = lista[n - 1];
        return x;
    }
}
