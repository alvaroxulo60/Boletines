public class Ejercicio6 {
    public static void main(String[] args) {
        int alumnos = MiEntradaSalida.leerEnteroPositivo("Introduce el numero de alumnos: ", false);
        double nota;
        int aprobados = 0;
        int suspensos = 0;
        for (int i = 1; i <= alumnos; i++) {
            nota = MiEntradaSalida.leerDecimal("Introduce la nota del examen del " + i + "º alumno: ");
            if (nota >= 5) {
                aprobados++;
            } else
                suspensos++;
        }
        System.out.println("El numero de aprobados es " + aprobados + " y el porcentaje es " + (int) ((aprobados / (double) alumnos) * 100) + "%");
        System.out.println("El numero de suspensos es " + suspensos + " y el porcentaje es " + (int) ((suspensos / (double) alumnos) * 100) + "%");
    }
}