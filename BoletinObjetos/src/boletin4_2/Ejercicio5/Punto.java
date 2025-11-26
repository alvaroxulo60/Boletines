package boletin4_2.Ejercicio5;

public class Punto {
    private double cordenadaX;
    private double cordenadaY;


    public Punto(double cordenadaX, double cordenadaY) {
        setCordenadaX(cordenadaX);
        setCordenadaY(cordenadaY);
    }

    public double getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(double cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public double getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaY(double cordenadaY) {
        this.cordenadaY = cordenadaY;
    }
}
