import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        int num1 = 0;
        int total = 0;
        while (num1 >= 0) {
            System.out.println("Introduce un numero (Negativo para finalizar): ");
            Scanner sc = new Scanner(System.in);
            num1 = sc.nextInt();
            total++;
        }
        total -= 1;
        System.out.println("Has introducido " + total + " numeros positivos");
    }
}
