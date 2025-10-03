public class Ejercicio5 {
    public static void main(String[] args) {
        int n1 = MiEntradaSalida.leerEnteroPositivo("Introduce tu numero: ", false);
        int divisores = 0;
        boolean esPrimo = true;
        for (int i = 2; i <= n1/2&& esPrimo; i++) {
            if (n1 % i == 0) {
                divisores++;
            }
        }
        if (divisores ==0){
            System.out.printf("El numero %d es primo",n1);
        }
        else
            System.out.printf("El numero %d no es primo",n1);
    }
}
