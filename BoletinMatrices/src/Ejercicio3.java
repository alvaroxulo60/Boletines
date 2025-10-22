public class Ejercicio3 {
    public static void main(String[] args) {
        int[][] matriz = {{1,3,5,},{0,2,7}};
        MiEntradaSalida.imprimirMatriz(matriz);
        System.out.println(linea(matriz));
    }
    public static StringBuilder linea(int[][] matriz){
        StringBuilder linea = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                linea.append(matriz[i][j]).append(" ");
            }
        }
        return linea;
    }
}
