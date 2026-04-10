package ejercicio3;

import com.google.gson.annotations.Expose;

public class Direccion {
    @Expose
    private String calle;
    @Expose
    private String ciudad;
    @Expose
    private int codigoPostal;

    public Direccion(String calle, String ciudad, int codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Dirección{" + "calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", códigoPostal=" + codigoPostal +
                '}';
    }
}
