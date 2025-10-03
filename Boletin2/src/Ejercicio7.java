public class Ejercicio7 {
    public static void main(String[] args) {
        int n1 = MiEntradaSalida.leerEnteroPositivo("Introduce el primer número: ",false);
        int n2 = MiEntradaSalida.leerEnteroPositivo("Introduce tu segundo número: ", false);
        System.out.println("El m.c.d de "+ n1+ " y "+n2+" es "+ MiEntradaSalida.mcd(n1,n2));
    }
}
