import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("¿Cuantos numeros quieres introducir?");
        Scanner sc = new Scanner(System.in);
        int cant = 0;
        cant = sc.nextInt();
        while (cant == 0 || cant<0 ){
        System.out.println("Introduzca una cantidad valida: ");
        cant = sc.nextInt();
        }
    }
}
