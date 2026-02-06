package domain;

import exceptions.DatoInvalidoException;

public abstract class JugueteMadera extends Juguete{

    private String origenDeLaMadera;
    private int anoDeTalaDeLaMadera;

    public JugueteMadera(String nombre, String marca, String origenDeLaMadera, int anoDeTalaDeLaMadera) throws DatoInvalidoException {
        super(nombre, marca);
        this.origenDeLaMadera = origenDeLaMadera;
        setAnoDeTalaDeLaMadera(anoDeTalaDeLaMadera);
    }


    public void setAnoDeTalaDeLaMadera(int anoDeTalaDeLaMadera)throws DatoInvalidoException {
        if (anoDeTalaDeLaMadera < 0){
            throw new DatoInvalidoException("El año de tala no puede ser negativo");
        }
        this.anoDeTalaDeLaMadera = anoDeTalaDeLaMadera;
    }

}
