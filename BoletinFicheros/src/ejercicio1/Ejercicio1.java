package ejercicio1;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio1 {

    public static void main(String[] args) {

        File f = new File("./src/ejercicio1/leeme.txt");


        try (FileReader fr = new FileReader(f)){
            BufferedReader br = new BufferedReader(fr);
            int contador = 0;

            System.out.println(br.lines().count());

            while ( br.readLine() != null){
                contador++;
            }

            System.out.println(contador);

            Path fichero = Path.of("./src/ejercicio1/leeme.txt");

            System.out.println(Files.lines(fichero).count());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
