public class Ejercicio2 {
    public static void main(String[] args) {
        int num = MiEntradaSalida.leerEnteroPositivo("Introduce un número: ", true);
        int original = num;
        int invertido = 0, resto;
        while (num > 0) {
            resto = num % 10;
            invertido = invertido * 10 + resto;
            num /= 10;
        }
        if (invertido == original) {
            System.out.println("Es un numero capicúa");
        } else
            System.out.println("Vete al carajo");
    }
}
