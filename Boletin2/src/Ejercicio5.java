public class Ejercicio5 {
    public static void main(String[] args) {
        int n1 = MiEntradaSalida.leerEnteroPositivo("Introduce tu numero: ", false);
        int divisores = 0;
        for (int i = 1; i <= n1; i++) {
            if (n1 % i == 0) {
                divisores++;
            }
        }
        if (divisores ==2 && n1 != 2){
            System.out.printf("El numero %d es primo",n1);
        }
        if (n1 == 2){
            System.out.println("El numero 2 no es primo");
        }
        else
            System.out.printf("El numero %d no es primo",n1);
    }
}
