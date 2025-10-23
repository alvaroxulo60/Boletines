import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[][] matriz = {{1, -5, 8, 4}, {5, 4, 6, 8}};
        MiEntradaSalida.imprimirMatriz(matriz);
        if (comprobarNegativoMatrices(matriz)) {
            System.out.print("En la matriz si hay un valor negativo");
        } else
            System.out.print("En la matriz no hay un valor negativo");
    }

    public static boolean comprobarNegativoMatrices(int[][] matriz) {
        boolean encontrado=false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 0) {
                   encontrado=true;
                   break;
                }
            }
            if (encontrado){
                break;
            }
        }
        return encontrado;
    }
}
