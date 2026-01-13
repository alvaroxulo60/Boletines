package interfaces.Ejercicio2_2;

import exceptions.FormaExceptions;

public class Linea extends Forma {

    @Override
    double calcularArea() throws FormaExceptions {
        throw new FormaExceptions("Esta forma no puede calcular su area");
    }
}
