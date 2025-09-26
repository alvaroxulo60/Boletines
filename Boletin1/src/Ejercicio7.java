import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {

        System.out.println("Introduzca la cantidad de números que va a introducir: ");
        Scanner sc = new Scanner(System.in);
        int cant = sc.nextInt();
        double suma = 0;
        while (cant<=0){
            System.out.println("Esa cantidad no es valida. Introduce una nueva: ");
            cant = sc.nextInt();
        }
        for (int i = 1; i <= cant; i++) {
            System.out.println("Introduce el " + i + "º número");
            int num = sc.nextInt();
            suma += num;
        }
        double media = suma / cant;
        System.out.println("La media de esos números es " + media);
    }
}
