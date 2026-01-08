package ejercicio3;

import exceptions.PersonajeExecption;

import java.util.Arrays;

public class Mago extends Personaje {
    public static final int DAÑO = -10;
    public static final int TAM_ARRAY_DE_HECHIZOS = 4;

    Hechizo[] hechizos = new Hechizo[TAM_ARRAY_DE_HECHIZOS];


    public Mago(String nombre, String raza, int fuerza, int inteligencia, int vidaMax) throws PersonajeExecption {
        if (fuerza > 15) {
            throw new PersonajeExecption("Un mago no puede tener mas de 15 de fuerza");
        }
        if (inteligencia < 17) {
            throw new PersonajeExecption("Un mago no puede tener menos de 17 de inteligencia");
        }
        super(nombre, raza, fuerza, inteligencia, vidaMax);
    }

    public void aprenderHechizo(String hechizo) throws PersonajeExecption {
        Hechizo h = new Hechizo(hechizo);
        int contador = 0;
        for (int i = 0; i <TAM_ARRAY_DE_HECHIZOS; i++) {
            if (hechizos[i] != null) {
                contador++;
            }
        }
        if (contador == TAM_ARRAY_DE_HECHIZOS){
            throw new PersonajeExecption("Este mago no puede aprender mas hechizos");
        }
        for (int i = 0; i < TAM_ARRAY_DE_HECHIZOS; i++) {

            if (hechizos[i] == null) {
                hechizos[i] = h;
                return;
            }
        }
    }

    public void lanzarHechizos(Personaje p, String s) throws PersonajeExecption {
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i]!=null) {
                if (hechizos[i].getNombre().equalsIgnoreCase(s)) {
                    hechizos[i] = null;
                    p.modificarVidaActual(DAÑO);
                    return;
                }
            }
        }
        throw new PersonajeExecption("Ese hechizo no es válido o el mago no lo conoce");
    }

    @Override
    public String toString() {
        return super.toString()+" Mago{" +
                "hechizos=" + Arrays.toString(hechizos) +
                '}';
    }
}
