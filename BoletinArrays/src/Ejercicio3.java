import java.util.Arrays;

public class Ejercicio3 {
    public static void main(String[] args) {
        int cant = MiEntradaSalida.leerEnteroPositivo("Introduce cuantos numeros va a introducir en la lista: ", false);
        int[] numeros = new int[cant];
        double media;
        double suma=0;
        for (int i = 0; i <numeros.length ; i++) {
            numeros[i]=MiEntradaSalida.leerEntero("Introduce tu "+(i+1)+"º número: ");
        }
        Arrays.sort(numeros);
        for (int numero : numeros) {
            suma += numero;
        }
        media = suma / numeros.length;
        System.out.println("El numero mas pequeño es "+numeros[0]);
        System.out.printf("El numero mas grande es %d\n",numeros[(cant-1)]);
        System.out.println("La media es "+ media);
    }
}
