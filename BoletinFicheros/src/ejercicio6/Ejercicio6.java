package ejercicio6;

import io.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


public class Ejercicio6 {
    static void main(String[] args) {
        String nombreDirectorio = MiEntradaSalida.leerLinea("Introduce el nombre del directorio: ");
        Path rutaAlDirectorio = Path.of(nombreDirectorio);
        if (Files.exists(rutaAlDirectorio)){
            if (Files.isDirectory(rutaAlDirectorio)){
                System.out.println();
                try (Stream<Path> lista = Files.list(rutaAlDirectorio)) {
                    lista.forEach(p -> {
                        if (Files.isDirectory(p)) {
                            System.out.printf("%s - Directorio %n", p.getFileName());
                        } else {
                            try {
                                System.out.printf("%s %.2f KB %n", p.getFileName(), Files.size(p) / 1024.0);
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    });
                }catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        }else {
            System.out.println("No existe la ruta friki");
        }
    }
}
