package ejercicio3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;



public class Ejercicio3 {
    public static void main(String[] args) {

        Path rutaFicheroSalida = Path.of("src","ejercicio3", "SalidaEj3.txt");

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            String linea;
            while ((linea = bf.readLine()) != null && !linea.equalsIgnoreCase("fin")) {


                Files.writeString(rutaFicheroSalida,linea + System.lineSeparator(),StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
