public class Ejercicio16 {
    //Crea un metodo que compruebe, sobre una matriz de enteros, cuántas casillas
    //adyacentes tienen valores pares. Se considera adyacente todas las posiciones
    //colindantes, incluidas las diagonales. En el siguiente ejemplo, el 7 (en rojo) tiene 4
    //casillas colindantes con números pares. El resultado se deberá guardar en otra matriz,
    //que contendrá dichos números. Para este ejercicio, consideraremos que el 0 es par.

    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {3, 2, 1, 4, 5}, {9, 5, 8, 6, 7}, {0, 9, 8, 5, 4}};
        MiEntradaSalida.imprimirMatriz(matriz);
    }

}
