package ejercicio11;

import exceptions.Ejercicio11Exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    static void main(String[] args) {

    }

    public static void crearDirectorios() throws Ejercicio11Exception {

        Pattern patron = Pattern.compile("^(?<nombre>\\p{Lu}\\p{Lu}+)\\s(?<apellido1>\\p{Lu}\\p{Lu}+)\\s(?<apellido2>\\p{Lu}\\p{Lu}+)\\s(?<curso>[1-6]º[A-Z]+)$");

        Path rutaSalida = Path.of("src/ejercicio11/salida");
        Path rutaArchivoContenido = Path.of("src/ejercicio11/Nombres.txt");

        if (Files.notExists(rutaArchivoContenido) || !Files.isRegularFile(rutaArchivoContenido) || !Files.isReadable(rutaArchivoContenido)){
            throw new Ejercicio11Exception("Moisés friki galaxy, la película (No es posible acceder al archivo, o no es un archivo de texto o no se puede leer)");
        }

        boolean todasLasLineasCumplenElFormato = false;

        try(Stream<String> lineas = Files.lines(rutaArchivoContenido)){
            todasLasLineasCumplenElFormato = lineas.allMatch(l -> l.matches(patron.pattern()));
        }catch (IOException e){
            System.out.printf("%s \n",e.getMessage());
        }

        if (!todasLasLineasCumplenElFormato){
           throw new Ejercicio11Exception("El archivo no cumple el patrón");
        }

        try(Stream<String> lineas = Files.lines(rutaArchivoContenido)){
            lineas.map(patron::matcher)
                    .filter(Matcher::find)
                    .forEach();
        }catch (IOException e){
            System.out.printf("%s \n",e.getMessage());
        }

    }


}
