package ejercicio8;

import io.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Comprobador {
    public static void main(String[] args) {
        String rutaAlArchivo = MiEntradaSalida.leerLinea("Introduce la ruta del archivo: ");

        Path ruta = Path.of(rutaAlArchivo);

        if (Files.isRegularFile(ruta)) {
           try(Stream<String> lineas = Files.lines(ruta)){
               boolean cumple = lineas.allMatch(l -> l.trim().matches("(\\p{L}{2,}\\s){3}([1-9]|([1-9][0-9]))$"));
               if (cumple){
                   System.out.println("Todas las lineas del archivo cumplen con el patron");
               }else {
                   System.out.println("No lo cumple");
               }
           }catch (IOException e){
               System.out.println(e.getMessage());
           }
        } else {
            System.out.println("La ruta no es un archivo válido o es un directorio.");
        }
    }
}
