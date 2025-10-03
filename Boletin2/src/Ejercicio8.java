public class Ejercicio8 {
    public static void main(String[] args) {
        double a = MiEntradaSalida.leerEntero("Introduce tu primer numero: ");
        double b = MiEntradaSalida.leerEntero("Introduce tu segundo numero: ");
        double c = MiEntradaSalida.leerEntero("Introduce tu segundo numero: ");
        System.out.println("Esta ecuacion tiene "+MiEntradaSalida.ecuacionSegundoGrado(a,b,c, true)+" soluciones");
    }
}
