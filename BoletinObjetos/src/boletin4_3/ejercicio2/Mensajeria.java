package boletin4_3.ejercicio2;

import exceptions.MensajeExceptions;
import exceptions.MiEntradaSalidaException;
import utils.MiEntradaSalida;

public class Mensajeria {

    public static void main(String[] args) {
        Persona2 p1 = new Persona2("Carlos");
        Persona2 p2 = new Persona2("Álvaro");
        boolean enviando = true;
        boolean opcionEscogida = false;

        System.out.println("Puedes: \n" +
                "\tEnviar mensaje\n" +
                "\tBorrar mensaje enviado antiguo\n" +
                "\tBorrar mensaje recibido antiguo\n" +
                "\tSalir\n");

        while (enviando) {
            int opcion = 0;
            while (!opcionEscogida) {
                try {
                    opcion = MiEntradaSalida.leerEnteroRango("¿Que vas a hacer?", 1, 4);
                    opcionEscogida = true;
                } catch (MiEntradaSalidaException e) {
                    System.out.println(e.getMessage());
                }
            }
            switch (opcion) {
                case 1:
                    Mensaje m1 = crearMensaje(p2);
                    try {
                        p1.enviarMensaje(m1,p2);
                        System.out.println("Hecho\n");
                    } catch (MensajeExceptions e) {
                        System.out.println(e.getMessage());
                    }
                    opcionEscogida=false;
                    break;
                case 2:
                    try {
                        p1.borrarMensajeEnviadoMásAntiguo();
                        System.out.println("Hecho\n");
                    } catch (MensajeExceptions e) {
                        System.out.println(e.getMessage());
                    }
                    opcionEscogida=false;
                    break;
                case 3:
                    try {
                        p1.borrarMensajeRecibidoMásAntiguo();
                        System.out.println("Hecho");
                    } catch (MensajeExceptions e) {
                        System.out.println(e.getMessage());
                    }
                    opcionEscogida=false;
                    break;
                case 4:
                    enviando=false;
                    break;
            }
        }
    }

    public static Mensaje crearMensaje(Persona2 p2){
        String asunto = MiEntradaSalida.leerLinea("Introduce el asunto del mensaje: \n");
        String cuerpo = MiEntradaSalida.leerLinea("Introduce el cuerpo del mensaje: \n");
        return new Mensaje(asunto,cuerpo,p2);
    }
}
