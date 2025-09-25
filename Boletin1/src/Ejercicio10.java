import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        System.out.println("Introduzca un número positivo");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int fact = 1;
        while (num < 0){
            System.out.println("Eso no es un numero positivo, cateto. Introduce un número positivo.");
            num = sc.nextInt();
        }
        for (int i = 1; i <= num ; i++) {
            fact = fact * i;
        }
        System.out.printf("El resultado factorial de %d es %d", num,fact);
    }
}
