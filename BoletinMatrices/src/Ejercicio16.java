public class Ejercicio16 {
    //Crea un metodo que compruebe, sobre una matriz de enteros, cuántas casillas
    //adyacentes tienen valores pares. Se considera adyacente todas las posiciones
    //colindantes, incluidas las diagonales. En el siguiente ejemplo, el 7 (en rojo) tiene 4
    //casillas colindantes con números pares. El resultado se deberá guardar en otra matriz,
    //que contendrá dichos números. Para este ejercicio, consideraremos que el 0 es par.

    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {3, 2, 1, 4, 5}, {9, 5, 8, 6, 7}, {0, 9, 8, 5, 4}};
        System.out.println("La matriz OG");
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println();
        System.out.println("El resultado es: ");
        MiEntradaSalida.imprimirMatriz(adyacentesPares(matriz));
    }

    public static int[][] adyacentesPares(int[][] matriz) {
        int[][] nueva = new int[matriz.length][matriz[0].length];
        //Arrays para el desplazamiento en las 8 direcciones
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int contador = 0;
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    //Comprueba que la posicion no esta fuera de los limites de la matriz
                    if (ni >= 0 && ni < matriz.length && nj >= 0 && nj < matriz[0].length) {
                        if (matriz[ni][nj] % 2 == 0) {
                            contador++;
                        }
                    }
                }
                nueva[i][j] = contador;
            }
        }
        return nueva;
    }
}
