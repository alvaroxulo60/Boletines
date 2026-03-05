package models;

import java.time.LocalDate;
import java.time.Period;

public class Jugador implements Comparable<Jugador> {
    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;
    private TDemarcacion demarcacion;
    private String paisNacimiento;

    public Jugador(String nombre, TDemarcacion demarcacion,LocalDate fechaNacimiento, String paisNacimiento) {
        assert nombre != null;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.demarcacion = demarcacion;
        this.paisNacimiento = paisNacimiento;
        calcularEdad();
    }

    public String getNombre() {
        return nombre;
    }

    private void calcularEdad(){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento,
                fechaActual);
        edad = periodo.getYears();

    }

    public int getEdad() {
        return edad;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Jugador jugador)) return false;

        return nombre.equals(jugador.nombre) && fechaNacimiento.equals(jugador.fechaNacimiento);
    }


    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + fechaNacimiento.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(": ").append(fechaNacimiento).append(". ")
                .append(demarcacion).append(" (").append(paisNacimiento)
                .append(") ").append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public int compareTo(Jugador o) {
        return this.nombre.compareTo(o.nombre);
    }
}
