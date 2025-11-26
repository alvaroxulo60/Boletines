package boletin4_2.Ejercicio5;

public class Linea {
    private Punto puntoA;
    private Punto puntoB;

    public Linea() {
        this.puntoA = new Punto(0, 0);
        this.puntoB = new Punto(0, 0);
    }

    public Linea(Punto puntoA, Punto puntoB) {
        setPuntoA(puntoA);
        setPuntoB(puntoB);
    }

    public Punto getPuntoA() {
        return puntoA;
    }

    public void setPuntoA(Punto puntoA) {
        this.puntoA = puntoA;
    }

    public Punto getPuntoB() {
        return puntoB;
    }

    public void setPuntoB(Punto puntoB) {
        this.puntoB = puntoB;
    }

    public boolean sonIguales(Linea linea1, Linea linea2){
        return linea1.equals(linea2);
    }

    public void moverDerecha(double distancia){
        puntoA.setCordenadaX(puntoA.getCordenadaX()+distancia);
        puntoB.setCordenadaX(puntoB.getCordenadaX()+distancia);
    }
    public void moverIzquierda(double distancia){
        puntoA.setCordenadaX(puntoA.getCordenadaX()-distancia);
        puntoB.setCordenadaX(puntoB.getCordenadaX()-distancia);
    }


}
