package boletin4_3.ejercicio2;

import exceptions.MensajeExceptions;

import java.time.LocalDateTime;

public class Persona2 {
    public static int CAPACIDAD_BUZONES = 5;
    private String nombre;
    private Mensaje[] buzonMensajesRecibidos = new Mensaje[CAPACIDAD_BUZONES];
    private Mensaje[] buzonMensajesEnviados = new Mensaje[CAPACIDAD_BUZONES];


    public Persona2(String nombre) {
        setNombre(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void enviarMensaje(String asunto, String cuerpo, Persona2 persona2) throws MensajeExceptions {
        if (this.equals(persona2)) {
            throw new MensajeExceptions("No te puedes enviar un mensaje a ti mismo");
        }
        if (asunto.isBlank()) {
            throw new MensajeExceptions("El mensaje no tiene asunto");
        }
        if (persona2 == null) {
            throw new MensajeExceptions("No hay un destinatario");
        }
        if (cuerpo.isBlank()) {
            throw new MensajeExceptions("El mensaje no tiene cuerpo");
        }
        if (buzonMensajesEnviados[4] != null) {
            throw new MensajeExceptions("Tienes el buzon lleno");
        }
        if (persona2.buzonMensajesRecibidos[4] != null) {
            throw new MensajeExceptions("El destinatario tiene el buzon lleno");
        }
        Mensaje mensaje=new Mensaje(asunto,cuerpo,LocalDateTime.now(),this,persona2);

        for (int i = 0; i < buzonMensajesEnviados.length; i++) {
            if (buzonMensajesEnviados[i] == null) {
                buzonMensajesEnviados[i] = mensaje;
                break;
            }
        }
        for (int i = 0; i < persona2.buzonMensajesRecibidos.length; i++) {
            if (persona2.buzonMensajesRecibidos[i] == null) {
                persona2.buzonMensajesRecibidos[i] = mensaje;
                break;
            }
        }
    }

    public void borrarMensajeEnviadoMásAntiguo() throws MensajeExceptions {
        if (buzonMensajesEnviados[0] == null) {
            throw new MensajeExceptions("El buzon esta vacío");
        }
        for (int i = 0; i < buzonMensajesEnviados.length - 1 && buzonMensajesEnviados[i] != null; i++) {
            buzonMensajesEnviados[i] = buzonMensajesEnviados[i + 1];
        }
        buzonMensajesEnviados[buzonMensajesEnviados.length - 1] = null;
    }

    public void borrarMensajeRecibidoMásAntiguo() throws MensajeExceptions {
        if (buzonMensajesRecibidos[0] == null) {
            throw new MensajeExceptions("El buzon esta vacío");
        }
        for (int i = 0; i < buzonMensajesRecibidos.length - 1 && buzonMensajesRecibidos[i] != null; i++) {
            buzonMensajesRecibidos[i]=buzonMensajesRecibidos[i+1];
        }
        buzonMensajesRecibidos[buzonMensajesRecibidos.length-1]=null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Persona2 persona2 = (Persona2) o;
        return nombre.equals(persona2.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
