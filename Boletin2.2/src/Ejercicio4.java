public class Ejercicio4 {
    public static void main(String[] args) {

        int hora = MiEntradaSalida.leerEnteroPositivo("Introdcuce tu hora: ", true);
        int minutos = MiEntradaSalida.leerEnteroPositivo("Introdcuce tus minutos: ", true);
        int segundos = MiEntradaSalida.leerEnteroPositivo("Introdcuce tus segundos: ", true);


        int sumaHoras = MiEntradaSalida.leerEnteroPositivo("¿Cuantas horas quieres sumar? ", true);
        int sumaMinutos = MiEntradaSalida.leerEnteroPositivo("¿Cuantos minutos quieres sumar? ", true);
        int sumaSegundos = MiEntradaSalida.leerEnteroPositivo("¿Cuantos segundos quieres sumar? ", true);


        segundos += sumaSegundos;
        minutos += segundos / 60;
        segundos = segundos % 60;


        minutos += sumaMinutos;
        hora += minutos / 60;
        minutos = minutos % 60;


        hora += sumaHoras;
        int dias = 0;
        boolean cambioDia = false;
        if (hora >= 24) {
            dias = hora / 24;
            hora = hora % 24;
            cambioDia = true;
        }


        System.out.printf("La hora resultante es: %02d:%02d:%02d", hora, minutos, segundos);
        if (cambioDia) {
            System.out.printf(" y han pasado %d Días", dias);
        }
        System.out.println();
    }
}

