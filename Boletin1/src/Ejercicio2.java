import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("Introduce un numero: ");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        while (n1 < 0 || n1 > 10) {
            System.out.println("Introduce un numero entre el 0 y el 10");
            n1 = sc.nextInt();
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(n1 + "*" + i + "=" + n1 * i);
        }


    }
}