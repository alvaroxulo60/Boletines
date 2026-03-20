package ejercicio5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Menu {
    public static void main(String[] args) {

    }

    public static void crearDirectorio(String nombreDelDirectorio) {
        Path directorio = Path.of("src", "ejercicio5", nombreDelDirectorio);

        try {
            Files.createDirectories(directorio);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void crearFicheroDeTexto(String nombreDelFichero){
        Path ruta = Path.of("src", "ejercicio5", nombreDelFichero);
    }
}
