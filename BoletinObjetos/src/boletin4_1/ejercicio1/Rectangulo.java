package boletin4_1.ejercicio1;

public class Rectangulo {
    private int longitud;
    private int ancho;

    public Rectangulo() {
        longitud=1;
        ancho=1;

    }
    public Rectangulo(int ancho,int longitud){
        setAncho(ancho);
        setLongitud(longitud);
    }

    public void setAncho(int ancho) {
        if (ancho < 20 && ancho > 0) {
            this.ancho=ancho;
        }
    }

    public void setLongitud(int longitud){
        if (longitud < 20 && longitud > 0){
            this.longitud=longitud;
        }
    }

    public int getLongitud() {
        return longitud;
    }

    public int getAncho() {
        return ancho;
    }

    public int areaRectangulo() {
        return longitud * ancho;
    }

    public int perimetroRectangulo(){
        return 2*(ancho+longitud);
    }
}
