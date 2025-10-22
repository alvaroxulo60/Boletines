import java.util.Arrays;

public class Ejercicio9 {
    //Crea un array que devuelva un nuevo array donde se hayan eliminado los elementos
    //duplicados del primero

    public static void main(String[] args) {
        int[] numeros = new int[MiEntradaSalida.generaAleatorio(10)];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = MiEntradaSalida.generaAleatorio(numeros.length);
        }
        System.out.println("Primera lista: " + Arrays.toString(numeros));
        System.out.println();
        System.out.println("La lista sin duplicados es: "+ Arrays.toString(eliminarDuplicados(numeros)));


    }
    public static int[] eliminarDuplicados(int[] lista) {
        int[] listaSinDuplicados= new int[lista.length];
        int posListaSinDuplicados=0;
        boolean heTratadoElCero=false;

        for (int j : lista) {
            if (j == 0 && !heTratadoElCero) {
                posListaSinDuplicados++;
                heTratadoElCero = true;
                continue;
            }
            if (!contieneElemento(listaSinDuplicados, j)) {
                listaSinDuplicados[posListaSinDuplicados++] = j;
            }
        }
        listaSinDuplicados=Arrays.copyOf(listaSinDuplicados,posListaSinDuplicados);
        return listaSinDuplicados;

    }
    public static boolean contieneElemento(int[] lista, int consulta){
        for (int n : lista){
            if ( consulta == n){
                return true;
            }
        }
        return false;
    }
}
