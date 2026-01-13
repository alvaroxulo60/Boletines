package interfaces.Ejercicio2_2;

import exceptions.FormaExceptions;

public class Canvas {

    public Canvas() {
    }

    public void dibujarYAnimarFormas(Forma[] formas){
        for (int i = 0; i < formas.length; i++) {
            if (formas[i] instanceof Dibujable d){
                d.dibujar();
            }
            if (formas[i] instanceof Animable a){
                a.animar();
            }
        }
    }

    public static void main(String[] args) {
        Canvas c =  new Canvas();
        try {
            Forma[] formas = {new Circulo(6), new CirculoMovible(8),
                    new Linea(), new Rectangulo(4, 6)};

            c.dibujarYAnimarFormas(formas);


        } catch (FormaExceptions e) {
            System.out.println(e.getMessage());
        }
    }
}
