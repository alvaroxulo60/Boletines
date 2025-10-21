import java.util.Arrays;

public class Ejercicio8 {
    //Crea un método que devuelva la posición que ocupa un valor dentro de un array, o
    //-1 si el array no contiene ese valor
    public static void main(String[] args) {
        int[] numeros = new int[MiEntradaSalida.generaAleatorio(10)];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i]=MiEntradaSalida.generaAleatorio(numeros.length);
        }
        int consulta = MiEntradaSalida.leerEntero("Introduzca el numero que desea conocer si esta en la lista y su posición: ");
        if (posicionAraray(numeros, consulta) >0) {
            System.out.println("En la lista "+ Arrays.toString(numeros)+" su numero "+consulta+" esta en la posicion "+posicionAraray(numeros, consulta));
        }
        else
            System.out.println(posicionAraray(numeros,consulta));
    }
    public static int posicionAraray(int[] lista, int numero){
        int posicion=-1;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i]== numero){
                posicion=i+1;
            }
        }
        return posicion;
    }
}
