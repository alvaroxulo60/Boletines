import java.util.Arrays;

public class Ejercicio9B {
    public static void main(String[] args) {
        int[] numeros = new int[MiEntradaSalida.generaAleatorio(10)];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = MiEntradaSalida.generaAleatorio(numeros.length);
        }
        System.out.println("Primera lista: " + Arrays.toString(numeros));
        int[] copia = Arrays.stream(numeros)
                .distinct()
                .toArray();
        System.out.println(Arrays.toString(copia));
    }
}
