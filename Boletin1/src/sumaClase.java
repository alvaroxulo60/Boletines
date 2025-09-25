public class sumaClase {
    public static void main(String[] args) {
        int suma = 0;
        for (int i = 1; i < 101; i+=2) {
            suma += i;
        }
        System.out.println("La suma de los cien primeros numeros es " + suma);
    }
}