package ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String dni;
    private int telefono;

    public Cliente(String nombre, String dni, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    static void main(String[] args) {
        Cliente c1 = new Cliente("Jose", "12345678T",123456789);
        Cliente c2 = new Cliente("Juan", "92823864L",254145562);
        Cliente c3 = new Cliente("Moisés", "78373987H",698589654);
        Cliente c4 = new Cliente("Lolo", "353544636M",333696654);
        Cliente c5 = new Cliente("Carlos", "36572383X",999999999);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

       List<Cliente> clientes = List.of(c1,c2,c3,c4,c5);

       String json = gson.toJson(clientes);

       Path path = Path.of("src/main/java/ejercicio1/salidas.json");

       try {
           Files.writeString(path,json,StandardOpenOption.CREATE);
       } catch (IOException e) {
           System.out.println(e.getMessage());
       }


    }
}
