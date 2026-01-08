package ejercicio3;

import exceptions.PersonajeExecption;

public class Main {
    try{
        Mago A = new Mago("Javier", "enano",16, );
        Mago B = new Mago();
        Clerigo C = new Clerigo();
    }catch(PersonajeExecption e){
        System.out.println(e.getMessage());
    }
}
