package ejercicio3;

import exceptions.PersonajeExecption;

public class Clerigo extends Personaje{
    public static final int CURACION = 10;
    private final String NOMBRE_DIOS;


    public Clerigo(String nombre, String raza, int fuerza, int inteligencia, int vidaMax, int vidaActual,String nombreDios) throws PersonajeExecption {
        if (fuerza<18){
            throw new PersonajeExecption("Ese valor de fuerza no es válido");
        }
        if (inteligencia<12 || inteligencia >18){
            throw new PersonajeExecption("Ese valor de inteligencia no es válido");
        }
        super(nombre, raza, fuerza, inteligencia, vidaMax, vidaActual);
        this.NOMBRE_DIOS=nombreDios;
    }

    public void curar(Personaje p) throws PersonajeExecption {
        p.modificarVidaActual(CURACION);
    }
}
