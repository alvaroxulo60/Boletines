public class Metodos {
    /**
     * Definimos las constantes
     */
    final static int SEMILLA = 1;
    final static int AGUA = 2;
    final static int ABEJA = 5;
    final static int HIERBA = 3;
    final static int GUSANO = 4;

    /**
     * Comprobar si hay agua cerca de la semilla
     * @param matriz La matriz original
     * @param fil La fila en la que esta la semilla
     * @param col La columna en la que esta la semilla
     *
     * @return a partir de crear una matriz más pequeña devuelve si hay agua o no
     */
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
    /**
     * Comprobar si hay abejas cerca de la semilla
     * @param matriz La matriz original
     * @param fil La fila en la que esta la semilla
     * @param col La columna en la que esta la semilla
     *
     * @return a partir de crear una matriz más pequeña devuelve si hay abejas o no
     */
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
    /**
     * Comprobar si hay hierba cerca de la semilla
     * @param matriz La matriz original
     * @param fil La fila en la que esta la semilla
     * @param col La columna en la que esta la semilla
     *
     * @return a partir de crear una matriz más pequeña devuelve si hay hierba o no
     */
    public static boolean hierba(int[][] matriz, int fil, int col) {
        for (int i = fil - 1; i <= fil + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == fil && j == col) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == HIERBA) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
     * Comprobar si hay gusanos cerca de la semilla
     * @param matriz La matriz original
     * @param fil La fila en la que esta la semilla
     * @param col La columna en la que esta la semilla
     *
     * @return a partir de crear una matriz más pequeña devuelve si hay gusanos o no
     */
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

    /**
     * Comprobar si florece esa semilla
     * @param matriz matriz a recorrer
     * @param fil fila en la que esta
     * @param colum columna en la que esta
     * @return si la semilla florece o no
     */
    public static boolean florecer(int[][] matriz, int fil, int colum) {
        return agua(matriz, fil, colum) && abeja(matriz, fil, colum) && (!hierba(matriz, fil, colum) || gusanos(matriz, fil, colum) && hierba(matriz, fil, colum));
    }


    /**
     * Recorrer el jardin buscando 1
     * @param matriz la matyriz a recorrer
     */
    public static void recorreJardin(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == SEMILLA){
                    if(florecer(matriz, i, j)){
                        System.out.printf("La semilla en la posición [%d,%d] va a florecer\n",i,j);
                    }
                }
            }

        }

    }


}
