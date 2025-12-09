package examenes;

import exceptions.PeliculaException;

public class Pelicula {
    private String titulo;
    private int añoEstreno;
    private String director;
    private double presupuesto;
    private double recaudacion;
    private String sipnosis;
    private String etiquetas;
    private double valoracion;

    public Pelicula(String titulo, int añoEstreno, String director, double presupuesto, double recaudacion, String sipnosis, String etiquetas) throws PeliculaException{
        this.titulo = titulo;
       setAñoEstreno(añoEstreno);
        this.director = director;
        setPresupuesto(presupuesto);
        setRecaudacion(recaudacion);
        this.sipnosis = sipnosis;
        this.etiquetas = etiquetas;
        this.valoracion = calcularValoracion();
    }

    private void setAñoEstreno(int añoEstreno) throws PeliculaException {
        if (añoEstreno<0){
            throw new PeliculaException("El año no puede ser negativo");
        }
        this.añoEstreno = añoEstreno;
    }

    private void setPresupuesto(double presupuesto) throws PeliculaException {
        if (presupuesto<0){
            throw new PeliculaException("El presupuesto no puede ser negativo");
        }
        this.presupuesto = presupuesto;
    }

    private void setRecaudacion(double recaudacion) throws PeliculaException {
        if (recaudacion<0){
            throw new PeliculaException("La recaudacion no puede ser negativo");
        }
        this.recaudacion = recaudacion;
    }

    public double calcularValoracion() {
        double valoracion = (recaudacion*5)/presupuesto;

        if (valoracion>10.0){
            return 10.0;
        }
        return valoracion;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", añoEstreno=" + añoEstreno +
                ", director='" + director + '\'' +
                ", presupuesto=" + presupuesto +
                ", recaudacion=" + recaudacion +
                ", sipnosis='" + sipnosis + '\'' +
                ", etiquetas='" + etiquetas + '\'' +
                ", valoracion=" + valoracion +
                '}';
    }
}
