package domain;

public class FiguraMadera extends Juguete {

    private String origenDeLaMadera;
    private int anoDeTalaDeLaMadera;
    private String color;
    private int numeroDeCaras;

    public FiguraMadera(String nombre, String marca, String origenDeLaMadera, int anoDeTalaDeLaMadera, String color, int numeroDeCaras) {
        super(nombre, marca);
        this.origenDeLaMadera = origenDeLaMadera;
        this.anoDeTalaDeLaMadera = anoDeTalaDeLaMadera;
        this.color = color;
        this.numeroDeCaras = numeroDeCaras;
    }
}
