public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] matriz = {{1, 5, 8, 4}, {5, 4, 6, 8},{8,4,3,6}};
        int suma =0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma+=matriz[i][j];
            }
        }
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println("La suma de los valores de la matriz es: "+suma);
    }
}
