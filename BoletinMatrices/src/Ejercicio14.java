public class Ejercicio14 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {3, 2, 1, 4, 5}, {9, 5, 8, 6, 7}, {0, 9, 8, 5, 4}};
        System.out.println("Matriz original: ");
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println();
        System.out.println("Matriz reflejada: ");
        MiEntradaSalida.imprimirMatriz(reflejarMatriz(matriz));
    }

    public static int[][] reflejarMatriz(int[][] matriz) {
        int[][] reflejada;
        int[][] error = {{-1}};
        for (int i = 0; i < matriz.length; i++) {
            if (matriz.length != matriz[i].length) {
                return error;
            }
        }
        reflejada = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    reflejada[i][j] = matriz[i][j];
                } else {
                    reflejada[j][i] = matriz[i][j];
                }
            }
        }
        return reflejada;
    }
}


