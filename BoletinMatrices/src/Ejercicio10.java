public class Ejercicio10 {
    //Crea un metodo que compruebe si una matriz pasada por parámetro es simétrica en
    //función del eje Y. Es decir, la matriz
    public static void main(String[] args) {
        int[][] matriz = {{1, 3, 0, 3, 1}, {4, 2, 7, 2, 4}, {6, 1, 9, 1, 6,}, {0, 8, 8, 8, 0}};
        MiEntradaSalida.imprimirMatriz(matriz);
        if (comprobarSimetriaEjeY(matriz)) {
            System.out.println("La matriz si es simetrica");
        } else
            System.out.println("La matriz no es simetrica");
    }

    /**
     * Comprobar simetria por el eje y
     *
     * @param matriz matriz a comprobar
     * @return un booleano con el resultado de si es simetrica o no
     */
    public static boolean comprobarSimetriaEjeY(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[i][j] != matriz[i][(matriz[i].length - 1) - j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
