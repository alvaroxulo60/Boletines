public class Ejercicio15 {
    //Crear un metodo que devuelva el número de casilla a la que corresponden unas
    //coordenadas. Es decir, el número de casilla empezando por la casilla [0,0], y recorriendo
    //primero por filas y luego por columnas. Por ejemplo, la casilla [1,5] en una matriz de 6x6
    //ocuparía el número 12. En la misma matriz, la casilla [4,0] ocuparía el número 25.

    public static void main(String[] args) {
        int i = MiEntradaSalida.leerEntero("Introduce la primera cordenada de una matriz 6x6: ");
        int j = MiEntradaSalida.leerEntero("Introduzca la segunda cordenada de la matriz: ");
        int num =1;
        int[][] matriz = new int[6][6];
        for (int k = 0; k < 6; k++) {
            for (int l = 0; l < 6; l++) {
                matriz[k][l]=num++;
            }
        }
        System.out.println();
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println();
        System.out.println("La posicion que ocupa en la matriz las casilla de las cordenadas " + "[" + i + "," + j + "] es la " + numCasillas(matriz, i, j));
    }

    public static int numCasillas(int[][] matriz, int i, int j) {
        return matriz[0].length*i+j+1;
    }
}
