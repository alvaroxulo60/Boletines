public class Ejercicio7 {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 3, 5,}, {0, 2, 7}};
        int[][] matriz2 = {{1, 3, 5,}, {0, 2, 7}};
        int[][] matriz3 = {{1, 3}, {0, 2}};
        String respuesta1;
        String respuesta2;
        System.out.println("Matriz 1");
        MiEntradaSalida.imprimirMatriz(matriz1);
        System.out.println();
        System.out.println("Matriz 2");
        MiEntradaSalida.imprimirMatriz(matriz2);
        System.out.println();
        System.out.println("Matriz 3");
        MiEntradaSalida.imprimirMatriz(matriz3);
        System.out.println();
        if (comprobarTamañoMatrices(matriz1, matriz2)) {
            respuesta1 = "sí";
        } else {
            respuesta1 = "no";
        }
        if (comprobarTamañoMatrices(matriz2, matriz3)) {
            respuesta2 = "sí";
        } else {
            respuesta2 = "no";
        }
        System.out.println("¿La matriz 1 es igual a la 2? " + respuesta1);
        System.out.println();
        System.out.println("¿La matriz 2 es igual a la 3? " + respuesta2);
    }

    public static boolean comprobarMatrices(int[][] matriz1, int[][] matriz2) {
        if (comprobarTamañoMatrices(matriz1, matriz2)){
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    if (matriz1[i][j] != matriz2[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        return false;

    }

    public static boolean comprobarTamañoMatrices(int[][] matriz1, int[][] matriz2){
        if (matriz1.length != matriz2.length) {
            return false;
        }
        for (int i = 0; i < matriz1.length; i++) {
            if (matriz1[i].length != matriz2[i].length) {
                return false;
            }
        }

        return true;
    }

}

