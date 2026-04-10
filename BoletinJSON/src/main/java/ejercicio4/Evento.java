package ejercicio4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class Evento {
    private String nombre;
    private LocalDate fecha;

    public Evento(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Evento{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Evento e = new Evento("Coachella", LocalDate.of(2026,4,10));

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();

        String json  = gson.toJson(e);

        Path path = Path.of("src/main/java/ejercicio4/evento.json");
        try {
            Files.writeString(path,json, StandardOpenOption.CREATE);

            Evento e1 = gson.fromJson(Files.newBufferedReader(path),Evento.class);

            System.out.println(e1.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
