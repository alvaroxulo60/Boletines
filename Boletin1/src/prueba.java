import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
        System.out.println("Introduzca un numero: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int divisor = 2;
        while (num % divisor !=0 && divisor <= (num/2)){
            divisor++;
        }
        if(num % divisor ==0) {
            System.out.println("El primer divisor de " + num + " es " + divisor);
        }
        else
            System.out.printf("El numero %d es primo", num);
    }
}
