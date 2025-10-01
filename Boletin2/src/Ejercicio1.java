import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 3 numeros: ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        if (n1 < n2 && n2 < n3) {
            System.out.println(n1 + " < " + n2 + " < " + n3);
        }
         else if (n1 < n3 && n3 < n2) {
            System.out.println(n1 + " < " + n3 + " < " + n2);
        }
        else if (n2 < n1 && n1 < n3) {
            System.out.println(n2 + " < " + n1 + " < " + n3);
        }
        else if (n2 < n3 && n3 < n1) {
            System.out.println(n2 + " < " + n3 + " < " + n1);
        }
        else if (n3 < n2 && n2 < n1) {
            System.out.println(n3 + " < " + n2 + " < " + n1);
        }
        else
            System.out.println(n3 + " < " + n1 + " < " + n2);
    }
}
