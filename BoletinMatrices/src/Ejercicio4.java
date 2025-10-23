public class Ejercicio4 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 3, 5,}, {0, 2, 7}};
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println();
        System.out.println(linea(matriz));

    }

    public static String linea(int[][] matriz) {
        StringBuilder linea = new StringBuilder();
        for (int i = matriz.length-1; i >= 0; i--) {
            for (int j = matriz[i].length-1; j >= 0; j--) {
                linea.append(matriz[i][j]).append(" ");
            }
        }
        return linea.toString();
    }
}
