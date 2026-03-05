package models;

import exceptions.LigaException;

import java.util.*;
import java.util.stream.Collectors;

public class Liga {
    private String nombre;
    private List<Equipo> equipos;

    public Liga(String nombre) {
        this.nombre = nombre;
        equipos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void addEquipo(Equipo equipo) throws LigaException {
        if (equipo.getJugadores().isEmpty()){
            throw new LigaException("Este equipo no tiene jugadores... ¡No puede participar en la liga! \n");
        }
        if (equipos.contains(equipo)){
            throw new LigaException("¡Este equipo ya esta en la liga! \n");
        }
        else {
            equipos.add(equipo);
        }
    }

    public void removeEquipo(Equipo equipo) throws LigaException {
        if (!equipos.remove(equipo)){
            throw new LigaException("¡Este equipo no se encuentra en la liga! \n");
        }
    }

    public void unifyTeams(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)){
            Set<Jugador> nuevaListaJugadores = new HashSet<>(e1.getJugadores());
            nuevaListaJugadores.addAll(e2.getJugadores());
            e1.setJugadores(nuevaListaJugadores);
        }
        else {
            throw new LigaException("¡Uno de los dos equipos no pertenece a la liga! \n");
        }
    }

    public String mostrarJugadoresEnComunDeDosEquipos(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)){
             return e1.getJugadores().stream()
                    .filter(e2.getJugadores()::contains)
                     .map(Jugador::getNombre)
                     .collect(Collectors.joining(","));

        }
        else {
            throw new LigaException("¡Uno de los dos equipos no pertenece a la liga! \n");
        }
    }

    public Set<Jugador> todosLosJugadores(){
        return equipos.stream().flatMap(e -> e.getJugadores().stream()).collect(Collectors.toSet());
    }

    public double calcularMedia() throws LigaException{
        return todosLosJugadores().stream().mapToDouble(Jugador::getEdad)
                .average().orElseThrow(() -> new LigaException("No se puede calcular la media de los jugadores \n"));
    }

    public List<Jugador> jugadoresOrdenadosPorFechaNacimiento(){
         //return todosLosJugadores().stream().sorted((j1,j2) -> j2.getEdad() - j1.getEdad()).toList();
         return todosLosJugadores().stream().sorted(Comparator.comparing(Jugador::getEdad).reversed()).toList();
    }

    public List<Jugador> jugadoresOrdenadosPorNombre(){
        return todosLosJugadores().stream().sorted().toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e: equipos) {
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString();

    }
}
