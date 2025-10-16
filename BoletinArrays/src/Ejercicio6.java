import java.util.Arrays;

public class Ejercicio6 {
    public static void main(String[] args) {
        int size = MiEntradaSalida.generaAleatorio(10);
        int[] numeros = new int[size];
        boolean estaEnLIsta= false;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i]=MiEntradaSalida.generaAleatorio(10);
        }
        int consulta = MiEntradaSalida.leerEntero("Introduzca el numero que desa conocer si esta en la lista: ");
        for (int n1 : numeros){
            if (n1 == consulta) {
                estaEnLIsta = true;
                break;
            }
        }
        if (estaEnLIsta){
            System.out.printf("El numero %d esta en la lista",consulta);
        }
        else {
            System.out.printf("EL numero %d no esta en la lista", consulta);
        }
        System.out.println(Arrays.toString(numeros));
    }

}
