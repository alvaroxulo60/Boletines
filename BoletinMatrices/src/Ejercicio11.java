public class Ejercicio11 {
    //Crea un metodo que reciba dos matrices, y compruebe si son matrices inversas, es decir,
    //si tienen los mismos valores en los índices inversos:
    public static void main(String[] args) {
        int[][] matriz1 = {{5, 8, 9, 0}, {4, 7, 5, 2}, {1, 7, 3, 2}};
        int[][] matriz2 = {{2, 3, 7, 1}, {2, 5, 7, 4}, {0, 9, 8, 5}};
        System.out.println("Matriz 1:");
        MiEntradaSalida.imprimirMatriz(matriz1);
        System.out.println();
        System.out.println("Matriz 2:");
        MiEntradaSalida.imprimirMatriz(matriz2);
        System.out.println();
        if (comprobarInverso(matriz1, matriz2)) {
            System.out.println("Las matrices son inversas");
        } else
            System.out.println("Las matrices no son inversas");
    }

    public static boolean comprobarInverso(int[][] matriz1, int[][] matriz2) {
        if (Ejercicio7.comprobarTamañoMatrices(matriz1, matriz2)) {
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    if (matriz1[i][j] != matriz2[(matriz2.length - 1) - i][(matriz2[i].length - 1) - j]) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
