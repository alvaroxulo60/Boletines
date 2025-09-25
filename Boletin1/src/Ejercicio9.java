import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        System.out.println("Introduce un número positivo: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int total = 0;
        while (num < 0) {
            System.out.println("Eso no es un numero positivo, cateto. Introduce un número positivo.");
            num = sc.nextInt();
        }
        for (int i = 1; i < num; i++) {
            if (num % i == 0 && i <= (num / 2)) {
                total += i;
            }
        }
        if (num == total) {
            System.out.println("El numero " + num + " es un numero perfecto");
        }
        else
            System.out.printf("El numero %d no es un numero perfecto", num);
    }
}
