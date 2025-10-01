public class Ejercicio4 {
    public static void main(String[] args) {
        int random = (int) (Math.random() * 100);
        int n1;
        int error = 1;
        do {
            n1 = MiEntradaSalida.leerEnteroPositivo("Introduce un numero entre 1 y 100: ", false);
            if (n1 < 0 || n1 > 100) {
                error++;
            }
        } while (n1 < 0 || n1 > 100);
        while (random != n1 && error != 5) {
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
        if (error == 5) {
            System.out.println("Has fallado, intentalo de nuevo. El numero secreto era " + random);
        }
    }
}