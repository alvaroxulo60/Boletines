package domain;

import exceptions.DatoInvalidoException;

public class InstrumentoMusical extends JugueteMadera {

    private int edadMinimaRecomendada;

    public InstrumentoMusical(String nombre, String marca, String origenDeLaMadera, int anoDeTalaDeLaMadera, int edadMinimaRecomendada) throws DatoInvalidoException {
        super(nombre, marca, origenDeLaMadera, anoDeTalaDeLaMadera);
        setEdadMinimaRecomendada(edadMinimaRecomendada);
    }


    public void setEdadMinimaRecomendada(int edadMinimaRecomendada)throws DatoInvalidoException {
        if (edadMinimaRecomendada < 0){
            throw new DatoInvalidoException("La edad minima no es válida");
        }
        this.edadMinimaRecomendada = edadMinimaRecomendada;
    }
}
