import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        int menor = Integer.MAX_VALUE;
        int num;
        String res;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Introduce un numero: ");
            num = sc.nextInt();
            if (num < menor) {
                menor = num;
            }
            do {
                System.out.println("¿Quieres introducir otro numero? (S/N)");
                res = sc.next();
            } while (!res.equalsIgnoreCase("S") && !res.equalsIgnoreCase("N"));
        } while (res.equalsIgnoreCase("s"));
        if (res.equalsIgnoreCase("N")) {
            System.out.printf("El numero mas pequeño introducido es %d", menor);
        }
    }
}
