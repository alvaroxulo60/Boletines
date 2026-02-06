package domain;

public abstract class Juguete {

    private String nombre;
    private String marca;

    public Juguete(String nombre, String marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }
}
