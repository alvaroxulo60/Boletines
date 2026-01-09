package ejercicio3;

import exceptions.PersonajeException;

import java.util.Arrays;

public class Mago extends Personaje {
    public static final int DAÑO = -10;
    public static final int TAM_ARRAY_DE_HECHIZOS = 4;
    private Hechizo[] hechizos;



    public Mago(String nombre, String raza, int fuerza, int inteligencia, int vidaMax) throws PersonajeException {
        if (fuerza > 15) {
            throw new PersonajeException("Un mago no puede tener mas de 15 de fuerza");
        }
        if (inteligencia < 17) {
            throw new PersonajeException("Un mago no puede tener menos de 17 de inteligencia");
        }
        super(nombre, raza, fuerza, inteligencia, vidaMax);
        hechizos= new Hechizo[TAM_ARRAY_DE_HECHIZOS];
    }

    public void aprenderHechizo(String hechizo) throws PersonajeException {
        Hechizo h = new Hechizo(hechizo);
        int contador = 0;
        for (int i = 0; i <TAM_ARRAY_DE_HECHIZOS; i++) {
            if (hechizos[i] != null) {
                contador++;
            }
        }
        if (contador == TAM_ARRAY_DE_HECHIZOS){
            throw new PersonajeException("Este mago no puede aprender mas hechizos");
        }
        for (int i = 0; i < TAM_ARRAY_DE_HECHIZOS; i++) {

            if (hechizos[i] == null) {
                hechizos[i] = h;
                return;
            }
        }
    }

    public void lanzarHechizos(Personaje p, String s) throws PersonajeException {
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i]!=null) {
                if (hechizos[i].getNombre().equalsIgnoreCase(s)) {
                    hechizos[i] = null;
                    p.modificarVidaActual(DAÑO);
                    return;
                }
            }
        }
        throw new PersonajeException("Ese hechizo no es válido o el mago no lo conoce");
    }

    public void mostrarHechizos(){
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i]!=null){
                System.out.println("· "+hechizos[i].getNombre());
            }
        }
    }


    @Override
    public String toString() {
        return super.toString()+" Mago{" +
                "hechizos=" + Arrays.toString(hechizos) +
                '}';
    }
}
