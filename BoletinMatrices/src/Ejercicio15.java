public class Ejercicio15 {
    public static void main(String[] args) {
        int i= MiEntradaSalida.leerEntero("Introduce la primera cordenada de una matriz 6x6: ");
        int j = MiEntradaSalida.leerEntero("Introduzca la segunda cordenada de la matriz 6x6: ");
        int[][] matriz = new int[6][6];
        int num =1;
        for (int k = 0; k < 6; k++) {
            for (int l = 0; l < 6 ; l++) {
             matriz[k][l]=num++;
            }
        }
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println("La posicion que ocupa en la matriz las casilla de las cordenadas "+"["+i+","+j+"] es la "+ numCasillas(i,j));
    }

    public static int numCasillas(int i, int j){
        return (i+1)*(j+1);
    }
}
