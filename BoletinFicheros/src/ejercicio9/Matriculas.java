package ejercicio9;

import io.MiEntradaSalida;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class Matriculas {
    public static void main(String[] args) {
        String rutaAlFichero = MiEntradaSalida.leerLinea("Introduce la ruta al archivo: ");

        Path ruta = Path.of(rutaAlFichero);
        Path rutaSalida = Path.of("src/ejercicio9/MatriculasCorrectas.txt");

        try (Stream<String> lineas = Files.lines(ruta)){

            lineas.filter(l -> l.matches("(\\p{L}+)\\s(\\d{4}-[B-Z&&[^EIOU]]{3})")).forEach(l -> {
                try {
                    Files.writeString(rutaSalida, l + System.lineSeparator() , StandardOpenOption.APPEND,
                            StandardOpenOption.CREATE);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

            System.out.println("Matriculas Correctas Escritas");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
