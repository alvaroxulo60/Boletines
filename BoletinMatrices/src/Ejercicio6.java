public class Ejercicio6 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 3, 5,}, {0, 2, 7}};
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println();
        System.out.println(linea(matriz));

    }

    public static String linea(int[][] matriz) {
        StringBuilder linea = new StringBuilder();
        for (int j = matriz[0].length-1; j >=0 ; j--) {
            for (int i = matriz.length-1; i >=0; i--) {
                linea.append(matriz[i][j]).append(" ");
            }
        }
        return linea.toString();
    }
}
