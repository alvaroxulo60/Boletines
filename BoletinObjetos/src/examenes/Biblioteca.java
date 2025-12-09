package examenes;

import exceptions.PeliculaException;

import java.util.Arrays;

public class Biblioteca {
    public final static int TAMAÑO = 20;

    private Pelicula[] peliculas = new Pelicula[TAMAÑO];

    public Biblioteca() {
    }

    public void añadirPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] == null) {
                peliculas[i] = pelicula;
                return;
            }
        }
    }

    public String buscarPeliculaPorEtiquetas(String etiqueta) throws PeliculaException {
        StringBuilder devolver = new StringBuilder();
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                String[] etiquetas = peliculas[i].getEtiquetas().split(",");
                for (int j = 0; j < etiquetas.length; j++) {
                    if (etiquetas[j].equalsIgnoreCase(etiqueta)) {
                        devolver.append(peliculas[i].getTitulo());
                    }
                }
            }
            else if (peliculas[i] == null) {
                break;
            }
        }
        if (devolver.toString().isEmpty()) {
            throw new PeliculaException("No hay ninguna película con esa etiqueta");
        }
        return devolver.toString();
    }

    public String buscarPeliculaPorTitulo(String titulo)throws PeliculaException {
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (titulo.equalsIgnoreCase(peliculas[i].getTitulo())) {
                    return peliculas[i].toString();
                }
            }else if (peliculas[i] == null) {
                break;
            }
        }
        throw new PeliculaException("Esa película no esta en la biblioteca");
    }

    public String buscarPeliculaPorPresupuestoMaximo(double presupuestoMaximo) throws PeliculaException {
        StringBuilder devolver = new StringBuilder();
        for (int i = 0; i < peliculas.length; i++) {
            if (peliculas[i] != null) {
                if (peliculas[i].getPresupuesto() <= presupuestoMaximo) {
                    devolver.append(peliculas[i].getTitulo());
                }
            }
            else if (peliculas[i] == null) {
                break;
            }
        }
        if (devolver.toString().isEmpty()) {
            throw new PeliculaException("No hay ninguna pelicula con ese presupuesto máximo");
        }
        return devolver.toString();
    }

    public String mostrarBiblioteca(){
        StringBuilder devolver = new StringBuilder();
        for (Pelicula pelicula : peliculas) {
            if (pelicula != null) {
                devolver.append(pelicula.toString());
            }
            if (pelicula == null) {
                break;
            }
        }
        return devolver.toString();
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "peliculas=" + Arrays.toString(peliculas) +
                '}';
    }
}
