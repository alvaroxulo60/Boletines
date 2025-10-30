public class Ejercicio16 {
    //Crea un metodo que compruebe, sobre una matriz de enteros, cuántas casillas
    //adyacentes tienen valores pares. Se considera adyacente todas las posiciones
    //colindantes, incluidas las diagonales. En el siguiente ejemplo, el 7 (en rojo) tiene 4
    //casillas colindantes con números pares. El resultado se deberá guardar en otra matriz,
    //que contendrá dichos números. Para este ejercicio, consideraremos que el 0 es par.

    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {3, 2, 1, 4, 5}, {9, 5, 8, 6, 7}, {0, 9, 8, 5, 4}};
        System.out.println("La matriz OG:");
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println();
        System.out.println("El resultado es: ");
        MiEntradaSalida.imprimirMatriz(generarMatrizResultado(matriz));
    }

    public static int adyacentesPares(int[][] matriz, int fila, int columa) {
        int contador = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columa - 1; j <= columa + 1; j++) {
                if (i == fila && j == columa) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (esPar(matriz[i][j])) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public static boolean esPar(int valor) {
        return valor % 2 == 0;
    }

    public static int[][] generarMatrizResultado(int[][] matriz) {  //Función para generar la matriz resultado
        int[][] resultado = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                resultado[i][j] = adyacentesPares(matriz, i, j);
            }
        }
        return resultado;
    }
}

