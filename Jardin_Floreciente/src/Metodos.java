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
     *
     * @param matriz La matriz original
     * @param fil    La fila en la que esta la semilla
     * @param col    La columna en la que esta la semilla
     * @return Llama al metodo buscarElemento y comprueba
     */
    public static boolean agua(int[][] matriz, int fil, int col) {
        return buscaElemento(matriz, fil, col, 1, AGUA);
    }

    /**
     * Comprobar si hay abejas cerca de la semilla
     *
     * @param matriz La matriz original
     * @param fil    La fila en la que esta la semilla
     * @param col    La columna en la que esta la semilla
     * @return Llama al metodo buscarElemento y comprueba
     */
    public static boolean abeja(int[][] matriz, int fil, int col) {
        return buscaElemento(matriz, fil, col, 3, ABEJA);
    }

    /**
     * Comprobar si hay hierba cerca de la semilla
     *
     * @param matriz La matriz original
     * @param fil    La fila en la que esta la semilla
     * @param col    La columna en la que esta la semilla
     * @return Llama al metodo buscarElemento y comprueba
     */
    public static boolean hierba(int[][] matriz, int fil, int col) {
        return buscaElemento(matriz, fil, col, 1, HIERBA);
    }

    /**
     * Comprobar si hay gusanos cerca de la semilla
     *
     * @param matriz La matriz original
     * @param fil    La fila en la que esta la semilla
     * @param col    La columna en la que esta la semilla
     * @return Llama al metodo buscarElemento y comprueba
     */
    public static boolean gusanos(int[][] matriz, int fil, int col) {
        return buscaElemento(matriz, fil, col, 1, GUSANO);
    }

    /**
     * Comprobar si florece esa semilla
     *
     * @param matriz matriz a recorrer
     * @param fil    fila en la que esta
     * @param colum  columna en la que esta
     * @return si la semilla florece o no
     */
    public static boolean florecer(int[][] matriz, int fil, int colum) {
        return agua(matriz, fil, colum) && abeja(matriz, fil, colum) && (!hierba(matriz, fil, colum) || gusanos(matriz, fil, colum) && hierba(matriz, fil, colum));
    }


    /**
     * Recorrer el jardin buscando 1
     *
     * @param matriz la matyriz a recorrer
     */
    public static void recorreJardin(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == SEMILLA) {
                    if (florecer(matriz, i, j)) {
                        System.out.printf("La semilla en la posición [%d,%d] va a florecer\n", i, j);
                    }
                }
            }

        }

    }

    /**
     * Buscar elemento en una matriz
     *
     * @param matriz         matriz a recorrer
     * @param fil            fila de la posicion inicial
     * @param col            columna de la posicion inicial
     * @param rango          en que area buscar
     * @param elementoBuscar Que es lo que buscas
     * @return devuelve si esta o no
     */
    public static boolean buscaElemento(int[][] matriz, int fil, int col, int rango, int elementoBuscar) {
        for (int i = fil - rango; i <= fil + rango; i++) {
            for (int j = col - rango; j <= col + rango; j++) {
                if (i == fil && j == col) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == elementoBuscar) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
