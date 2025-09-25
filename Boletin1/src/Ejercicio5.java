import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.println("Introduce un numero (Negativo para finalizar): ");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int total = 0;
        while (num1 >= 0) {
            System.out.println("Introduce un numero (Negativo para finalizar): ");
            num1 = sc.nextInt();
            total++;
        }
        System.out.println("Has introducido " + total + " numeros positivos");
    }
}
