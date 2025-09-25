import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        System.out.println("Introduce un numero:");
        Scanner sc = new Scanner(System.in);
        int menor = sc.nextInt();
        System.out.println("¿Desea introducir otro numero?(S/N)");
        String res = sc.next();
        if (res.equalsIgnoreCase("S")) {
            while (res.equalsIgnoreCase("S")) {
                System.out.println("Introduce un nuevo numero:");
                int nuevo = sc.nextInt();
                if (nuevo < menor) {
                    menor = nuevo;
                }
                System.out.println("¿Desea introducir otro numero?(S/N)");
                res = sc.next();
            }
            System.out.println("El numero mas pequeño es " + menor);
        } else
            System.out.println("No es una respuesta valida");

    }
}
