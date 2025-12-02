package boletin4_2.ejercicio6;

import exceptions.ProductoExceptions;

public class Producto {
    private String nombre;
    private static int contador=1;
    private int codigo;
    private String descripcion;
    private double precioSinIVA;
    public static double IVA = 0.2;

    public Producto(String nombre, String descripcion, double precioSinIVA) throws ProductoExceptions {
        this.codigo = contador++;
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecioSinIVA(precioSinIVA);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioSinIVA() {
        return precioSinIVA;
    }

    public void setPrecioSinIVA(double precioSinIVA) throws ProductoExceptions{
        if (precioSinIVA < 0){
            throw new ProductoExceptions("Error: El precio no puede ser menor que 0");
        }
        this.precioSinIVA = precioSinIVA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double IVA) {
        Producto.IVA = IVA;
    }

    public double precioConIVA(){
        double total;
        total=(getPrecioSinIVA()*IVA)+getPrecioSinIVA();
        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Producto{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", codigo=").append(codigo);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", precioSinIVA=").append(precioSinIVA);
        sb.append('}');
        return sb.toString();
    }
}
