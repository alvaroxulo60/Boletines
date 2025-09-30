import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero mostrando el mensaje pasado como parámetro
     *
     * @param mensaje El mensaje a mostrar
     * @return el entero leído por teclado
     */
    public static int leerEntero(String mensaje) {
        System.out.print("Introduce un número: ");
        return sc.nextInt();
    }

    public static int leerEnteroPositivo(String mensaje) {
        int a;
        do {
            System.out.println("Introduce un número positivo: ");
            a = sc.nextInt();
            if (a<=0){
                System.out.println("Numero no válido.");
            }
        } while (a < 0);
        return a;
    }

    public static void main(String[] args) {
        int a = MiEntradaSalida.leerEnteroPositivo("Introduce tu numero: ");
        System.out.printf("El numero introducido es %d", a);
    }
}
