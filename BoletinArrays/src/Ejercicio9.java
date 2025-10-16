import java.util.Arrays;
import java.util.HashMap;

public class Ejercicio9 {
    public static void main(String[] args) {
        int[] numeros = new int[MiEntradaSalida.generaAleatorio(10)];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = MiEntradaSalida.generaAleatorio(numeros.length);
        }
        System.out.println("Primera lista: "+ Arrays.toString(numeros));
        int anterior = 0;
        for (int i = 0; i <numeros.length ; i++) {
            if (numeros[i]==anterior){
                numeros[i]=0;
            }
            anterior=numeros[i];
        }
        System.out.println("La lista sin repetidos: "+Arrays.toString(numeros));
    }
}
