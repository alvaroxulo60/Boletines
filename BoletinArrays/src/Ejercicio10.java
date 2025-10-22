import java.util.Arrays;

public class Ejercicio10 {
    //Crea una función que acepte 2 arrays, y devuelva un nuevo array con los elementos que ambos arrays tienen en común.

    public static void main() {
        int[] numeros = {1,2,3,4,12,6,7,8,9,9,2,47,25,3,6,9,5,7,5,4,2,6,45};

        int[] numeros2 = {1,2,3,4,5,6,7,47,9,45,2,7,5,2};

        System.out.println(Arrays.toString(unirArraysComunes(numeros, numeros2)));
    }

    /**
     * Comparar los arrays y devolver un nuevo array con los comunes
     * @param lista1  Primera lista a comparar
     * @param lista2  Segunda lista a comparar
     * @return una lista con los valores comunes sin elementos duplicados
     */
    public static int[] unirArraysComunes(int[] lista1, int[] lista2) {
        int size = 0;
        int[] comunes = new int[Math.min(lista1.length,lista2.length)];
        for (int i = 0; i < comunes.length; i++) {
            if (contieneElemento(lista1, lista2[i]) && !contieneElemento(comunes,lista2[i])){
                comunes[size++]=lista2[i];
            }
        }
        comunes=Arrays.copyOf(comunes,size);
        return comunes;
    }

    /**
     * Comprobar si en una lista hay un valor determinado
     * @param lista lista de números en la que queremos comprobar si aparece el numero
     * @param consulta el número que queremos saber si esta en la lista
     * @return true si esta en la lista, false si no esta
     */
    public static boolean contieneElemento(int[] lista, int consulta){
    for (int n : lista){
        if ( consulta == n){
            return true;
        }
    }
    return false;
}

}
