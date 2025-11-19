package boletin4_2.ejercicio1;

import java.time.LocalDate;

public class Main {
    public static void main() {
        Persona persona1 = new Persona("Álvaro", LocalDate.of(2007,3,9),12345678,'M', 1.75F,80F);

        System.out.print(persona1.toString());
    }
}
