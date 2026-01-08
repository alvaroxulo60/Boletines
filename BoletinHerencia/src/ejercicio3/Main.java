package ejercicio3;

import exceptions.PersonajeExecption;

public class Main {
    public static void main(String[] args) {
        try {
            Mago a = new Mago("Javier", "enano", 15, 17, 100);
            Mago b = new Mago("Daniel", "elfo", 14, 18, 80);
            Clerigo c = new Clerigo("Álvaro", "humano", 18, 15, 100, "Flins");

            System.out.println(a.toString());
            System.out.println();
            System.out.println(b.toString());
            System.out.println();
            System.out.println(c.toString());
            System.out.println();
            System.out.println("          Cambio               ");
            System.out.println();
            a.aprenderHechizo("Doom");
            a.aprenderHechizo("Leviosa");
            b.aprenderHechizo("Freeze");
            System.out.println(a.toString());
            System.out.println();
            System.out.println(b.toString());
            System.out.println();
            System.out.println("          Cambio               ");
            System.out.println();
            a.lanzarHechizos(b,"Doom");
            b.lanzarHechizos(a,"Freeze");
            c.curar(b);
            a.lanzarHechizos(b,"Leviosa");
            System.out.println(a.toString());
            System.out.println();
            System.out.println(b.toString());
            System.out.println();;



        }
        catch(PersonajeExecption e){
            System.out.println(e.getMessage());
        }
    }



}