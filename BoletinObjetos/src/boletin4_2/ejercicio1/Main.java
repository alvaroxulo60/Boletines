package boletin4_2.ejercicio1;

import java.time.LocalDate;

public class Main {
    public static void main() {
        Persona persona1 = new Persona("Álvaro", LocalDate.of(2007,3,9),29624345,'M', 1.75F,100F);

        System.out.print(persona1.getNombre()+" nacio el "+ persona1.getFechaNacimiento()+", con dni: "+ persona1.getDni()+ persona1.getLetraDni()+", de sexo " +
                persona1.getSexo()+", con altura "+ persona1.getAltura()+ ", con peso "+ persona1.getPeso()+ ", y con indice de masa corporal "+ persona1.getIMC());
    }
}
