import java.util.Arrays;

public class Ejercicio11 {
    //Crea una función que acepte un array de enteros y devuelva el mismo array ordenado
    //de menor a mayor. Utiliza para ello la función de ordenación de la burbuja.
    public static void main(String[] args) {
        int[] numeros = {9,6,5,7,8,1,2,4,3};
        System.out.println(Arrays.toString(ordenarArrayMetodoBurjbuja(numeros)));
    }

    /**
     * Introducir un array y devolverlo ordenado de menor a mayor
     * @param array array a ordenar
     * @return array ordenado
     */
    public static int[] ordenarArrayMetodoBurjbuja(int[] array){
        int aux;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j]>array[j+1]){
                    aux=array[j];
                    array[j]=array[j+1];
                    array[j+1]=aux;
                }
            }
        }
        return array;
    }
}
