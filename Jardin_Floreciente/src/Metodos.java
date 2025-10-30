public class Metodos {
    final static int SEMILLA = 1;
    final static int AGUA = 2;
    final static int ABEJA = 5;
    final static int HIERBA = 3;
    final static int GUSANO = 4;

    public static boolean agua(int[][] matriz, int fil, int col) {
        for (int i = fil - 1; i <= fil + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == fil && j == col) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == AGUA) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean abeja(int[][] matriz, int fil, int col) {
        for (int i = fil - 3; i <= fil + 3; i++) {
            for (int j = col - 3; j <= col + 3; j++) {
                if (i == fil && j == col) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == ABEJA) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hierba(int[][] matriz, int fil, int col) {
        for (int i = fil - 1; i <= fil + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == fil && j == col) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == HIERBA) {
                        if (gusanos(matriz, fil, col)){
                            return false;
                        }
                        else
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean gusanos(int[][] matriz, int fil, int col) {
        for (int i = fil - 1; i <= fil + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == fil && j == col) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == GUSANO) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean florecer(int[][] matriz, int fil, int colum) {
        return agua(matriz, fil, colum) && abeja(matriz, fil, colum) && (!hierba(matriz, fil, colum) || gusanos(matriz, fil, colum) && hierba(matriz, fil, colum));
    }



    public static void recorreJardin(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1){
                    if(florecer(matriz, i, j)){
                        System.out.printf("La semilla en la posición [%d,%d] va a florecer\n",i,j);
                    }
                }
            }

        }

    }


}
