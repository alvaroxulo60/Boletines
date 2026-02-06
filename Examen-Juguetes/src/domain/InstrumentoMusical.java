package domain;

public class InstrumentoMusical extends Juguete {

    private String origenDeLaMadera;
    private int anoDeTalaDeLaMadera;
    private int edadMinimaRecomendada;

    public InstrumentoMusical(String nombre, String marca, String origenDeLaMadera, int anoDeTalaDeLaMadera, int edadMinimaRecomendada) {
        super(nombre, marca);
        this.origenDeLaMadera = origenDeLaMadera;
        this.anoDeTalaDeLaMadera = anoDeTalaDeLaMadera;
        this.edadMinimaRecomendada = edadMinimaRecomendada;
    }
}
