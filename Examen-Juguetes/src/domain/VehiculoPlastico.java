package domain;

import exceptions.DatoInvalidoException;

public class VehiculoPlastico extends JuguetePlastico {

    private int numeroDeRuedas;

    public VehiculoPlastico(String nombre, String marca, int numeroDeRuedas)throws DatoInvalidoException {
        super(nombre, marca, TipoDePlastico.PVC);
        setNumeroDeRuedas(numeroDeRuedas);
    }

    public void setNumeroDeRuedas(int numeroDeRuedas) throws DatoInvalidoException {
        if (numeroDeRuedas < 0){
            throw new DatoInvalidoException("Ese número de ruedas no es válido");
        }
        this.numeroDeRuedas = numeroDeRuedas;
    }
}
