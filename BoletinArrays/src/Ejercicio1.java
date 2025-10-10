import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] entero = {0,1,2,3,4,5,6,7,8,9};
        int suma =0;
        for (int i = 0; i < entero.length ; i+=2) {
            suma+= entero[i];
        }
        System.out.println("La suma de las posisiones pares de la lista "+ Arrays.toString(entero)+" es "+suma);
    }
}
