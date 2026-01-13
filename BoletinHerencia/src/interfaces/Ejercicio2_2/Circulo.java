package interfaces.Ejercicio2_2;

import exceptions.FormaExceptions;

public class Circulo extends Forma implements Dibujable{
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public void setRadio(double radio) throws FormaExceptions {
        if (radio <= 0){
            throw new FormaExceptions("El valor del radio no es valido");
        }
        this.radio = radio;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando circulo...");
    }

    @Override
    double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}
