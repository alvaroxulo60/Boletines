package ejercicio3;

import exceptions.MiEntradaSalidaException;
import exceptions.PersonajeException;
import utils.MiEntradaSalida;

import java.util.Arrays;
import java.util.Comparator;

public class Juego {
    static final int TAM_ARRAY_JUGADORES = 100;


    public static void main(String[] args) {
        Personaje[] jugadores = new Personaje[TAM_ARRAY_JUGADORES];
        boolean interactuando = true;
        int magoElegido;
        String hechizo;
        int jugadorElegido;
        int clerigoElegido;

        System.out.println("Bienvenido al juego. Estas son tus opciones: ");

        while (interactuando) {
            try {
                System.out.println("""
                \t 1. Alta de personaje\s
                \t 2. Mago aprende hechizo\s
                \t 3. Mago lanza hechizo\s
                \t 4. Clérigo cura al mago\s
                \t 5. Mostrar el listado de personajes\s
                \t 6. Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor\s
                \t 7. Salir\s
                """);
                int opcion = MiEntradaSalida.leerEnteroRango("¿Que quieres hacer?", 1, 7);
                switch (opcion) {
                    case 1:
                        String personaje = MiEntradaSalida.leerLinea("¿A que personaje deseas crear? (Mago o Clérigo)\n");
                        Personaje p = switch (personaje.toLowerCase()) {
                            case "mago" ->{
                                System.out.println("Creando mago...\n");
                                yield crearMago();
                            }
                            case "clérigo" ->{
                                System.out.println("Creando clérigo...\n");
                                yield crearClerigo();
                            }
                            default -> null;
                        };
                        for (int i = 0; i < jugadores.length; i++) {
                            if (jugadores[i] == null) {
                                jugadores[i] = p;
                                break;
                            }
                        }
                        break;
                    case 2:
                        mostrarMagos(jugadores);
                        magoElegido = MiEntradaSalida.leerEntero("Introduce el numero del mago a el cual quieras enseñarle el hechizo: ");
                        if (jugadores[magoElegido] instanceof Mago m) {
                            hechizo = MiEntradaSalida.leerLinea("¿Que hechizo quieres enseñarle?\n");
                            m.aprenderHechizo(hechizo);
                            System.out.println("Hecho!\n");
                        }
                        else System.out.println("¡Eso no es un mago!");
                        break;
                    case 3:
                        mostrarMagos(jugadores);
                        magoElegido = MiEntradaSalida.leerEntero("Introduce el numero del mago el cual quieras que use un hechizo: ");
                        if (jugadores[magoElegido] instanceof Mago m) {
                            m.mostrarHechizos();
                            hechizo = MiEntradaSalida.leerLinea("¿Que hechizo quieres utilizar?");
                            for (int i = 0; i < jugadores.length; i++) {
                                if (jugadores[i] != null) {
                                    System.out.println(i + "." + " " + jugadores[i]);
                                } else {
                                    System.out.println("No quedan mas jugadores por mostrar");
                                    break;
                                }
                            }
                            jugadorElegido = MiEntradaSalida.leerEntero("Introduce el índice del personaje al cual quieres atacar: ");
                            if (m.equals(jugadores[jugadorElegido])) {
                                System.out.println("¡No puedes atacarte a ti mismo, Tonto!");
                            } else {
                                m.lanzarHechizos(jugadores[jugadorElegido], hechizo);
                                System.out.println("Hecho!");
                            }
                        }
                        else System.out.println("¡Eso no es un mago!");
                        break;
                    case 4:
                        mostrarClerigos(jugadores);
                        clerigoElegido = MiEntradaSalida.leerEntero("Introduce el índice del mago que quieras utilizar: ");
                        if (jugadores[clerigoElegido] instanceof Clerigo c){
                            mostrarMagosYMuertos(jugadores);
                            magoElegido=MiEntradaSalida.leerEntero("Introduce el numero del mago al cual quieras curar: ");
                            c.curar(jugadores[magoElegido]);
                            System.out.println("¡Hecho!");
                        }
                        else System.out.println("¡Eso no es un Clérigo!");
                        break;
                    case 5:
                        MiEntradaSalida.mostrarOpcionesSinNulos("Aquí tienes todos los jugadores activos: ", jugadores);
                        break;
                    case 6:
                        System.out.println("Esta en desarrollo...");
                        //
                        //Personaje[] copia = Arrays.copyOf(jugadores,TAM_ARRAY_JUGADORES);
                        //Arrays.sort(copia, Comparator.comparingInt(Personaje::getVidaActual).reversed());
                        // int contador = 0;
                        //for (Personaje pe : copia){
                        //    if (pe != null){
                        //        System.out.println(contador++ +" " + pe.getNombre());
                        //    }
                        //}

                        break;
                    case 7:
                        interactuando = false;
                        break;
                }
            } catch (MiEntradaSalidaException | PersonajeException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static Mago crearMago() {
        Mago aux = null;
        boolean creado = false;
        while (!creado) {
            String nombre = MiEntradaSalida.leerLinea("Introduzca el nombre del mago: \n");
            String raza = MiEntradaSalida.leerLinea("Introduzca la raza (Humano, enano, orco o elfo): \n");
            int fuerza = MiEntradaSalida.leerEntero("Introduce la fuerza del mago (<15): ");
            int inteligencia = MiEntradaSalida.leerEntero("Introduce la inteligencia del mago (>17 y <20): ");
            int vidaMax = MiEntradaSalida.leerEntero("Introduzca la vida máxima: ");
            try {
                aux = new Mago(nombre, raza, fuerza, inteligencia, vidaMax);
                creado = true;
            } catch (PersonajeException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return aux;
    }

    public static Clerigo crearClerigo() {
        Clerigo aux = null;
        boolean creado = false;
        while (!creado) {
            String nombre = MiEntradaSalida.leerLinea("Introduzca el nombre del Clérigo: \n");
            String raza = MiEntradaSalida.leerLinea("Introduzca la raza (Humano, enano, orco o elfo): \n");
            int fuerza = MiEntradaSalida.leerEntero("Introduce la fuerza del Clérigo (>18): ");
            int inteligencia = MiEntradaSalida.leerEntero("Introduce la inteligencia del Clérigo (>12 y <16): ");
            int vidaMax = MiEntradaSalida.leerEntero("Introduzca la vida máxima: ");
            String dios = MiEntradaSalida.leerLinea("Introduce el nombre de tu dios: \n");
            try {
                aux = new Clerigo(nombre, raza, fuerza, inteligencia, vidaMax, dios);
                creado = true;
            } catch (PersonajeException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return aux;
    }

    public static void mostrarMagos(Personaje[] jugadores){
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i]!= null) {
                if (jugadores[i] instanceof Mago) {
                    System.out.println(i + "." + " " + jugadores[i].getNombre());
                } else
                    System.out.println("Eso no es un mago.");
            }
        }
    }

    public static void mostrarClerigos(Personaje[] jugadores){
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i]!= null) {
                if (jugadores[i] instanceof Clerigo) {
                    System.out.println(i + "." + " " + jugadores[i].getNombre());
                } else
                    System.out.println("Eso no es un Clérigo");
            }
        }
    }

    public static void mostrarMagosYMuertos(Personaje[] jugadores){
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i]!= null) {
                if (jugadores[i] instanceof Mago || jugadores[i].getVidaActual() <= 0) {
                    System.out.println(i + "." + " " + jugadores[i].getNombre());
                }
            }
        }
    }


}
