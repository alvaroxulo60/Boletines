public class Ejercicio8 {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2}, {4, 6}};
        int[][] matriz2 = {{4, 1}, {1, 0}};
    }
   
    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2){
        if (matriz1.length != matriz2.length) {
            return 
        }
        for (int i = 0; i < matriz1.length; i++) {
            if (matriz1[i].length != matriz2[i].length) {
                return false;
            }
        }
    }
}
