package ejercicio7;

import exceptions.MiEntradaSalidaException;
import io.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class MenuFicheros {
    public static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            try {
                opcion = MiEntradaSalida.leerEnteroRango("", 1, 6);


                switch (opcion) {
                    case 1:
                        System.out.println("Opción 1: Listar directorio");
                        opcion1();
                        break;
                    case 2:
                        System.out.println("Opción 2: Listar con prefijo");
                        opcion2();
                        break;
                    case 3:
                        System.out.println("Opción 3: Listar por extensión");
                        opcion3();
                        break;
                    case 4:
                        System.out.println("Opción 4: Buscar archivo simple");
                        opcion4();
                        break;
                    case 5:
                        System.out.println("Opción 5: Buscar recursivo");
                        opcion5();
                        break;
                    case 6:
                        System.out.println("¡Saliendo del programa!");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (MiEntradaSalidaException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ DE GESTIÓN DE DIRECTORIOS ===");
        System.out.println("1. Listar directorio");
        System.out.println("2. Listar directorio y buscar ficheros que comiencen por una palabra");
        System.out.println("3. Listar archivos con cierta extensión de un directorio");
        System.out.println("4. Buscar un archivo en un directorio");
        System.out.println("5. Buscar recursivamente un archivo en un directorio");
        System.out.println("6. Salir");
        System.out.println("=====================================");
    }

    public static void opcion1(){
        String nombreDirectorio = MiEntradaSalida.leerLinea("Introduce el nombre del directorio: ");
        Path ruta = Path.of(nombreDirectorio);

        try(Stream<Path> lista = Files.walk(ruta,5)){
            lista.forEach(p -> {
                if (Files.isDirectory(p)) {
                    System.out.printf("%s - Directorio %n", p.getFileName());
                } else {
                    try {
                        System.out.printf("%s %.2f KB %n", p.getFileName(), Files.size(p) / 1024.0);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    };
                }
            });
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void opcion2() {
        String palabra = MiEntradaSalida.leerLinea("¿Por cual palabra quieres buscar? \n");
        Path ruta = Path.of(MiEntradaSalida.leerLinea("Introduce la ruta al directorio: \n"));
        if (Files.isDirectory(ruta)) {
            try (Stream<Path> lista = Files.list(ruta)) {
                lista.filter(p -> p.getFileName().toString().startsWith(palabra))
                        .forEach(p -> {
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
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void opcion3() {
        String extension = MiEntradaSalida.leerLinea("¿Por cual extension quieres buscar? (sin el punto) \n");
        Path ruta = Path.of(MiEntradaSalida.leerLinea("Introduce la ruta al directorio: \n"));
        if (Files.isDirectory(ruta)) {
            try (Stream<Path> lista = Files.list(ruta)) {
                lista.filter(p -> p.getFileName().toString().endsWith("." + extension))
                        .forEach(p -> {
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
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void opcion4(){
        String nombreArchivo = MiEntradaSalida.leerLinea("Introduce el nombre del archivo: ");
        String nombreDirectorio = MiEntradaSalida.leerLinea("Introduce el nombre del directorio: ");

        Path ruta = Path.of(nombreDirectorio);

        try (Stream<Path> lista = Files.find(ruta,1, (path,attributes) -> {
            return path.getFileName().toString().equals(nombreArchivo);
        })) {
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void opcion5(){
        String nombreArchivo = MiEntradaSalida.leerLinea("Introduce el nombre del archivo: ");
        String nombreDirectorio = MiEntradaSalida.leerLinea("Introduce el nombre del directorio: ");

        Path ruta = Path.of(nombreDirectorio);

        try (Stream<Path> lista = Files.walk(ruta)){
            lista.filter(p-> p.getFileName().toString().equals(nombreArchivo))
                    .forEach(p -> {
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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
