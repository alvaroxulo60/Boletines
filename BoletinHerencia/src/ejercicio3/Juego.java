package ejercicio3;

import exceptions.MiEntradaSalidaException;
import exceptions.PersonajeException;
import utils.MiEntradaSalida;

public class Juego {
    static final int TAM_ARRAY_JUGADORES = 100;


    public static void main(String[] args) {
         Personaje[] jugadores = new Personaje[TAM_ARRAY_JUGADORES];
         boolean interactuando = true;

        System.out.println("""
                Bienvenido al juego. Estas son tus opciones: \
                \t 1. Alta de personaje\s
                \t 2. Mago aprende hechizo\s
                \t 4. Mago lanza hechizo\s
                \t 4. Clérigo cura al mago\s
                \t 5. Mostrar el listado de personajes\s
                \t 6. Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor\s
                \t 7. Salir\s
                """);

        while (interactuando){
            try {
                int opcion = MiEntradaSalida.leerEnteroRango("¿Que quieres hacer?",1,7)-1;
                switch (opcion){
                    case 1:
                        String personaje = MiEntradaSalida.leerLinea("¿A que personaje deseas crear? (Mago o Clérigo)");
                        Personaje p = switch (personaje.toLowerCase()){
                            case "mago" -> crearMago();
                            case "clerigo" -> crearClerigo();
                            default -> null;
                        };
                        for (int i = 0; i < jugadores.length; i++) {
                            if (jugadores[i]!=null){
                                jugadores[i]=p;
                            }
                        }
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:
                        interactuando = false;
                        break;
                }
            } catch (MiEntradaSalidaException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static Mago crearMago(){
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
                creado= true;
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
            }
        }
        return aux;
    }

    public static Clerigo crearClerigo(){
        Clerigo aux = null;
        boolean creado = false;
        while (!creado) {
            String nombre = MiEntradaSalida.leerLinea("Introduzca el nombre del mago: \n");
            String raza = MiEntradaSalida.leerLinea("Introduzca la raza (Humano, enano, orco o elfo): \n");
            int fuerza = MiEntradaSalida.leerEntero("Introduce la fuerza del mago (<15): ");
            int inteligencia = MiEntradaSalida.leerEntero("Introduce la inteligencia del mago (>17 y <20): ");
            int vidaMax = MiEntradaSalida.leerEntero("Introduzca la vida máxima: ");
            String dios = MiEntradaSalida.leerLinea("Introduce el nombre de tu dios: ");
            try {
                aux = new Clerigo(nombre, raza, fuerza, inteligencia, vidaMax,dios);
                creado= true;
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
            }
        }
        return aux;
    }
}
