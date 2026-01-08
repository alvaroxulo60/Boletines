package ejercicio3;

import exceptions.PersonajeExecption;

public class Personaje {
    private String nombre;
    private Raza raza;
    private int fuerza;
    private int inteligencia;
    private final int VIDA_MAX;
    private int vidaActual;

    public Personaje(String nombre, String raza, int fuerza, int inteligencia, int vidaMax, int vidaActual) throws PersonajeExecption {
        this.nombre = nombre;
        setRaza(raza);
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        if (vidaMax < 0 || vidaMax > 100) {
            throw new PersonajeExecption("La vida máxima introducida no es válida.");
        }
        this.VIDA_MAX = vidaMax;
        this.vidaActual=VIDA_MAX;
    }

    private void setRaza(String raza) {
        this.raza = Raza.valueOf(raza.toUpperCase());
    }

    private void setFuerza(int fuerza)throws PersonajeExecption {
        if (fuerza<0 || fuerza>20){
            throw new PersonajeExecption("La fuerza introducida no es válida");
        }
            this.fuerza = fuerza;
    }

    private void setInteligencia(int inteligencia)throws PersonajeExecption {
        if (inteligencia<0 || inteligencia>20){
            throw new PersonajeExecption("La inteligencia introducida no es válida");
        }
        this.inteligencia = inteligencia;
    }

    public void modificarVidaActual(int modificacion) throws PersonajeExecption {
        if (vidaActual<0){
            throw new PersonajeExecption("Este personaje esta muerto...");
        }
        if (vidaActual+modificacion>VIDA_MAX){
            throw new PersonajeExecption("Este personaje no puede ser curado, su vida esta al máximo");
        }
        this.vidaActual += modificacion;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", VIDA_MAX=" + VIDA_MAX +
                ", vidaActual=" + vidaActual +
                '}';
    }
}
