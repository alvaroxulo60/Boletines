package interfaces.Ejercicio2_2;

import exceptions.FormaExceptions;

public class Rectangulo extends Forma implements Dibujable{
    private double base;
    private double altura;

    public Rectangulo(double base, double altura)throws FormaExceptions {
        setBase(base);
        setAltura(altura);
    }

    public void setBase(double base)throws FormaExceptions {
        if (base <= 0){
            throw new FormaExceptions("Ese valor de base no es correcto.");
        }
        this.base = base;
    }

    public void setAltura(double altura)throws FormaExceptions {
        if (altura <= 0){
            throw new FormaExceptions("Ese valor de altura no es correcto.");
        }
        this.altura = altura;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando rectángulo...");
    }

    @Override
    double calcularArea() {
        return base*altura;
    }
}
