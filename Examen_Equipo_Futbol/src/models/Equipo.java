package models;

import exceptions.LigaException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Equipo {

    private String nombre;

    private Set<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        jugadores = new HashSet<>();
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void addJugador(Jugador jugador) throws LigaException {
        if (!jugadores.add(jugador)){
            throw new LigaException("¡Este jugador ya pertenece a este equipo! \n");
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Equipo equipo)) return false;

        return nombre.equals(equipo.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nombre = '").append(nombre).append('\n');
        sb.append("jugadores = ");

        sb.append(jugadores.stream().map(Jugador::toString).collect(Collectors.joining(",")));
        return sb.toString();
    }
}
