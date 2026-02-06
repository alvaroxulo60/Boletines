package domain;

import exceptions.DatoInvalidoException;

public class FiguraMadera extends JugueteMadera implements Apilable {

    private String color;
    private int numeroDeCaras;

    public FiguraMadera(String nombre, String marca, String origenDeLaMadera, int anoDeTalaDeLaMadera, String color, int numeroDeCaras) throws DatoInvalidoException {
        super(nombre, marca, origenDeLaMadera, anoDeTalaDeLaMadera);
        this.color = color;
        setNumeroDeCaras(numeroDeCaras);
    }

    public void setNumeroDeCaras(int numeroDeCaras) throws DatoInvalidoException{
        if (numeroDeCaras < 0){
            throw new DatoInvalidoException("Las caras no pueden ser menores que 0");
        }
        this.numeroDeCaras = numeroDeCaras;
    }

    @Override
    public boolean apilar(Juguete j) {
        return this.getClass() == j.getClass();
    }
}
