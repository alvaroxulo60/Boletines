public class Ejercicio13 {
    //Crea un metodo que transforme una matriz CUADRADA (tienes que realizar dicha
    //comprobación) que recibe por parámetro, en otra, que debe ser su reflejo en diagonal (de
    //abajo a la derecha a arriba a la izquierda):
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {3, 2, 1, 4, 5}, {9, 5, 8, 6, 7}, {0, 9, 8, 5, 4}};
        System.out.println("Matriz original: ");
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println();
        System.out.println("Matriz reflejada: ");
        MiEntradaSalida.imprimirMatriz(reflejarMatriz(matriz));
    }

    public static int[][] reflejarMatriz(int[][] matriz){
        int[][] reflejada;
        int[][] error = {{-1}};
        for (int[] ints : matriz) {
            if (matriz.length != ints.length) {
                return error;
            }
        }
        reflejada = new int[matriz.length][matriz[0].length];
        for (int i = matriz.length-1; i>=0; i--) {
            for (int j = matriz[i].length-1; j >=0 ; j--) {
                reflejada[matriz[i].length-1-j][matriz.length-1-i]=matriz[i][j];
            }
        }
        return reflejada;
    }
}
