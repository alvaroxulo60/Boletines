package ejercicioAvión;

import java.time.LocalDate;
import java.time.Period;

public class Revision {
    private LocalDate fecha;
    private boolean estado;
    private Period periodoValidez;

    public Revision(LocalDate fecha, boolean estado, Period periodoValidez) {
        this.fecha = fecha;
        this.estado = estado;
        this.periodoValidez = periodoValidez;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "estado=" + estado +
                '}';
    }

    public boolean isEstado() {
        return estado;
    }

    public Period getPeriodoValidez() {
        return periodoValidez;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
