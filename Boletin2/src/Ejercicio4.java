public class Ejercicio4 {
    private static final int MAX_INTENTOS = 5;

    public static void main(String[] args) {
        int random = MiEntradaSalida.generaAleatorioEntre(1, 100, true);
        System.out.println(random);
        int n1;
        int error = 1;
        do {
            n1 = MiEntradaSalida.leerEnteroPositivo("Introduce un numero entre 1 y 100: ", false);
            if (n1 < 1 || n1 > 100) {
                error++;
            }
        } while (n1 < 1 || n1 > 100);
        while (random != n1 && error != MAX_INTENTOS) {
            if (random < n1) {
                System.out.println("El numero secreto es mas pequeño");
                n1 = MiEntradaSalida.leerEnteroPositivo("Introduce un numero entre 1 y 100: ", false);
            } else {
                System.out.println("El numero secreto es mas grande");
                n1 = MiEntradaSalida.leerEnteroPositivo("Introduce un numero entre 1 y 100: ", false);
            }
            error++;
        }
        if (random == n1) {
            System.out.println("Has acertado. Felicidades");
        }
        else  {
            System.out.println("Has fallado, intentalo de nuevo. El numero secreto era " + random);
        }
    }
}