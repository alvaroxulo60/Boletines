import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu primer numero: ");
        int n1 = sc.nextInt();
        System.out.println("Introduce tu segundo numero: ");
        int n2 = sc.nextInt();
        int res = 0;
        for (int i = 0; i < Math.abs(n2); i++) {
            res += n1;
        }
        System.out.println("El resultado del producto es: " + res);
    }
}
