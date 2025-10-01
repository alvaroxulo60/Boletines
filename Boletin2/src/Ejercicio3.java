public class Ejercicio3 {
    public static void main(String[] args) {
        int num = MiEntradaSalida.leerEntero("Introduce un numero: ");
        int n = num;
        int caracters = 0;
        do {
            n /= 10;
            caracters++;
        }while (Math.abs(n)>0);
        System.out.printf("El %d tiene %d caracteres",num,caracters);
    }
}
