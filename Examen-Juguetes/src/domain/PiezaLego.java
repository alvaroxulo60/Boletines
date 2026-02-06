package domain;

import exceptions.DatoInvalidoException;

public class PiezaLego extends JuguetePlastico implements Apilable{

    private int unidadesDeLongitud;
    private String color;


    public PiezaLego(String nombre, String marca, int unidadesDeLongitud, String color)throws DatoInvalidoException {
        super(nombre, marca, TipoDePlastico.ABS);
        setUnidadesDeLongitud(unidadesDeLongitud);
        this.color = color;
    }

    public void setUnidadesDeLongitud(int unidadesDeLongitud)throws DatoInvalidoException {
        if (unidadesDeLongitud < 0){
            throw new DatoInvalidoException("Esas unidades no son validas");
        }
        this.unidadesDeLongitud = unidadesDeLongitud;
    }

    @Override
    public boolean apilar(Juguete j) {
        return this.getClass() == j.getClass();
    }
}
