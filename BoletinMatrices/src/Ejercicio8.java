public class Ejercicio8 {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2}, {4, 6}};
        int[][] matriz2 = {{4, 1}, {1, 0}};
        System.out.println("Matriz 1");
        MiEntradaSalida.imprimirMatriz(matriz1);
        System.out.println();
        System.out.println("Matriz 2");
        MiEntradaSalida.imprimirMatriz(matriz2);
        System.out.println();
        System.out.println("La suma es:");
        MiEntradaSalida.imprimirMatriz(sumarMatrices(matriz1,matriz2));
    }

    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2){
        int[][] suma;
        int[][] error = {{-1}};
        if (Ejercicio7.comprobarTamañoMatrices(matriz1, matriz2)){
            suma = new int[matriz1.length][matriz1[0].length];
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    suma[i][j]=matriz1[i][j]+matriz2[i][j];
                }
            }
            return suma;
        }
        return error;
    }

}
