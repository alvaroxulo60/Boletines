public class Ejercicio9 {
    //Crea un metodo que compruebe si una matriz pasada por parámetro es simétrica en
    //función del eje X. Es decir, la matriz
    public static void main(String[] args) {
        int[][] matriz = {{1, 3, 5, 6}, {4, 2, 0, 8}, {4, 2, 0, 8}, {1, 3, 5, 6}};
        MiEntradaSalida.imprimirMatriz(matriz);
        if (comprobarSimetriaEjeX(matriz)) {
            System.out.println("La matriz si es simetrica");
        } else
            System.out.println("La matriz no es simetrica");
    }

    /**
     * Comprobar simetria por el eje x
     *
     * @param matriz matriz a comprobar simetria
     * @return un booleano con el resultado
     */
    public static boolean comprobarSimetriaEjeX(int[][] matriz) {
        for (int i = 0; i < matriz.length / 2; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != matriz[(matriz.length - 1) - i][j]) {
                    return false;
                }

            }
        }
        return true;
    }
}