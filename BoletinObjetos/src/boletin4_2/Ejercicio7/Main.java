package boletin4_2.Ejercicio7;

import exceptions.JarraExceptions;
import utils.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        Jarra jarraA = null;
        Jarra jarraB = null;
        boolean activo = true;
        System.out.println("Bienvenido al juego de las jarras.\n");
        int capacidadJarraA = MiEntradaSalida.leerEntero("Capacidad de la primera jarra: \n");
        try{
            jarraA = new Jarra(capacidadJarraA);
        }catch (JarraExceptions e){
            System.out.println(e.getMessage());
        }
        int capacidadJarraB = MiEntradaSalida.leerEntero("Capacidad de la segunda jarra: \n");
        try{
            jarraB = new Jarra(capacidadJarraB);
        }catch (JarraExceptions e){
            System.out.println(e.getMessage());
        }
        System.out.println("Muy bien. Esto es lo que puedes hacer ahora: ");
        System.out.println("* Llenar jarra. \n" +
                "Vaciar jarra. \n" +
                "Volcar jarra A en B. \n" +
                "Volcar jarra B en A. \n" +
                "Ver estado de las jarras. \n" +
                "salir.");
        while (activo){
            String accion = MiEntradaSalida.leerLinea("¿Que vas a hacer?");
            switch (accion.toLowerCase()){
                case "llenar jarra":

            }
        }
    }


    public static String elegirJarra(){
        return MiEntradaSalida.leerLinea("¿Que jarra vas a utilizar? (A/B)");

    }
}
