package interfaces.Ejercicio2_2;

public class CirculoMovible extends Circulo implements Dibujable, Animable {

    public CirculoMovible(double radio) {
        super(radio);
    }

    @Override
    public void animar() {
        System.out.println("Animando Circulo movible...");
    }

    @Override
    public void dibujar(){
        System.out.println("Dibujando Circulo movible...");
    }


}
