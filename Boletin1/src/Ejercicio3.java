import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("¿Cuantos numeros quieres introducir?");
        Scanner sc = new Scanner(System.in);
        int cant = sc.nextInt();
        while (cant == 0 || cant < 0) {
            System.out.println("Introduzca una cantidad valida: ");
            cant = sc.nextInt();
        }
        for (int i = 1; i <= cant; i++) {
            System.out.println("Introduzca su " + i + " numero");
            int num = sc.nextInt();
            if (num % 2 == 0) {
                System.out.println("El numero " + num + " Es par");
            } else
                System.out.println("El numero " + num + " es impar");

        }
    }
}

