package ejercicio3;

import exceptions.PersonajeExecption;
import utils.MiEntradaSalida;

public class Juego {
    static final int TAM_ARRAY_JUGADORES = 100;


    public static void main(String[] args) {
         Personaje[] jugadores = new Personaje[TAM_ARRAY_JUGADORES];


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
            } catch (PersonajeExecption e) {
                System.out.println(e.getMessage());
            }
        }
        return aux;
    }

    public static Clerigo crearClerigo(){

    }
}
