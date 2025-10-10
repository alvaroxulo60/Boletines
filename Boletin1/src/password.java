import java.util.Scanner;

public class password {
    public static void main(String[] args) {
        String contra = "Alvaro";
        String intento;
        Scanner sc = new Scanner(System.in);
        int errores = 0;
        do {
            System.out.println("Introduce la contraseña: ");
            intento = sc.next();
            errores++;
            if (errores == 3) {
                System.out.println("Pista: Alumno favorito de Bermudo.");
            }
        } while (!contra.equals(intento));
        System.out.println("Has adivinado la contraseña, felicidades");
    }
}
