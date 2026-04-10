package ejercicio3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Direccion direccion = new Direccion("Calle falsa 123", "Las bahamas", 12345);
        Direccion direccion2 = new Direccion("Calle falsa 1876", "Las bahamas", 12345);


        Usuario usuario = new Usuario("Goku", "Goku123", "Goku@genkidama.com", List.of(direccion,direccion2));

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        String json = gson.toJson(usuario);

        Path path = Path.of("src/main/java/ejercicio3/usuario.json");



        try {
            Files.writeString(path,json, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Usuario u1 = gson.fromJson(Files.newBufferedReader(path), Usuario.class);

            System.out.println(u1.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
