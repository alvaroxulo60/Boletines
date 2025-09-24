import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("Introduzca un numero positivo: ");
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int n1 = sc.nextInt();
        while (n1 < 0) {
            System.out.println("Eso no es un numero positivo, imbecil. Introduce uno correcto:");
            n1 = sc.nextInt();
        }
        for (int i = 0; i <= n1; i++) {
            res += i;
        }
        System.out.println("La suma de los " + n1 + " primeros numeros es: " + res);
    }
}
