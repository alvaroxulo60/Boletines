package ejercicio1;

import utils.MiEntradaSalida;

public class Main {

    public static void main(String[] args) {
        int nuevaLongitud = MiEntradaSalida.leerEnteroPositivo("Introduce la longitud del rectangulo: ", true);
        int nuevoAncho = MiEntradaSalida.leerEnteroPositivo("Introduce el ancho del rectangulo: ", true);
        Rectangulo rectangulo = new Rectangulo(nuevoAncho, nuevaLongitud);
        Rectangulo rectangulo1 = new Rectangulo();
        System.out.println(rectangulo.perimetroRectangulo());
        System.out.println(rectangulo.areaRectangulo());
        System.out.println(rectangulo1.perimetroRectangulo());
        System.out.println(rectangulo1.areaRectangulo());
    }
}
