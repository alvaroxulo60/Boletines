import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        System.out.println("Introduce tu primer numero: ");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int res = 0;
        System.out.println("Introduce tu segundo numero: ");
        int n2 = sc.nextInt();
        for (int i = 0; i <n2 ; i++) {
            res +=n1;
        }
        System.out.println("El resultado del producto es: "+res);
    }
}
