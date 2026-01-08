package ejercicio3;

public class Hechizo {
    private final String nombre;

    public Hechizo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Hechizo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

}
