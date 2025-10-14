public class Ejercicio6 {
    public static void main(String[] args) {
        int size = MiEntradaSalida.generaAleatorio(10);
        int[] numeros = new int[size];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i]=MiEntradaSalida.generaAleatorio(10);
        }
        int consulta = MiEntradaSalida.leerEntero("Introduzca el numero que desa conocer si esta en la lista: ");
        for (int n1 : numeros){
            if (n1 == consulta){
                System.out.printf("El numero %d si esta en la lista", consulta);
            }
            else
                System.out.println("No esta en la lista :(");
        }
    }
}
