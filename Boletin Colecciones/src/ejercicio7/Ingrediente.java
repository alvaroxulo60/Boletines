package ejercicio7;

public class Ingrediente {

    private String nombre;
    private int cantidad;

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Ingrediente that)) return false;

        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
