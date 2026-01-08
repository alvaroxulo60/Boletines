package ejercicio2;

import exceptions.VehiculoException;

public class Coche extends Vehiculo{

    public Coche(String gama, String matricula, String combustible) throws VehiculoException {
        super(gama, matricula, combustible);
    }

    @Override
    public String toString() {
        return "Coche{" +
                super.toString()+"}";
    }
}
