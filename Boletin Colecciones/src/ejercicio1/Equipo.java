package ejercicio1;

import exceptions.AlumnoException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo {

    private Set<Alumno> alumnos;
    private String nombre;

    public Equipo(String nombre) {
        alumnos = new HashSet<>();
        this.nombre = nombre;
    }

    public Equipo(Set<Alumno> lista, String nombre) {
        this.alumnos = lista;
        this.nombre = nombre;
    }

    public void addAlumno(Alumno a) throws AlumnoException{
        if (!alumnos.add(a)) {
            throw new AlumnoException("Ese alumno ya esta en el equipo");
        }

    }

    public void removeAlumno(Alumno a) throws AlumnoException{
        if (!alumnos.remove(a)){
            throw new AlumnoException("Ese alumno no esta en el equipo");
        }
    }

    public Alumno containsAlumno(Alumno a){
        if (alumnos.contains(a)){
            return a;
        }
        return null;
    }

    public List<Alumno> devolverListaAlumnos(){
        return new ArrayList<>(alumnos);
    }

    public Equipo interseccionEquipos(String nombreEquipo, Equipo equipo2){
        Set<Alumno> nuevaLista = new HashSet<>(alumnos);
        nuevaLista.retainAll(equipo2.alumnos);
        return new Equipo(nuevaLista,nombreEquipo);
    }

    public Equipo unifyEquipos(String nombreEquipo, Equipo equipo2){
        Set<Alumno> nuevoAlumnos = new HashSet<>();
        nuevoAlumnos.addAll(alumnos);
        nuevoAlumnos.addAll(equipo2.alumnos);

        return new Equipo(nuevoAlumnos,nombreEquipo);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "alumnos=" + alumnos +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Alumno a1 = new Alumno("Jorge","1");
        Alumno a2 = new Alumno("Jorge", "2");
        Alumno a3 = new Alumno("Moi","3");

        Equipo e1 = new Equipo("lolo");
        Equipo e2 = new Equipo("bla bla bla");

        try {
            e1.addAlumno(a1);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e1.addAlumno(a3);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e1.addAlumno(a1);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e2.addAlumno(a2);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e2.addAlumno(a3);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e2.addAlumno(a2);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        Equipo nuevo = e1.unifyEquipos("lobla",e2);
        Equipo nuevo2 = e1.interseccionEquipos("blalo", e2);

        System.out.println(e1.devolverListaAlumnos());
        System.out.println(e2.devolverListaAlumnos());
        System.out.println(nuevo.devolverListaAlumnos());
        System.out.println(nuevo2.devolverListaAlumnos());
    }

}
