import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        System.out.println("Introduzca la cantidad de numeros que va a introducir: ");
        Scanner sc = new Scanner(System.in);
        int cant = sc.nextInt();
        int suma = 0;
        for (int i = 1; i <= cant ; i++) {
            System.out.println("Introduce el "+i+"º numero");
            int num = sc.nextInt();
            suma += num;
        }
        System.out.println("La media de esos numeros es "+suma/cant);
    }
}
