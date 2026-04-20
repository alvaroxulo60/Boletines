package ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Videojuego {
    private String titulo;
    private String desarrolladora;
    private int anioLanzamiento;

    public Videojuego(String titulo, String desarrolladora, int anioLanzamiento) {
        setTitulo(titulo);
        setDesarrolladora(desarrolladora);
        setAnioLanzamiento(anioLanzamiento);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Videojuego{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", desarrolladora='").append(desarrolladora).append('\'');
        sb.append(", anioLanzamiento=").append(anioLanzamiento);
        sb.append('}');
        return sb.toString();
    }

    static void main(String[] args) {
        Videojuego v = new Videojuego("Resident Evil Requiem","CapCom", 2026);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(v);

        System.out.println(json);

        Path path = Path.of("src/main/java/ejercicio1/Videojuego.json");

        try {
            Files.writeString(path,json, StandardOpenOption.CREATE);

            Videojuego videojuego = gson.fromJson(Files.newBufferedReader(path), Videojuego.class);

            System.out.println(videojuego.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
