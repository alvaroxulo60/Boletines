import java.util.Arrays;

public class Ejercicio10 {
    //Crea una función que acepte 2 arrays, y devuelva un nuevo array con los elementos que ambos arrays tienen en común.

    public static void main() {
        int[] numeros = {1,2,3,4,12,6,7,8,9,9,2,47,25,3,6,9,5,7,5,4,2,6,45};

        int[] numeros2 = {1,2,3,4,5,6,7,47,9,45,2,7,5,2};

        System.out.println(Arrays.toString(unirArraysComunes(numeros, numeros2)));
    }

    public static int[] unirArraysComunes(int[] lista1, int[] lista2) {
        int size = 0;
        int comparacion = Math.min(lista1.length,lista2.length);
        int[] comunes = new int[lista1.length];
        for (int i = 0; i < comparacion; i++) {
            if (contieneElemento(lista1, lista2[i]) && !contieneElemento(comunes,lista2[i])){
                comunes[size++]=lista2[i];
            }
        }
        comunes=Arrays.copyOf(comunes,size);
        return comunes;
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
