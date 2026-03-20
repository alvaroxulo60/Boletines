package ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio2 {

    public static void main(String[] args) {

        Path fichero = Path.of("./src/ejercicio1/leeme.txt");

        try (Stream<String> lines = Files.lines(fichero)) {
            System.out.println(lines.collect(Collectors.joining(" ")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
