import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        System.out.println("Introduzca un número positivo: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int fact = 1;
        String texto = "";
        while (num < 0) {
            System.out.println("Eso no es un numero positivo, cateto. Introduce un número positivo.");
            num = sc.nextInt();
        }
        for (int i = 1; i <= num; i++) {
            fact = fact * i;
            if (texto.isEmpty()) {
                texto = texto + (num);
            } else
                texto = texto + "*" + (num - i + 1);
        }
        System.out.printf("El resultado factorial de %d es %d debido a "+texto, num, fact);
    }
}
