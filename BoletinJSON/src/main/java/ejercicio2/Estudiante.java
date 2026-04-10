package ejercicio2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private String curso;
    private double notaMedia;

    public Estudiante(String nombre, String curso, double notaMedia) {
        this.nombre = nombre;
        this.curso = curso;
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Estudiante{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", curso='").append(curso).append('\'');
        sb.append(", notaMedia=").append(notaMedia);
        sb.append('}');
        return sb.toString();
    }

    static void main(String[] args) {

        Estudiante e1 = new Estudiante("e1", "1dam", 7.65);
        Estudiante e3 = new Estudiante("e2", "1dam", 7.65);
        Estudiante e2 = new Estudiante("e3", "1dam", 7.65);
        List<Estudiante> estudiantes = List.of(e1,e2,e3);

        Path path = Path.of("src/main/java/ejercicio2/estudiantes.json");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(estudiantes);

        try {
            Files.writeString(path,json, StandardOpenOption.CREATE);

            Type tipoLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();

            List<Estudiante> estudiantes1 = gson.fromJson(Files.newBufferedReader(path),tipoLista);

            System.out.println(estudiantes1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
